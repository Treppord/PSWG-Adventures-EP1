package com.parzivail.pswg.mixin;

import com.parzivail.pswg.Client;
import com.parzivail.util.client.render.ICustomPoseItem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.AnimalModel;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.ModelWithArms;
import net.minecraft.client.render.entity.model.ModelWithHead;
import net.minecraft.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BipedEntityModel.class)
@Environment(EnvType.CLIENT)
public abstract class BipedEntityModelMixin<T extends LivingEntity> extends AnimalModel<T> implements ModelWithArms, ModelWithHead
{
	@Final
	@Shadow
	public ModelPart head;

	@Final
	@Shadow
	public ModelPart rightArm;

	@Final
	@Shadow
	public ModelPart leftArm;

	@Inject(method = "setAngles(Lnet/minecraft/entity/LivingEntity;FFFFF)V", at = @At(value = "TAIL"))
	public void setAnglesMixin(T livingEntity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch, CallbackInfo info)
	{
		if (!livingEntity.getOffHandStack().isEmpty() || livingEntity.isSwimming() || livingEntity.hasVehicle())
			return;

		var stack = livingEntity.getMainHandStack();
		if (!stack.isEmpty())
		{
			@Nullable
			final ICustomPoseItem pose = ICustomPoseItem.REGISTRY.get(stack.getItem().getClass());
			if (pose != null)
				pose.modifyPose(livingEntity, stack, head, rightArm, leftArm, livingEntity, limbAngle, limbDistance, animationProgress, headYaw, headPitch, Client.getTickDelta());
		}
	}
}
