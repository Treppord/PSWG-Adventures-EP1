package com.parzivail.pswg.client.render.p3d;

import net.fabricmc.fabric.api.renderer.v1.mesh.QuadEmitter;
import net.fabricmc.fabric.api.renderer.v1.render.RenderContext;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.random.Random;

import java.util.HashMap;
import java.util.function.Supplier;

public interface IP3DBlockRenderer
{
	void renderBlock(MatrixStack matrices, QuadEmitter quadEmitter, P3DBlockRenderTarget target, Supplier<Random> randomSupplier, RenderContext renderContext, P3dModel model, Sprite baseSprite, HashMap<String, Sprite> additionalSprites);
}
