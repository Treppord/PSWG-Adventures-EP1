package com.trep.addon.entity;

import com.trep.addon.TestAddonClient;

import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.util.Identifier;

public class DroidEntityRenderer extends MobEntityRenderer<DroidEntity, DroidEntityModel> {


    public DroidEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new DroidEntityModel(context.getPart(EntityModelLayers.SKELETON)), 0.5f);
    }

    @Override
    public Identifier getTexture(DroidEntity entity) {
        return new Identifier("textures/entity/droid/droid_skin_1_general.png");
    }
}
