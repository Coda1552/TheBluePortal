package codyhuh.theblueportal.core.common.items;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.MobBucketItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Supplier;

public class TBPBucketItem extends MobBucketItem {
    private final boolean hasTooltip;

    public TBPBucketItem(Supplier<? extends EntityType<?>> type, boolean tooltip) {
        this(type, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, tooltip, new Item.Properties().stacksTo(1));
    }

    public TBPBucketItem(Supplier<? extends EntityType<?>> type, Supplier<? extends Fluid> fluid, Supplier<? extends SoundEvent> sound, boolean tooltip, Properties properties) {
        super(type, fluid, sound, properties);
        this.hasTooltip = tooltip;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, world, tooltip, flag);
        if (hasTooltip && stack.hasTag()) {
            MutableComponent variant = Component.translatable(getFishType().getDescriptionId() + "." + stack.getTag().getInt("Variant")).withStyle(ChatFormatting.GRAY);

            tooltip.add(variant);
        }
    }
}
