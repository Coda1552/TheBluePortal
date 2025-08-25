package codyhuh.theblueportal.core.client.models.leaf_eels;

import codyhuh.theblueportal.core.client.models.base.TBPModel;
import codyhuh.theblueportal.core.common.entities.LeafEel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class PeacockLeafEelModel<T extends LeafEel> extends TBPModel<T> {
	private final ModelPart root;
	private final ModelPart body;
	private final ModelPart jaw;
	private final ModelPart tail;
	private final ModelPart tailfin;
	private final ModelPart tailsidefin;
	private final ModelPart eyes;
	private final ModelPart eyeL;
	private final ModelPart eyeR;
	private final ModelPart pectoralfinR;
	private final ModelPart pectoralfinL;
	private final ModelPart dorsalfinlet;
	private final ModelPart dorsalfin;
	private final ModelPart sidefin_left;
	private final ModelPart sidefin_right;

	public PeacockLeafEelModel(ModelPart root) {
		super(1.0F, 0.0F);
		this.root = root.getChild("root");
		this.body = this.root.getChild("body");
		this.jaw = this.body.getChild("jaw");
		this.tail = this.body.getChild("tail");
		this.tailfin = this.tail.getChild("tailfin");
		this.tailsidefin = this.tail.getChild("tailsidefin");
		this.eyes = this.body.getChild("eyes");
		this.eyeL = this.eyes.getChild("eyeL");
		this.eyeR = this.eyes.getChild("eyeR");
		this.pectoralfinR = this.body.getChild("pectoralfinR");
		this.pectoralfinL = this.body.getChild("pectoralfinL");
		this.dorsalfinlet = this.body.getChild("dorsalfinlet");
		this.dorsalfin = this.body.getChild("dorsalfin");
		this.sidefin_left = this.body.getChild("sidefin_left");
		this.sidefin_right = this.body.getChild("sidefin_right");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, -1.5F, -2.0F, 7.0F, 2.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(23, 14).addBox(-2.5F, -1.5F, -5.0F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, 0.0F));

		PartDefinition jaw = body.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(29, 0).addBox(-2.5F, -2.0F, -1.0F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.5F, -5.0F));

		PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(29, 4).addBox(-2.5F, -0.5F, 0.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 5.0F));

		PartDefinition tailfin = tail.addOrReplaceChild("tailfin", CubeListBuilder.create().texOffs(34, 28).addBox(0.0F, -1.5F, 0.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.001F)), PartPose.offset(0.0F, 0.0F, 1.0F));

		PartDefinition tailsidefin = tail.addOrReplaceChild("tailsidefin", CubeListBuilder.create().texOffs(23, 10).addBox(-3.5F, 0.0F, -0.5F, 7.0F, 0.0F, 3.0F, new CubeDeformation(0.001F)), PartPose.offset(0.0F, 0.4F, 0.5F));

		PartDefinition eyes = body.addOrReplaceChild("eyes", CubeListBuilder.create(), PartPose.offset(0.0F, -0.5F, -6.0F));

		PartDefinition eyeL = eyes.addOrReplaceChild("eyeL", CubeListBuilder.create().texOffs(20, 31).mirror().addBox(0.0F, -1.25F, -1.5F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.001F)).mirror(false)
		.texOffs(20, 24).mirror().addBox(0.0F, -1.25F, 1.5F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.001F)).mirror(false)
		.texOffs(34, 34).mirror().addBox(0.0F, -1.25F, -1.5F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.001F)).mirror(false)
		.texOffs(0, 34).mirror().addBox(0.0F, 1.75F, -1.5F, 1.0F, 0.0F, 3.0F, new CubeDeformation(0.001F)).mirror(false)
		.texOffs(9, 34).mirror().addBox(0.0F, -1.25F, -1.5F, 1.0F, 0.0F, 3.0F, new CubeDeformation(0.001F)).mirror(false), PartPose.offset(2.5F, -0.85F, 2.5F));

		PartDefinition eyeR = eyes.addOrReplaceChild("eyeR", CubeListBuilder.create().texOffs(27, 31).addBox(0.0F, -1.25F, -1.5F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.001F))
		.texOffs(34, 20).addBox(-1.0F, -1.25F, -1.5F, 1.0F, 0.0F, 3.0F, new CubeDeformation(0.001F))
		.texOffs(34, 24).addBox(-1.0F, 1.75F, -1.5F, 1.0F, 0.0F, 3.0F, new CubeDeformation(0.001F))
		.texOffs(37, 34).addBox(-1.0F, -1.25F, -1.5F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.001F))
		.texOffs(0, 38).addBox(-1.0F, -1.25F, 1.5F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.001F)), PartPose.offset(-2.5F, -0.85F, 2.5F));

		PartDefinition pectoralfinR = body.addOrReplaceChild("pectoralfinR", CubeListBuilder.create().texOffs(0, 24).addBox(-2.0F, 0.0F, -2.5F, 2.0F, 0.0F, 4.0F, new CubeDeformation(0.001F)), PartPose.offset(-3.5F, 0.4F, -1.5F));

		PartDefinition pectoralfinL = body.addOrReplaceChild("pectoralfinL", CubeListBuilder.create().texOffs(0, 29).mirror().addBox(0.0F, 0.0F, -2.5F, 2.0F, 0.0F, 4.0F, new CubeDeformation(0.001F)).mirror(false), PartPose.offset(3.5F, 0.4F, -1.5F));

		PartDefinition dorsalfinlet = body.addOrReplaceChild("dorsalfinlet", CubeListBuilder.create().texOffs(13, 24).addBox(0.0F, -6.0F, 0.0F, 0.0F, 6.0F, 3.0F, new CubeDeformation(0.001F)), PartPose.offset(0.0F, -1.5F, -3.0F));

		PartDefinition dorsalfin = body.addOrReplaceChild("dorsalfin", CubeListBuilder.create().texOffs(23, 20).addBox(0.0F, -4.0F, -2.5F, 0.0F, 5.0F, 5.0F, new CubeDeformation(0.001F)), PartPose.offset(0.0F, -1.5F, 3.5F));

		PartDefinition sidefin_left = body.addOrReplaceChild("sidefin_left", CubeListBuilder.create().texOffs(0, 10).mirror().addBox(0.0F, 0.0F, -2.5F, 5.0F, 0.0F, 6.0F, new CubeDeformation(0.001F)).mirror(false), PartPose.offset(3.5F, 0.4F, 3.5F));

		PartDefinition sidefin_right = body.addOrReplaceChild("sidefin_right", CubeListBuilder.create().texOffs(0, 17).addBox(-5.0F, 0.0F, -2.5F, 5.0F, 0.0F, 6.0F, new CubeDeformation(0.001F)), PartPose.offset(-3.5F, 0.4F, 3.5F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(LeafEel pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);

		if (pEntity.isInWaterOrBubble()) {
			this.body.xRot = pHeadPitch * ((float)Math.PI / 180F);
			this.body.zRot = pNetHeadYaw * (((float)Math.PI / 180F)/2);

			this.animateWalk(PeacockLeafEelAnimations.SWIM, pLimbSwing, pLimbSwingAmount, 4f, 4f);
		}
		else {
			this.body.resetPose();
		}

		this.animateIdle(pEntity.idleAnimationState, PeacockLeafEelAnimations.IDLE, pAgeInTicks, 1.0F, 1-Math.abs(pLimbSwingAmount));
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