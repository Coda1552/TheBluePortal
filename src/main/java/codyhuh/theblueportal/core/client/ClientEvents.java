package codyhuh.theblueportal.core.client;

import codyhuh.theblueportal.core.TheBluePortal;
import codyhuh.theblueportal.core.client.models.leaf_eels.*;
import codyhuh.theblueportal.core.client.renders.LeafEelRenderer;
import codyhuh.theblueportal.core.registry.ModEntities;
import codyhuh.theblueportal.core.registry.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = TheBluePortal.MOD_ID)
public class ClientEvents {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent e) {
        ItemProperties.register(ModItems.LEAF_EEL_BUCKET.get(), new ResourceLocation(TheBluePortal.MOD_ID, "variant"), (stack, world, player, i) -> stack.hasTag() ? stack.getTag().getInt("Variant") : 0F);
    }

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions e) {
        e.registerLayerDefinition(TBPLayers.GIANT_LEAF_EEL_LAYER, GiantLeafEelModel::createBodyLayer);
        e.registerLayerDefinition(TBPLayers.BRONZE_LEAF_EEL_LAYER, BronzeLeafEelModel::createBodyLayer);
        e.registerLayerDefinition(TBPLayers.PEACOCK_LEAF_EEL_LAYER, PeacockLeafEelModel::createBodyLayer);
        e.registerLayerDefinition(TBPLayers.MANGO_LEAF_EEL_LAYER, MangoLeafEelModel::createBodyLayer);
        e.registerLayerDefinition(TBPLayers.PEBBLE_ONK_LAYER, PebbleOnkModel::createBodyLayer);
        e.registerLayerDefinition(TBPLayers.SLIM_LEAF_EEL_LAYER, SlimLeafEelModel::createBodyLayer);
        e.registerLayerDefinition(TBPLayers.TINY_LEAF_EEL_LAYER, TinyLeafEelModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterRenderers e) {
        e.registerEntityRenderer(ModEntities.LEAF_EEL.get(), LeafEelRenderer::new);
    }
}
