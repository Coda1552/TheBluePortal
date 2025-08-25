package codyhuh.theblueportal.core.client.models.leaf_eels;

import codyhuh.theblueportal.core.client.models.base.TBPModel;
import codyhuh.theblueportal.core.common.entities.LeafEel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class GiantLeafEelModel<T extends LeafEel> extends TBPModel<T> {
	private final ModelPart root;
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart jaw;
	private final ModelPart whiskers;
	private final ModelPart whiskerR;
	private final ModelPart whiskerL;
	private final ModelPart eyes;
	private final ModelPart eyeL;
	private final ModelPart eyeR;
	private final ModelPart rear_body;
	private final ModelPart tail;
	private final ModelPart dorsalfin_segment3;
	private final ModelPart sidefin_tail;
	private final ModelPart dorsalfin_segment2;
	private final ModelPart sidefin_segment2_right;
	private final ModelPart sidefin_segment2_left;
	private final ModelPart pectoralfinR;
	private final ModelPart pectoralfinL;
	private final ModelPart dorsalfinlet;
	private final ModelPart dorsalfin_segment1;
	private final ModelPart sidefin_segment1_right;
	private final ModelPart sidefin_segment1_left;

	public GiantLeafEelModel(ModelPart root) {
		super(1.0F, 0.0F);
		this.root = root.getChild("root");
		this.body = this.root.getChild("body");
		this.head = this.body.getChild("head");
		this.jaw = this.head.getChild("jaw");
		this.whiskers = this.jaw.getChild("whiskers");
		this.whiskerR = this.whiskers.getChild("whiskerR");
		this.whiskerL = this.whiskers.getChild("whiskerL");
		this.eyes = this.head.getChild("eyes");
		this.eyeL = this.eyes.getChild("eyeL");
		this.eyeR = this.eyes.getChild("eyeR");
		this.rear_body = this.body.getChild("rear_body");
		this.tail = this.rear_body.getChild("tail");
		this.dorsalfin_segment3 = this.tail.getChild("dorsalfin_segment3");
		this.sidefin_tail = this.tail.getChild("sidefin_tail");
		this.dorsalfin_segment2 = this.rear_body.getChild("dorsalfin_segment2");
		this.sidefin_segment2_right = this.rear_body.getChild("sidefin_segment2_right");
		this.sidefin_segment2_left = this.rear_body.getChild("sidefin_segment2_left");
		this.pectoralfinR = this.body.getChild("pectoralfinR");
		this.pectoralfinL = this.body.getChild("pectoralfinL");
		this.dorsalfinlet = this.body.getChild("dorsalfinlet");
		this.dorsalfin_segment1 = this.body.getChild("dorsalfin_segment1");
		this.sidefin_segment1_right = this.body.getChild("sidefin_segment1_right");
		this.sidefin_segment1_left = this.body.getChild("sidefin_segment1_left");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-5.5F, -1.0F, -5.5F, 11.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -0.5F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(39, 22).addBox(-4.5F, 0.0F, -4.0F, 9.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -5.5F));

		PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(39, 29).addBox(-3.5F, -2.0F, -1.0F, 7.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, -4.0F));

		PartDefinition whiskers = jaw.addOrReplaceChild("whiskers", CubeListBuilder.create(), PartPose.offset(0.0F, -2.0F, -1.0F));

		PartDefinition whiskerR = whiskers.addOrReplaceChild("whiskerR", CubeListBuilder.create().texOffs(38, 58).addBox(-1.5F, 0.0F, -2.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.001F)), PartPose.offset(-2.0F, 0.0F, 0.0F));

		PartDefinition whiskerL = whiskers.addOrReplaceChild("whiskerL", CubeListBuilder.create().texOffs(38, 58).mirror().addBox(-0.5F, 0.0F, -2.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.001F)).mirror(false), PartPose.offset(2.0F, 0.0F, 0.0F));

		PartDefinition eyes = head.addOrReplaceChild("eyes", CubeListBuilder.create(), PartPose.offset(0.0F, 1.0F, -3.0F));

		PartDefinition eyeL = eyes.addOrReplaceChild("eyeL", CubeListBuilder.create().texOffs(15, 53).mirror().addBox(0.0F, -1.0F, -1.5F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.001F)).mirror(false)
				.texOffs(25, 59).addBox(0.0F, -1.0F, 1.5F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.001F))
				.texOffs(22, 59).addBox(0.0F, -1.0F, -1.5F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.001F))
				.texOffs(58, 33).addBox(0.0F, 2.0F, -1.5F, 1.0F, 0.0F, 3.0F, new CubeDeformation(0.001F))
				.texOffs(56, 29).addBox(0.0F, -1.0F, -1.5F, 1.0F, 0.0F, 3.0F, new CubeDeformation(0.001F)), PartPose.offset(4.5F, -1.1F, 0.5F));

		PartDefinition eyeR = eyes.addOrReplaceChild("eyeR", CubeListBuilder.create().texOffs(15, 53).addBox(0.0F, -1.0F, -1.5F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.001F))
				.texOffs(56, 29).addBox(-1.0F, -1.0F, -1.5F, 1.0F, 0.0F, 3.0F, new CubeDeformation(0.001F))
				.texOffs(58, 33).addBox(-1.0F, 2.0F, -1.5F, 1.0F, 0.0F, 3.0F, new CubeDeformation(0.001F))
				.texOffs(22, 59).addBox(-1.0F, -1.0F, -1.5F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.001F))
				.texOffs(25, 59).addBox(-1.0F, -1.0F, 1.5F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.001F)), PartPose.offset(-4.5F, -1.1F, 0.5F));

		PartDefinition rear_body = body.addOrReplaceChild("rear_body", CubeListBuilder.create().texOffs(0, 22).addBox(-4.5F, 0.0F, 0.0F, 9.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 5.5F));

		PartDefinition tail = rear_body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 46).addBox(-3.5F, 0.0F, 0.0F, 7.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 10.0F));

		PartDefinition dorsalfin_segment3 = tail.addOrReplaceChild("dorsalfin_segment3", CubeListBuilder.create().texOffs(23, 46).addBox(0.0F, -3.0F, -3.0F, 0.0F, 5.0F, 7.0F, new CubeDeformation(0.001F)), PartPose.offset(0.0F, 0.0F, 3.0F));

		PartDefinition sidefin_tail = tail.addOrReplaceChild("sidefin_tail", CubeListBuilder.create().texOffs(0, 14).addBox(-8.5F, -0.1F, -4.0F, 17.0F, 0.0F, 7.0F, new CubeDeformation(0.001F)), PartPose.offset(0.0F, 2.0F, 4.0F));

		PartDefinition dorsalfin_segment2 = rear_body.addOrReplaceChild("dorsalfin_segment2", CubeListBuilder.create().texOffs(45, 0).addBox(0.0F, -3.0F, -5.0F, 0.0F, 3.0F, 10.0F, new CubeDeformation(0.001F)), PartPose.offset(0.0F, 0.0F, 5.0F));

		PartDefinition sidefin_segment2_right = rear_body.addOrReplaceChild("sidefin_segment2_right", CubeListBuilder.create().texOffs(0, 35).addBox(-4.0F, -0.1F, -5.0F, 4.0F, 0.0F, 10.0F, new CubeDeformation(0.001F)), PartPose.offset(-4.5F, 2.0F, 5.0F));

		PartDefinition sidefin_segment2_left = rear_body.addOrReplaceChild("sidefin_segment2_left", CubeListBuilder.create().texOffs(0, 35).mirror().addBox(0.0F, -0.1F, -5.0F, 4.0F, 0.0F, 10.0F, new CubeDeformation(0.001F)).mirror(false), PartPose.offset(4.5F, 2.0F, 5.0F));

		PartDefinition pectoralfinR = body.addOrReplaceChild("pectoralfinR", CubeListBuilder.create().texOffs(-1, 53).addBox(-3.0F, 0.0F, -3.0F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.001F)), PartPose.offset(-5.5F, 0.9F, -4.5F));

		PartDefinition pectoralfinL = body.addOrReplaceChild("pectoralfinL", CubeListBuilder.create().texOffs(-1, 53).mirror().addBox(0.0F, 0.0F, -3.0F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.001F)).mirror(false), PartPose.offset(5.5F, 0.9F, -4.5F));

		PartDefinition dorsalfinlet = body.addOrReplaceChild("dorsalfinlet", CubeListBuilder.create().texOffs(58, 37).addBox(0.0F, -2.0F, -0.5F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.001F)), PartPose.offset(0.0F, -1.0F, 0.0F));

		PartDefinition dorsalfin_segment1 = body.addOrReplaceChild("dorsalfin_segment1", CubeListBuilder.create().texOffs(9, 58).addBox(0.0F, -3.0F, -1.0F, 0.0F, 3.0F, 2.0F, new CubeDeformation(0.001F)), PartPose.offset(0.0F, -1.0F, 4.5F));

		PartDefinition sidefin_segment1_right = body.addOrReplaceChild("sidefin_segment1_right", CubeListBuilder.create().texOffs(38, 46).addBox(-3.0F, 0.0F, -3.0F, 3.0F, 0.0F, 6.0F, new CubeDeformation(0.001F)), PartPose.offset(-5.5F, 0.9F, 2.5F));

		PartDefinition sidefin_segment1_left = body.addOrReplaceChild("sidefin_segment1_left", CubeListBuilder.create().texOffs(38, 46).mirror().addBox(0.0F, 0.0F, -3.0F, 3.0F, 0.0F, 6.0F, new CubeDeformation(0.001F)).mirror(false), PartPose.offset(5.5F, 0.9F, 2.5F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(LeafEel pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);

		if (pEntity.isInWaterOrBubble()) {
			this.body.xRot = pHeadPitch * ((float)Math.PI / 180F);
			this.body.zRot = pNetHeadYaw * (((float)Math.PI / 180F)/2);

			this.animateWalk(GiantLeafEelAnimations.SWIM, pLimbSwing, pLimbSwingAmount, 4f, 4f);
		}
		else {
			this.body.resetPose();
		}

		this.animateIdle(pEntity.idleAnimationState, GiantLeafEelAnimations.IDLE, pAgeInTicks, 1.0F, 1-Math.abs(pLimbSwingAmount));
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