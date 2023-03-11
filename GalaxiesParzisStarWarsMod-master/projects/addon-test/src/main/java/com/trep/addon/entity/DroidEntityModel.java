package com.trep.addon.entity;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

// Made with Blockbench 4.6.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class DroidEntityModel extends EntityModel<DroidEntity> {
	private final ModelPart left_arm;
	private final ModelPart right_arm;
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart right_leg;
	private final ModelPart left_leg;
	public DroidEntityModel(ModelPart root) {
		this.left_arm = root.getChild("left_arm");
		this.right_arm = root.getChild("right_arm");
		this.body = root.getChild("body");
		this.head = root.getChild("head");
		this.right_leg = root.getChild("right_leg");
		this.left_leg = root.getChild("left_leg");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData left_arm = modelPartData.addChild("left_arm", ModelPartBuilder.create().uv(22, 16).cuboid(0.0F, 0.0F, -1.0F, 1.0F, 6.0F, 1.0F, new Dilation(0.0F))
		.uv(22, 16).cuboid(0.0F, 1.0F, 0.0F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(5.0F, -3.0F, 1.0F));

		ModelPartData cube_r1 = left_arm.addChild("cube_r1", ModelPartBuilder.create().uv(27, 17).cuboid(5.0F, 0.0F, -1.0F, 1.0F, 7.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-5.0F, 6.0F, 0.0F, -1.2654F, 0.0F, 0.0F));

		ModelPartData right_arm = modelPartData.addChild("right_arm", ModelPartBuilder.create().uv(22, 16).cuboid(-1.0F, 0.0F, 0.0F, 1.0F, 6.0F, 1.0F, new Dilation(0.0F))
		.uv(22, 16).cuboid(-1.0F, 1.0F, 1.0F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-5.0F, -3.0F, 0.0F));

		ModelPartData cube_r2 = right_arm.addChild("cube_r2", ModelPartBuilder.create().uv(27, 17).cuboid(-6.0F, 0.0F, -1.0F, 1.0F, 7.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(5.0F, 6.0F, 1.0F, -1.0908F, 0.0F, 0.0F));

		ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(8, 3).cuboid(-5.0F, -7.0F, -1.0F, 1.0F, 3.0F, 3.0F, new Dilation(0.0F))
		.uv(8, 3).cuboid(4.0F, -7.0F, -1.0F, 1.0F, 3.0F, 3.0F, new Dilation(0.0F))
		.uv(16, 16).cuboid(-4.0F, -7.0F, -1.0F, 8.0F, 6.0F, 4.0F, new Dilation(0.0F))
		.uv(32, 19).cuboid(-3.0F, -1.0F, -1.0F, 6.0F, 6.0F, 1.0F, new Dilation(0.0F))
		.uv(32, 19).cuboid(-3.0F, -1.0F, 0.0F, 6.0F, 6.0F, 1.0F, new Dilation(0.0F))
		.uv(25, 19).mirrored().cuboid(-3.0F, -1.0F, 1.0F, 6.0F, 6.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 3.0F, 0.0F));

		ModelPartData octagon = body.addChild("octagon", ModelPartBuilder.create().uv(16, 24).cuboid(-12.0F, -8.6213F, 6.1F, 8.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(16, 24).cuboid(-12.0F, -8.6213F, 8.1F, 8.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(16, 24).cuboid(-12.0F, -7.5F, 6.9787F, 8.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(16, 24).cuboid(-12.0F, -9.5F, 6.9787F, 8.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(8.0F, 14.0F, -7.0F));

		ModelPartData octagon_r1 = octagon.addChild("octagon_r1", ModelPartBuilder.create().uv(16, 24).cuboid(-4.0F, -1.5F, -0.6213F, 8.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(16, 24).cuboid(-4.0F, 0.5F, -0.6213F, 8.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(16, 24).cuboid(-4.0F, -0.6213F, 0.5F, 8.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(16, 24).cuboid(-4.0F, -0.6213F, -1.5F, 8.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-8.0F, -8.0F, 7.6F, -0.7854F, 0.0F, 0.0F));

		ModelPartData head = modelPartData.addChild("head", ModelPartBuilder.create().uv(21, 20).cuboid(-1.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F))
		.uv(21, 20).cuboid(-2.0F, -8.9F, 0.0F, 3.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -4.0F, 0.0F));

		ModelPartData cube_r3 = head.addChild("cube_r3", ModelPartBuilder.create().uv(9, 10).cuboid(-2.5F, 7.0F, -1.0F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(9, 10).cuboid(-2.5F, 6.0F, -1.0F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(9, 10).cuboid(-2.5F, 5.0F, -1.0F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(9, 5).cuboid(-2.5F, -1.0F, -1.0F, 4.0F, 3.0F, 1.0F, new Dilation(0.0F))
		.uv(9, 8).cuboid(-2.5F, 2.0F, -1.0F, 4.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -8.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		ModelPartData cube_r4 = head.addChild("cube_r4", ModelPartBuilder.create().uv(10, 4).cuboid(-2.5F, -0.7F, 0.7F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F))
		.uv(10, 4).cuboid(0.5F, -0.7F, 0.7F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -8.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		ModelPartData right_leg = modelPartData.addChild("right_leg", ModelPartBuilder.create().uv(20, 17).cuboid(-1.0F, 0.0F, -0.8F, 1.0F, 6.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.0F, 10.0F, 1.0F));

		ModelPartData rightfoot = right_leg.addChild("rightfoot", ModelPartBuilder.create().uv(15, 18).cuboid(-2.0F, 7.0F, -4.8F, 3.0F, 1.0F, 6.0F, new Dilation(0.0F))
		.uv(20, 17).cuboid(-1.0F, 0.0F, -0.8F, 1.0F, 7.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 6.0F, 0.0F));

		ModelPartData left_leg = modelPartData.addChild("left_leg", ModelPartBuilder.create().uv(19, 18).cuboid(0.0F, 0.0F, -0.8F, 1.0F, 6.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(3.0F, 10.0F, 1.0F));

		ModelPartData leftfoot = left_leg.addChild("leftfoot", ModelPartBuilder.create().uv(19, 18).cuboid(-2.0F, 7.0F, -3.8F, 3.0F, 1.0F, 6.0F, new Dilation(0.0F))
		.uv(19, 18).cuboid(-1.0F, 0.0F, 0.2F, 1.0F, 7.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(1.0F, 6.0F, -1.0F));
		return TexturedModelData.of(modelData, 64, 32);

	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		left_arm.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		right_arm.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		body.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		head.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		right_leg.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		left_leg.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public void setAngles(DroidEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

	}
}