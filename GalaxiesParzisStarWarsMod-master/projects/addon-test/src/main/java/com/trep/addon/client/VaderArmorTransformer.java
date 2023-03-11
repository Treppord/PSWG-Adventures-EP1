package com.trep.addon.client;

import com.parzivail.pswg.client.render.armor.ArmorRenderer;
import com.parzivail.pswg.client.render.armor.BipedEntityArmorModel;
import net.minecraft.entity.LivingEntity;

public class VaderArmorTransformer implements ArmorRenderer.ArmorRenderTransformer
{
    private static final String PART_HEAD_PHASE = "helmet";


    @Override
    public void transform(LivingEntity entity, boolean slim, BipedEntityArmorModel<LivingEntity> armorModel)
    {
        var helmetPhase1 = armorModel.head.getChild(PART_HEAD_PHASE);
    }
}