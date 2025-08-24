package codyhuh.theblueportal.core.client;

import codyhuh.theblueportal.core.TheBluePortal;
import codyhuh.theblueportal.core.client.models.leaf_eels.GiantLeafEelModel;
import codyhuh.theblueportal.core.client.renders.LeafEelRenderer;
import codyhuh.theblueportal.core.registry.ModEntities;
import codyhuh.theblueportal.core.registry.ModItems;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
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
    }

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterRenderers e) {
        e.registerEntityRenderer(ModEntities.LEAF_EEL.get(), LeafEelRenderer::new);
    }
}
