package com.parzivail.pswg.client.render.entity;

import com.parzivail.pswg.Resources;
import com.parzivail.pswg.entity.BlasterBoltEntity;
import com.parzivail.util.math.Ease;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import org.joml.Quaternionf;

public class BlasterIonBoltRenderer extends EntityRenderer<BlasterBoltEntity>
{
	public BlasterIonBoltRenderer(EntityRendererFactory.Context ctx)
	{
		super(ctx);
	}

	@Override
	public Identifier getTexture(BlasterBoltEntity entity)
	{
		return Resources.id("missing");
	}

	@Override
	public void render(BlasterBoltEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider consumerProvider, int light)
	{
		//		super.render(entity, yaw, tickDelta, matrices, consumerProvider, light);

		var velocity = entity.getVelocity();
		velocity = velocity.normalize();

		matrices.push();

		matrices.translate(0, 0.5f * entity.getHeight(), 0);

		var s = MathHelper.clamp(Ease.inCubic((entity.age + tickDelta) / 2f), 0, 1);
		matrices.scale(s, s, s);

		var rPitch = (float)Math.asin(-velocity.y);
		var rYaw = (float)Math.atan2(velocity.x, velocity.z);

		matrices.multiply(new Quaternionf().rotationXYZ(0, rYaw, 0));
		matrices.multiply(new Quaternionf().rotationXYZ((float)(rPitch + Math.PI / 2), 0, 0));

		EnergyRenderer.renderEnergy(ModelTransformation.Mode.NONE, matrices, consumerProvider, light, 0xFFFFFF, false, 0.04f, 1, false, entity.getHue(), 1, 1);

		matrices.pop();
	}
}
