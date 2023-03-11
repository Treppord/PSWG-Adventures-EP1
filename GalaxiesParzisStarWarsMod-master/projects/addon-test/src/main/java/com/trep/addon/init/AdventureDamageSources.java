package com.trep.addon.init;

import com.trep.addon.TestAddon;

import net.minecraft.entity.damage.DamageSource;

public class AdventureDamageSources {
    public static final DamageSource CustomSnowball = new DamageSource(Source("thermal_detonator")).setProjectile();
    

    public static String Source(String name) {
        return TestAddon.MODID + name;
    }
}
