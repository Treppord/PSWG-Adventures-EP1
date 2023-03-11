package com.parzivail.pswg.client.render.entity;

import com.parzivail.pswg.Resources;
import com.parzivail.pswg.entity.BlasterBoltEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import org.joml.Quaternionf;

public class BlasterStunBoltRenderer extends EntityRenderer<BlasterBoltEntity>
{
	public BlasterStunBoltRenderer(EntityRendererFactory.Context ctx)
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

		var rPitch = (float)Math.asin(-velocity.y);
		var rYaw = (float)Math.atan2(velocity.x, velocity.z);

		matrices.multiply(new Quaternionf().rotationY(rYaw));
		matrices.multiply(new Quaternionf().rotationX(rPitch));

		var age = entity.age + tickDelta;
		var size = age / 10f;
		if (size < 3 / 16f)
			size = 3 / 16f;

		size = (float)Math.pow(size, 0.75f);

		EnergyRenderer.renderStunEnergy(ModelTransformation.Mode.NONE, matrices, consumerProvider, light, 0xFFFFFF, size, velocity, 0.6f);

		matrices.pop();
	}
}
