package codyhuh.theblueportal.core.common.entities.base;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl;
import net.minecraft.world.entity.ai.control.SmoothSwimmingMoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Bucketable;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;

import javax.annotation.Nullable;

public abstract class TBPFishAnimal extends WaterAnimal implements Bucketable, IHasVariants {
    private static final EntityDataAccessor<Integer> VARIANT = SynchedEntityData.defineId(TBPFishAnimal.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> FROM_BUCKET = SynchedEntityData.defineId(TBPFishAnimal.class, EntityDataSerializers.BOOLEAN);
    public float currentRoll = 0.0F;

    /// CORE ///

    protected TBPFishAnimal(EntityType<? extends WaterAnimal> type, Level level) {
        super(type, level);
        this.moveControl = new SmoothSwimmingMoveControl(this, 20, 10, 0.02F, 0.1F, true);
        this.lookControl = new SmoothSwimmingLookControl(this, 10);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 5.0D);
    }

    /// BEHAVIOR ///

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(2, new RandomSwimmingGoal(this, swimSpeed(), swimFrequency()));
        this.goalSelector.addGoal(2, new AvoidEntityGoal<>(this, Player.class, 8.0F, 1.6D, 1.4D, (mob) -> isSkittish()));
    }

    public double swimSpeed() {
        return 1.0D;
    }

    public int swimFrequency() {
        return 40;
    }

    protected boolean isSkittish() {
        return true;
    }

    public static boolean canSpawn(EntityType<WaterAnimal> type, LevelAccessor level, MobSpawnType reason, BlockPos pos, RandomSource random) {
        return WaterAnimal.checkSurfaceWaterAnimalSpawnRules(type, level, reason, pos, random);
    }

    /// FLOPPING ///

    public void aiStep() {
        if (shouldFlop()) {
            if (!this.isInWater() && this.onGround() && this.verticalCollision) {
                this.setDeltaMovement(this.getDeltaMovement().add(((this.random.nextFloat() * 2.0F - 1.0F) * 0.05F), 0.4F, ((this.random.nextFloat() * 2.0F - 1.0F) * 0.05F)));
                this.setOnGround(false);
                this.hasImpulse = true;
                this.playSound(this.getFlopSound(), this.getSoundVolume(), this.getVoicePitch());
            }
        }

        float prevRoll =  this.currentRoll;
        float targetRoll = Math.max(-0.45F, Math.min(0.45F, (this.getYRot() - this.yRotO) * 0.1F));
        targetRoll = -targetRoll;
        this.currentRoll = prevRoll + (targetRoll - prevRoll) * 0.05F;

        super.aiStep();
    }

    protected SoundEvent getFlopSound() {
        return SoundEvents.COD_FLOP;
    }

    protected boolean shouldFlop() {
        return true;
    }

    /// INTERACTION ///

    protected InteractionResult mobInteract(Player player, InteractionHand hand) {
        return Bucketable.bucketMobPickup(player, hand, this).orElse(super.mobInteract(player, hand));
    }

    /// DATA ///

    @Override
    public void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(VARIANT, 0);
        this.entityData.define(FROM_BUCKET, false);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);

        compound.putBoolean("FromBucket", this.fromBucket());

        if (hasVariants()) {
            compound.putInt("Variant", getVariant());
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);

        this.setFromBucket(compound.getBoolean("FromBucket"));

        if (hasVariants()) {
            setVariant(compound.getInt("Variant"));
        }
    }

    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
        if (hasVariants()) {
            if (dataTag == null) {
                setVariant(random.nextInt(maxVariant() + 1));
            }
            else {
                if (dataTag.contains("Variant", 3)){
                    this.setVariant(dataTag.getInt("Variant"));
                }
            }
        }

        return spawnDataIn;
    }

    /// VARIANTS ///

    @Override
    public boolean hasVariants() {
        return false;
    }

    @Override
    public int getVariantI() {
        return getVariant();
    }

    @Override
    public int maxVariant() {
        return 0;
    }

    public int getVariant() {
        return this.entityData.get(VARIANT);
    }

    private void setVariant(int variant) {
        this.entityData.set(VARIANT, variant);
    }

    /// BUCKETING ///

    @Override
    public void saveToBucketTag(ItemStack bucket) {
        CompoundTag tag = bucket.getOrCreateTag();

        tag.putInt("Variant", this.getVariant());
        tag.putFloat("Health", this.getHealth());

        if (this.hasCustomName()) {
            bucket.setHoverName(this.getCustomName());
        }
    }

    @Override
    public void loadFromBucketTag(CompoundTag pTag) {
    }

    public boolean requiresCustomPersistence() {
        return super.requiresCustomPersistence() || this.fromBucket();
    }

    public boolean removeWhenFarAway(double distance) {
        return !this.fromBucket() && !this.hasCustomName();
    }

    @Override
    public boolean fromBucket() {
        return this.entityData.get(FROM_BUCKET);
    }

    public void setFromBucket(boolean fromBucket) {
        this.entityData.set(FROM_BUCKET, fromBucket);
    }

    @Override
    public SoundEvent getPickupSound() {
        return SoundEvents.BUCKET_FILL_FISH;
    }

    @Override
    public ItemStack getBucketItemStack() {
        return getBucketStack();
    }

    public abstract ItemStack getBucketStack();
}
