package codyhuh.theblueportal.core.client.models.leaf_eels;

import codyhuh.theblueportal.core.client.models.base.TBPModel;
import codyhuh.theblueportal.core.common.entities.LeafEel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class BronzeLeafEelModel<T extends LeafEel> extends TBPModel<T> {
	private final ModelPart root;
	private final ModelPart body;
	private final ModelPart tailsidefin_right;
	private final ModelPart tailsidefin_left;
	private final ModelPart pectoralfin_left;
	private final ModelPart pectoralfin_right;
	private final ModelPart dorsalfin;

	public BronzeLeafEelModel(ModelPart root) {
		super(1.0F, 0.0F);
		this.root = root.getChild("root");
		this.body = this.root.getChild("body");
		this.tailsidefin_right = this.body.getChild("tailsidefin_right");
		this.tailsidefin_left = this.body.getChild("tailsidefin_left");
		this.pectoralfin_left = this.body.getChild("pectoralfin_left");
		this.pectoralfin_right = this.body.getChild("pectoralfin_right");
		this.dorsalfin = this.body.getChild("dorsalfin");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 23.5F, 0.0F));

		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -0.5F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition tailsidefin_right = body.addOrReplaceChild("tailsidefin_right", CubeListBuilder.create().texOffs(0, 6).addBox(-2.0F, 0.0F, -0.5F, 4.0F, 0.0F, 3.0F, new CubeDeformation(0.001F)), PartPose.offset(-2.0F, 0.4F, 0.5F));

		PartDefinition tailsidefin_left = body.addOrReplaceChild("tailsidefin_left", CubeListBuilder.create().texOffs(0, 10).addBox(-2.0F, 0.0F, -0.5F, 4.0F, 0.0F, 3.0F, new CubeDeformation(0.001F)), PartPose.offset(2.0F, 0.4F, 0.5F));

		PartDefinition pectoralfin_left = body.addOrReplaceChild("pectoralfin_left", CubeListBuilder.create().texOffs(7, 14).addBox(0.0F, 0.0F, -0.5F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.001F)), PartPose.offset(2.0F, 0.4F, -1.5F));

		PartDefinition pectoralfin_right = body.addOrReplaceChild("pectoralfin_right", CubeListBuilder.create().texOffs(12, 14).addBox(-1.0F, 0.0F, -0.5F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.001F)), PartPose.offset(-2.0F, 0.4F, -1.5F));

		PartDefinition dorsalfin = body.addOrReplaceChild("dorsalfin", CubeListBuilder.create().texOffs(0, 14).addBox(0.0F, -2.0F, -1.5F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.001F)), PartPose.offset(0.0F, 0.5F, 1.5F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(LeafEel pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);

		if (pEntity.isInWaterOrBubble()) {
			this.body.xRot = pHeadPitch * ((float)Math.PI / 180F);
			this.body.zRot = pNetHeadYaw * (((float)Math.PI / 180F)/2);

			this.animateWalk(BronzeLeafEelAnimations.SWIM, pLimbSwing, pLimbSwingAmount, 4f, 4f);
		}
		else {
			this.body.resetPose();
		}

		this.animateIdle(pEntity.idleAnimationState, BronzeLeafEelAnimations.IDLE, pAgeInTicks, 1.0F, 1-Math.abs(pLimbSwingAmount));
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		poseStack.pushPose();

		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);

		poseStack.popPose();
	}

	@Override
	public ModelPart root() {
		return root;
	}
}