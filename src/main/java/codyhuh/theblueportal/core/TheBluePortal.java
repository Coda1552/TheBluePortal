package codyhuh.theblueportal.core;

import codyhuh.theblueportal.core.registry.ModCreativeTabs;
import codyhuh.theblueportal.core.registry.ModEntities;
import codyhuh.theblueportal.core.registry.ModItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(TheBluePortal.MOD_ID)
public class TheBluePortal {
    public static final String MOD_ID = "theblueportal";
    public static final Logger LOGGER = LogManager.getLogger();

    public TheBluePortal() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.ITEMS.register(bus);
        ModEntities.ENTITY_TYPES.register(bus);
        ModCreativeTabs.CREATIVE_TABS.register(bus);

    }

}
