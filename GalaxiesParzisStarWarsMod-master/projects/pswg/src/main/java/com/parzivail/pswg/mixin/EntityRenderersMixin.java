package com.parzivail.pswg.mixin;

import com.google.common.collect.ImmutableMap;
import com.parzivail.pswg.client.render.player.PlayerSpeciesModelRenderer;
import com.parzivail.pswg.client.species.SwgSpeciesRenderer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.EntityRenderers;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Map;

@Mixin(EntityRenderers.class)
@Environment(EnvType.CLIENT)
public class EntityRenderersMixin
{
	@Inject(method = "reloadPlayerRenderers(Lnet/minecraft/client/render/entity/EntityRendererFactory$Context;)Ljava/util/Map;", at = @At(value = "INVOKE", target = "Lcom/google/common/collect/ImmutableMap$Builder;build()Lcom/google/common/collect/ImmutableMap;", shift = At.Shift.BEFORE, remap = false), locals = LocalCapture.CAPTURE_FAILHARD)
	private static void registerRenderers(EntityRendererFactory.Context ctx, CallbackInfoReturnable<Map<String, EntityRenderer<? extends PlayerEntity>>> cir, ImmutableMap.Builder<String, EntityRenderer<? extends PlayerEntity>> builder)
	{
		for (var pair : SwgSpeciesRenderer.MODELS.entrySet())
			builder.put(pair.getKey().toString(), new PlayerSpeciesModelRenderer(ctx, true, pair.getValue().model(), pair.getValue().animator()));
	}
}
