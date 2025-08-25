package codyhuh.theblueportal.core.client;

import codyhuh.theblueportal.core.TheBluePortal;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class TBPLayers {
    public static final ModelLayerLocation GIANT_LEAF_EEL_LAYER = create("giant_leaf_eel");
    public static final ModelLayerLocation BRONZE_LEAF_EEL_LAYER = create("bronze_leaf_eel");
    public static final ModelLayerLocation MANGO_LEAF_EEL_LAYER = create("mango_leaf_eel");
    public static final ModelLayerLocation PEACOCK_LEAF_EEL_LAYER = create("peacock_leaf_eel");
    public static final ModelLayerLocation PEBBLE_ONK_LAYER = create("pebble_onk");
    public static final ModelLayerLocation SLIM_LEAF_EEL_LAYER = create("slim_leaf_eel");
    public static final ModelLayerLocation TINY_LEAF_EEL_LAYER = create("tiny_leaf_eel");

    public static ModelLayerLocation create(String name) {
        return new ModelLayerLocation(new ResourceLocation(TheBluePortal.MOD_ID, name), "main");
    }
}
