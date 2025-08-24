package codyhuh.theblueportal.core.client;

import codyhuh.theblueportal.core.TheBluePortal;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class TBPLayers {
    public static final ModelLayerLocation GIANT_LEAF_EEL_LAYER = create("giant_leaf_eel");

    public static ModelLayerLocation create(String name) {
        return new ModelLayerLocation(new ResourceLocation(TheBluePortal.MOD_ID, name), "main");
    }
}
