package com.trep.addon.trinkets;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.LivingEntity;

@Environment(EnvType.CLIENT)
public class JediMaskTrinketModel extends BipedEntityModel<LivingEntity> {

    public JediMaskTrinketModel(ModelPart root) {
        super(root);
        this.setVisible(false);
        this.body.visible = true;
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = BipedEntityModel.getModelData(Dilation.NONE, 0f);
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData body = modelPartData.addChild("holocron", ModelPartBuilder.create().uv(16, 7).cuboid(3.0F, 20.0F, -1.6F, 3.0F, 3.0F, 3.0F), ModelTransform.NONE);
		return TexturedModelData.of(modelData, 32, 16);
    }
}