package com.parzivail.pswg.client.render.entity;

import com.parzivail.pswg.entity.ship.ShipEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;

public abstract class ShipRenderer<T extends ShipEntity> extends EntityRenderer<T>
{
	public ShipRenderer(EntityRendererFactory.Context ctx)
	{
		super(ctx);
	}

	@Override
	public void render(T entity, float yaw, float tickDelta, MatrixStack matrix, VertexConsumerProvider vertexConsumers, int light)
	{
		super.render(entity, yaw, tickDelta, matrix, vertexConsumers, light);
		matrix.push();

		var r = entity.getViewRotation(tickDelta);
		matrix.multiply(r);

		renderModel(entity, yaw, tickDelta, matrix, vertexConsumers, light);

		matrix.pop();
	}

	protected abstract void renderModel(T entity, float yaw, float tickDelta, MatrixStack matrix, VertexConsumerProvider vertexConsumers, int light);
}
