package com.trep.addon.trinkets;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.LivingEntity;

@Environment(EnvType.CLIENT)
public class MandoJetpackTrinketModel extends BipedEntityModel<LivingEntity> {

    public MandoJetpackTrinketModel(ModelPart root) {
        super(root);
        this.setVisible(false);
        this.body.visible = true;
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = BipedEntityModel.getModelData(Dilation.NONE, 0f);
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(38, 21).cuboid(-4.0F, 0.0F, 1.0F, 8.0F, 7.0F, 3.0F), ModelTransform.NONE);
        body.addChild("part1", ModelPartBuilder.create().uv(45, 27).cuboid(2.5F, 6.0F, 3.0F, 2.0F, 4.0F, 2.0F), ModelTransform.NONE);
        body.addChild("part2", ModelPartBuilder.create().uv(45, 27).mirrored().cuboid(-4.5F, 6.0F, 3.0F, 2.0F, 4.0F, 2.0F).mirrored(false), ModelTransform.NONE);
        body.addChild("part3", ModelPartBuilder.create().uv(43, 19).cuboid(-1.5F, -2.0F, 1.0F, 3.0F, 2.0F, 2.0F), ModelTransform.NONE);
        body.addChild("part4", ModelPartBuilder.create().uv(41, 19).cuboid(2.5F, -1.0F, 1.0F, 1.0F, 1.0F, 4.0F), ModelTransform.NONE);
        body.addChild("part5", ModelPartBuilder.create().uv(41, 19).cuboid(-3.5F, -1.0F, 1.0F, 1.0F, 1.0F, 4.0F), ModelTransform.NONE);
        body.addChild("part6", ModelPartBuilder.create().uv(41, 23).cuboid(-3.5F, 0.0F, 4.0F, 1.0F, 2.0F, 1.0F), ModelTransform.NONE);
        body.addChild("part7", ModelPartBuilder.create().uv(48, 26).cuboid(2.5F, 0.0F, 4.0F, 1.0F, 2.0F, 1.0F), ModelTransform.NONE);
        return TexturedModelData.of(modelData, 64, 64);
    }
}