package codyhuh.theblueportal.core.client.models.leaf_eels;

import codyhuh.theblueportal.core.client.models.base.TBPModel;
import codyhuh.theblueportal.core.common.entities.LeafEel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class SlimLeafEelModel<T extends LeafEel> extends TBPModel<T> {
	private final ModelPart root;
	private final ModelPart body;
	private final ModelPart tail;
	private final ModelPart sidefin_segment2_right;
	private final ModelPart sidefin_segment2_left;
	private final ModelPart tailsidefin;
	private final ModelPart dorsalfin_segment2;
	private final ModelPart eyes;
	private final ModelPart eyeL;
	private final ModelPart eyeR;
	private final ModelPart pectoralfinL;
	private final ModelPart pectoralfinR;
	private final ModelPart sidefin_segment1_right;
	private final ModelPart sidefin_segment1_left;
	private final ModelPart dorsalfinlet;
	private final ModelPart dorsalfin_segment1;

	public SlimLeafEelModel(ModelPart root) {
		super(1.0F, 0.0F);
		this.root = root.getChild("root");
		this.body = this.root.getChild("body");
		this.tail = this.body.getChild("tail");
		this.sidefin_segment2_right = this.tail.getChild("sidefin_segment2_right");
		this.sidefin_segment2_left = this.tail.getChild("sidefin_segment2_left");
		this.tailsidefin = this.tail.getChild("tailsidefin");
		this.dorsalfin_segment2 = this.tail.getChild("dorsalfin_segment2");
		this.eyes = this.body.getChild("eyes");
		this.eyeL = this.eyes.getChild("eyeL");
		this.eyeR = this.eyes.getChild("eyeR");
		this.pectoralfinL = this.body.getChild("pectoralfinL");
		this.pectoralfinR = this.body.getChild("pectoralfinR");
		this.sidefin_segment1_right = this.body.getChild("sidefin_segment1_right");
		this.sidefin_segment1_left = this.body.getChild("sidefin_segment1_left");
		this.dorsalfinlet = this.body.getChild("dorsalfinlet");
		this.dorsalfin_segment1 = this.body.getChild("dorsalfin_segment1");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 23.0F, 0.0F));

		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -0.75F, -3.0F, 5.0F, 2.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(13, 17).addBox(-1.5F, -0.75F, -6.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(13, 23).addBox(-2.5F, -0.75F, -10.0F, 5.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(26, 16).addBox(-1.5F, -0.75F, -8.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.25F, 0.0F));

		PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(19, 10).addBox(-1.5F, -1.0F, 0.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.25F, 4.0F));

		PartDefinition sidefin_segment2_right = tail.addOrReplaceChild("sidefin_segment2_right", CubeListBuilder.create().texOffs(0, 10).addBox(-3.0F, 0.0F, -0.5F, 3.0F, 0.0F, 6.0F, new CubeDeformation(0.001F)), PartPose.offset(-1.5F, 0.9F, 0.5F));

		PartDefinition sidefin_segment2_left = tail.addOrReplaceChild("sidefin_segment2_left", CubeListBuilder.create().texOffs(0, 10).mirror().addBox(0.0F, 0.0F, -0.5F, 3.0F, 0.0F, 6.0F, new CubeDeformation(0.001F)).mirror(false), PartPose.offset(1.5F, 0.9F, 0.5F));

		PartDefinition tailsidefin = tail.addOrReplaceChild("tailsidefin", CubeListBuilder.create().texOffs(25, 5).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.001F)), PartPose.offset(0.0F, 0.9F, 3.0F));

		PartDefinition dorsalfin_segment2 = tail.addOrReplaceChild("dorsalfin_segment2", CubeListBuilder.create().texOffs(0, 17).addBox(0.0F, -2.0F, 0.0F, 0.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 0.0F));

		PartDefinition eyes = body.addOrReplaceChild("eyes", CubeListBuilder.create(), PartPose.offset(0.0F, 0.25F, -4.5F));

		PartDefinition eyeL = eyes.addOrReplaceChild("eyeL", CubeListBuilder.create().texOffs(24, 27).mirror().addBox(0.0F, -1.25F, -1.5F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.001F)).mirror(false)
		.texOffs(31, 28).mirror().addBox(0.0F, -1.25F, 1.5F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.001F)).mirror(false)
		.texOffs(31, 24).mirror().addBox(0.0F, -1.25F, -1.5F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.001F)).mirror(false)
		.texOffs(28, 20).mirror().addBox(0.0F, 1.75F, -1.5F, 1.0F, 0.0F, 3.0F, new CubeDeformation(0.001F)).mirror(false)
		.texOffs(0, 28).mirror().addBox(0.0F, -1.25F, -1.5F, 1.0F, 0.0F, 3.0F, new CubeDeformation(0.001F)).mirror(false), PartPose.offset(1.5F, -0.85F, 0.0F));

		PartDefinition eyeR = eyes.addOrReplaceChild("eyeR", CubeListBuilder.create().texOffs(24, 27).addBox(0.0F, -1.25F, -1.5F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.001F))
		.texOffs(0, 28).addBox(-1.0F, -1.25F, -1.5F, 1.0F, 0.0F, 3.0F, new CubeDeformation(0.001F))
		.texOffs(28, 20).addBox(-1.0F, 1.75F, -1.5F, 1.0F, 0.0F, 3.0F, new CubeDeformation(0.001F))
		.texOffs(31, 24).addBox(-1.0F, -1.25F, -1.5F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.001F))
		.texOffs(31, 28).addBox(-1.0F, -1.25F, 1.5F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.001F)), PartPose.offset(-1.5F, -0.85F, 0.0F));

		PartDefinition pectoralfinL = body.addOrReplaceChild("pectoralfinL", CubeListBuilder.create().texOffs(25, 0).mirror().addBox(0.0F, 0.0F, -2.5F, 2.0F, 0.0F, 4.0F, new CubeDeformation(0.001F)).mirror(false), PartPose.offset(2.5F, 1.15F, -2.5F));

		PartDefinition pectoralfinR = body.addOrReplaceChild("pectoralfinR", CubeListBuilder.create().texOffs(25, 0).addBox(-2.0F, 0.0F, -2.5F, 2.0F, 0.0F, 4.0F, new CubeDeformation(0.001F)), PartPose.offset(-2.5F, 1.15F, -2.5F));

		PartDefinition sidefin_segment1_right = body.addOrReplaceChild("sidefin_segment1_right", CubeListBuilder.create().texOffs(13, 27).addBox(-2.0F, 0.0F, -1.5F, 2.0F, 0.0F, 3.0F, new CubeDeformation(0.001F)), PartPose.offset(-2.5F, 1.15F, 2.5F));

		PartDefinition sidefin_segment1_left = body.addOrReplaceChild("sidefin_segment1_left", CubeListBuilder.create().texOffs(13, 27).mirror().addBox(0.0F, 0.0F, -1.5F, 2.0F, 0.0F, 3.0F, new CubeDeformation(0.001F)).mirror(false), PartPose.offset(2.5F, 1.15F, 2.5F));

		PartDefinition dorsalfinlet = body.addOrReplaceChild("dorsalfinlet", CubeListBuilder.create().texOffs(9, 31).addBox(0.0F, -2.0F, 0.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.75F, -3.0F));

		PartDefinition dorsalfin_segment1 = body.addOrReplaceChild("dorsalfin_segment1", CubeListBuilder.create().texOffs(16, 31).addBox(0.0F, -2.0F, -1.5F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.75F, 2.5F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(LeafEel pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);

		if (pEntity.isInWaterOrBubble()) {
			this.body.xRot = pHeadPitch * ((float)Math.PI / 180F);
			this.body.zRot = pNetHeadYaw * (((float)Math.PI / 180F)/2);

			this.animateWalk(SlimLeafEelAnimations.SWIM, pLimbSwing, pLimbSwingAmount, 4f, 4f);
		}
		else {
			this.body.resetPose();
		}

		this.animateIdle(pEntity.idleAnimationState, SlimLeafEelAnimations.IDLE, pAgeInTicks, 1.0F, 1-Math.abs(pLimbSwingAmount));
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