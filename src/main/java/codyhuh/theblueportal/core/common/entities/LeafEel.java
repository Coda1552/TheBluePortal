package codyhuh.theblueportal.core.common.entities;

import codyhuh.theblueportal.core.common.entities.base.TBPFishAnimal;
import codyhuh.theblueportal.core.registry.ModItems;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class LeafEel extends TBPFishAnimal {
    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState swimAnimationState = new AnimationState();

    public LeafEel(EntityType<? extends TBPFishAnimal> type, Level level) {
        super(type, level);
    }

    @Override
    public void tick() {
        if (this.level().isClientSide()) {
            this.setupAnimationStates();
        }

        super.tick();
    }

    @Override
    public int swimFrequency() {
        return 80;
    }

    @Override
    public double swimSpeed() {
        return 2.0D;
    }

    private void setupAnimationStates() {
        this.idleAnimationState.animateWhen(!this.walkAnimation.isMoving() && this.isInWaterOrBubble(), this.tickCount);
        this.swimAnimationState.animateWhen(this.walkAnimation.isMoving() && this.isInWaterOrBubble(), this.tickCount);
    }

    @Override
    protected boolean isSkittish() {
        return false;
    }

    @Override
    public ItemStack getBucketStack() {
        return new ItemStack(ModItems.LEAF_EEL_BUCKET.get());
    }

    @Override
    public boolean hasVariants() {
        return true;
    }

    @Override
    public int maxVariant() {
        return 8;
    }

    @Override
    protected boolean shouldFlop() {
        return getVariantI() > 0;
    }
}
