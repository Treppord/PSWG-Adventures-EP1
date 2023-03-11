package com.trep.addon.trinkets;

import com.google.common.collect.Multimap;
import com.parzivail.pswg.item.jetpack.JetpackItem;
import com.trep.addon.TestAddon;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import dev.emi.trinkets.api.client.TrinketRenderer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.UUID;

public class MandoJetpackTrinket extends TrinketItem implements TrinketRenderer {

    private static final Identifier TEXTURE = new Identifier(TestAddon.MODID, "textures/armor/jetpack.png");
    private BipedEntityModel<LivingEntity> model;

    public MandoJetpackTrinket(Settings settings) {
        super(settings);
    }

    public static double FLIGHTTIME = 5 * 20;
    public static final double flightTimeMax = 5 * 20;
    private static int fallFlyingA = 0;

    private static int jumpCount = 0;
    private static boolean jumpKey = false;

    public static int getMultiJumps() {
        jumpCount = 1;
        return jumpCount;
    }

    private static void fly(PlayerEntity player, double yVelocity, Vec3d v) {
        fallFlyingA += 1;
        if (!player.isFallFlying()) {
            player.setVelocity(v.getX(), (yVelocity * 0.9) + 0.1, v.getZ());
            jumpCount--;
            FLIGHTTIME--;
        } else {
            if (fallFlyingA >= 10) {
                player.stopFallFlying();
            }
        }
    }


    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {

        World world = entity.getWorld();
        boolean isActive = false;
        PlayerEntity player = (PlayerEntity) entity;
        if (world.isClient()) {
            boolean isGrounded = player.isOnGround();
            boolean isJumping = MinecraftClient.getInstance().options.jumpKey.isPressed();
            Vec3d v = player.getVelocity();
            double yVelocity = v.getY();

            // rocket flight
            if (player.isSwimming() && player.isInSwimmingPose()) {
                player.addVelocity(0, 0, 0);
            } else if (player.isSubmergedInWater() && isJumping) {
                player.setVelocity(v.getX(), (yVelocity * 0.9) + 0.01, v.getZ());
                isActive = true;
            } else if (player.isOnGround() || player.hasVehicle()) {
                jumpCount = getMultiJumps();
                fallFlyingA = 0;
            } else if (isJumping && !isGrounded && !player.isClimbing() && FLIGHTTIME >= 0 && !player.getAbilities().flying) {
                if (!jumpKey && jumpCount > 0 && yVelocity < 0.333) {
                    fly(player, yVelocity, v);
                } else if (jumpCount <= 0) {
                    fly(player, yVelocity, v);
                    isActive = true;
                }
                jumpKey = true;
            } else {
                jumpKey = false;
            }
            // add flight time while not rocket flying
            if (FLIGHTTIME > -10) {
                FLIGHTTIME += 0.15;
            }
            if (FLIGHTTIME > flightTimeMax) {
                FLIGHTTIME = flightTimeMax;
            }
            //creative flight
            if (player.isCreative()) {
                FLIGHTTIME = flightTimeMax;
            }
        }

        player.fallDistance *= 0.8;

        super.tick(stack, slot, entity);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {

        FLIGHTTIME += 0.15;
        if (FLIGHTTIME > flightTimeMax) {
            FLIGHTTIME = flightTimeMax;
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, UUID uuid) {
        Multimap<EntityAttribute, EntityAttributeModifier> modifiers = super.getModifiers(stack, slot, entity, uuid);
        EntityAttributeModifier speedModifier = new EntityAttributeModifier(uuid, "trinkets-testmod:movement_speed",
                -0.1, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
        modifiers.put(EntityAttributes.GENERIC_MOVEMENT_SPEED, speedModifier);
        EntityAttributeModifier armorModifier = new EntityAttributeModifier(uuid, "trinkets-testmod:armor",
                2, EntityAttributeModifier.Operation.ADDITION);
        modifiers.put(EntityAttributes.GENERIC_ARMOR, armorModifier);
        EntityAttributeModifier knockbackModifier = new EntityAttributeModifier(uuid, "trinkets-testmod:knockback",
                0.2, EntityAttributeModifier.Operation.ADDITION);
        modifiers.put(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, knockbackModifier);
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
            this.model = new MandoJetpackTrinketModel(MandoJetpackTrinketModel.getTexturedModelData().createModel());
        }

        return this.model;
    }
}