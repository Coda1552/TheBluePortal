package codyhuh.theblueportal.core.registry;

import codyhuh.theblueportal.core.TheBluePortal;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TheBluePortal.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TBP_TAB = CREATIVE_TABS.register("tbp_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup." + TheBluePortal.MOD_ID))
                    .icon(ModItems.LEAF_EEL.get()::getDefaultInstance)
                    .displayItems((displayParams, output) -> {
                        for (var item : ModItems.ITEMS.getEntries()) {
                            output.accept(item.get());
                        }
                    })
                    .build()
    );
}