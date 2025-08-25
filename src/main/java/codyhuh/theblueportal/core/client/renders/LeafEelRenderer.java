package codyhuh.theblueportal.core.client.renders;

import codyhuh.theblueportal.core.TheBluePortal;
import codyhuh.theblueportal.core.client.TBPLayers;
import codyhuh.theblueportal.core.client.models.base.TBPModel;
import codyhuh.theblueportal.core.client.models.leaf_eels.*;
import codyhuh.theblueportal.core.common.entities.LeafEel;
import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class LeafEelRenderer extends MobRenderer<LeafEel, TBPModel<LeafEel>> {
    private final GiantLeafEelModel<LeafEel> giantModel;
    private final BronzeLeafEelModel<LeafEel> bronzeModel;
    private final MangoLeafEelModel<LeafEel> mangoModel;
    private final PeacockLeafEelModel<LeafEel> peacockModel;
    private final PebbleOnkModel<LeafEel> pebbleModel;
    private final SlimLeafEelModel<LeafEel> slimModel;
    private final TinyLeafEelModel<LeafEel> tinyModel;
    public static final Map<Integer, ResourceLocation> TEXTURES = Util.make(Maps.newHashMap(), (hashMap) -> {
        hashMap.put(0, new ResourceLocation(TheBluePortal.MOD_ID, "textures/entity/leaf_eel/giant.png"));
        hashMap.put(1, new ResourceLocation(TheBluePortal.MOD_ID, "textures/entity/leaf_eel/bronze.png"));
        hashMap.put(2, new ResourceLocation(TheBluePortal.MOD_ID, "textures/entity/leaf_eel/mango.png"));
        hashMap.put(3, new ResourceLocation(TheBluePortal.MOD_ID, "textures/entity/leaf_eel/peacock.png"));
        hashMap.put(4, new ResourceLocation(TheBluePortal.MOD_ID, "textures/entity/leaf_eel/pebble_onk.png"));
        hashMap.put(5, new ResourceLocation(TheBluePortal.MOD_ID, "textures/entity/leaf_eel/common.png"));
        hashMap.put(6, new ResourceLocation(TheBluePortal.MOD_ID, "textures/entity/leaf_eel/vibrant.png"));
        hashMap.put(7, new ResourceLocation(TheBluePortal.MOD_ID, "textures/entity/leaf_eel/royal.png"));
        hashMap.put(8, new ResourceLocation(TheBluePortal.MOD_ID, "textures/entity/leaf_eel/pod.png"));
    });

    public LeafEelRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new GiantLeafEelModel<>(pContext.bakeLayer(TBPLayers.GIANT_LEAF_EEL_LAYER)), 0.5F);

        this.giantModel = new GiantLeafEelModel<>(pContext.bakeLayer(TBPLayers.GIANT_LEAF_EEL_LAYER));
        this.bronzeModel = new BronzeLeafEelModel<>(pContext.bakeLayer(TBPLayers.BRONZE_LEAF_EEL_LAYER));
        this.mangoModel = new MangoLeafEelModel<>(pContext.bakeLayer(TBPLayers.MANGO_LEAF_EEL_LAYER));
        this.peacockModel = new PeacockLeafEelModel<>(pContext.bakeLayer(TBPLayers.PEACOCK_LEAF_EEL_LAYER));
        this.pebbleModel = new PebbleOnkModel<>(pContext.bakeLayer(TBPLayers.PEBBLE_ONK_LAYER));
        this.slimModel = new SlimLeafEelModel<>(pContext.bakeLayer(TBPLayers.SLIM_LEAF_EEL_LAYER));
        this.tinyModel = new TinyLeafEelModel<>(pContext.bakeLayer(TBPLayers.TINY_LEAF_EEL_LAYER));
    }

    @Override
    public void render(LeafEel entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        switch (entity.getVariant()) {
            case 0:
                this.model = giantModel;
                break;
            case 1:
                this.model = bronzeModel;
                break;
            case 2:
                this.model = mangoModel;
                break;
            case 3:
                this.model = peacockModel;
                break;
            case 4:
                this.model = pebbleModel;
                break;
            case 5, 6:
                this.model = slimModel;
                break;
            case 7, 8:
                this.model = tinyModel;
                break;
        }

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(LeafEel pEntity) {
        return TEXTURES.getOrDefault(pEntity.getVariant(), TEXTURES.get(0));
    }

    @Override
    protected @Nullable RenderType getRenderType(LeafEel pEntity, boolean pBodyVisible, boolean pTranslucent, boolean pGlowing) {
        return RenderType.entityTranslucent(getTextureLocation(pEntity));
    }

    @Override
    protected void setupRotations(LeafEel pEntityLiving, PoseStack pPoseStack, float pAgeInTicks, float pRotationYaw, float pPartialTicks) {
        super.setupRotations(pEntityLiving, pPoseStack, pAgeInTicks, pRotationYaw, pPartialTicks);
        pPoseStack.mulPose(Axis.ZP.rotationDegrees(pEntityLiving.currentRoll * 360 / 4));
    }
}