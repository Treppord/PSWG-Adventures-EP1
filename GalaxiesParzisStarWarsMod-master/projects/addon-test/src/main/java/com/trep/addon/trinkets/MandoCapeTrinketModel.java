package com.trep.addon.trinkets;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.LivingEntity;

@Environment(EnvType.CLIENT)
public class MandoCapeTrinketModel extends BipedEntityModel<LivingEntity> {

    public MandoCapeTrinketModel(ModelPart root) {
        super(root);
        this.setVisible(false);
        this.body.visible = true;
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = BipedEntityModel.getModelData(Dilation.NONE, 0f);
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(21, 10).cuboid(-4.5F, 0.0F, 2.0F, 9.0F, 14.0F, 1.0F), ModelTransform.NONE);
        body.addChild("lower", ModelPartBuilder.create().uv(23, 10)
                .cuboid(-3.0F, 2.0F, 2.75F, 6.0F, 15.0F, 1.0F), ModelTransform.NONE);
        body.addChild("upper", ModelPartBuilder.create().uv(9, 13)
                .cuboid(-4.5F, 0.0F, 0.0F, 9.0F, 2.0F, 2.0F), ModelTransform.NONE);
        return TexturedModelData.of(modelData, 64, 32);
    }
}