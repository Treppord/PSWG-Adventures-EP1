package com.example.addon.entity;

import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.SkeletonEntityModel;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.util.Identifier;

public class CloneEntityRenderer extends BipedEntityRenderer<AbstractSkeletonEntity, CloneEntityModel<AbstractSkeletonEntity>> {
    private static final Identifier TEXTURE = new Identifier("textures/entity/clone/clone.png");

    public CloneEntityRenderer(EntityRendererFactory.Context context) {
        this(context, EntityModelLayers.PLAYER, EntityModelLayers.PLAYER_INNER_ARMOR, EntityModelLayers.PLAYER_OUTER_ARMOR);
    }

    public CloneEntityRenderer(EntityRendererFactory.Context ctx, EntityModelLayer layer, EntityModelLayer legArmorLayer, EntityModelLayer bodyArmorLayer) {
        super(ctx, new CloneEntityModel(ctx.getPart(layer)), 0.5F);
        this.addFeature(new ArmorFeatureRenderer(this, new CloneEntityModel(ctx.getPart(legArmorLayer)), new CloneEntityModel(ctx.getPart(bodyArmorLayer))));
    }

    public Identifier getTexture(AbstractSkeletonEntity abstractSkeletonEntity) {
        return TEXTURE;
    }

    protected boolean isShaking(AbstractSkeletonEntity abstractSkeletonEntity) {
        return abstractSkeletonEntity.isShaking();
    }
}
