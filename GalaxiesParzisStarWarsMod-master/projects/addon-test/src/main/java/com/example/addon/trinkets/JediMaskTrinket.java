package com.example.addon.trinkets;

import com.example.addon.TestAddon;
import com.google.common.collect.Multimap;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import dev.emi.trinkets.api.client.TrinketRenderer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

import java.util.UUID;

public class VaderCapeTrinket extends TrinketItem implements TrinketRenderer {

    private static final Identifier TEXTURE = new Identifier(TestAddon.MODID, "textures/entity/trinket/cape.png");
    private BipedEntityModel<LivingEntity> model;

    public VaderCapeTrinket(Settings settings) {
        super(settings);
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
		/*stack.damage(1, entity, e -> {
			TrinketsApi.onTrinketBroken(stack, slot, entity);
		});*/
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, UUID uuid) {
        Multimap<EntityAttribute, EntityAttributeModifier> modifiers = super.getModifiers(stack, slot, entity, uuid);
        EntityAttributeModifier speedModifier = new EntityAttributeModifier(uuid, "trinkets-testmod:movement_speed",
                -0.3, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
        modifiers.put(EntityAttributes.GENERIC_MOVEMENT_SPEED, speedModifier);
        EntityAttributeModifier strengthModifier = new EntityAttributeModifier(uuid, "trinkets-testmod:strength",
                0.45, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
        modifiers.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, strengthModifier);
        return modifiers;
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void render(ItemStack stack, SlotReference slotReference, EntityModel<? extends LivingEntity> contextModel, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, LivingEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        BipedEntityModel<LivingEntity> model = this.getModel();
        model.setAngles(entity, limbAngle, limbDistance, animationProgress, animationProgress, headPitch);
        model.animateModel(entity, limbAngle, limbDistance, tickDelta);
        TrinketRenderer.followBodyRotations(entity, model);
        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(model.getLayer(TEXTURE));
        model.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 1, 1, 1, 1);
    }

    @Environment(EnvType.CLIENT)
    private BipedEntityModel<LivingEntity> getModel() {
        if (this.model == null) {
            // Vanilla 1.17 uses EntityModels, EntityModelLoader and EntityModelLayers
            this.model = new VaderCapeTrinketModel(VaderCapeTrinketModel.getTexturedModelData().createModel());
        }

        return this.model;
    }
}