package codyhuh.theblueportal.core.client.renders;

import codyhuh.theblueportal.core.TheBluePortal;
import codyhuh.theblueportal.core.client.TBPLayers;
import codyhuh.theblueportal.core.client.models.base.TBPModel;
import codyhuh.theblueportal.core.client.models.leaf_eels.GiantLeafEelModel;
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
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class LeafEelRenderer extends MobRenderer<LeafEel, TBPModel<LeafEel>> {
    private final GiantLeafEelModel<LeafEel> giantModel;
    public static final Map<Integer, ResourceLocation> TEXTURES = Util.make(Maps.newHashMap(), (hashMap) -> {
        hashMap.put(0, new ResourceLocation(TheBluePortal.MOD_ID, "textures/entity/leaf_eel/giant.png"));
    });

    public LeafEelRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new GiantLeafEelModel<>(pContext.bakeLayer(TBPLayers.GIANT_LEAF_EEL_LAYER)), 0.5F);
        //this.moonyMidModel = new MoonyMidModel<>(pContext.bakeLayer(FintasticLayers.MOONYMID_LAYER));
        //this.moonySmallModel = new MoonySmallModel<>(pContext.bakeLayer(FintasticLayers.MOONYSMALL_LAYER));
        this.giantModel = new GiantLeafEelModel<>(pContext.bakeLayer(TBPLayers.GIANT_LEAF_EEL_LAYER));
    }

    @Override
    public void render(LeafEel entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        //switch (entity.getVariantModel()) {
        //    case 1:
        //        this.model = moonySmallModel;
        //        break;
        //    case 2:
                this.model = giantModel;
        //        break;
        //    default:
        //        this.model = moonyMidModel;
        //}

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(LeafEel pEntity) {
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