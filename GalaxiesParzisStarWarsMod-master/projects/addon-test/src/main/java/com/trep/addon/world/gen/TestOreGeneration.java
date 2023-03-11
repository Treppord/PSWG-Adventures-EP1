package com.trep.addon.world.gen;

import com.trep.addon.world.feature.TestPlacedFeatures;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

public class TestOreGeneration {
    public static void generateOres() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, TestPlacedFeatures.BESKAR_GEODE_PLACED_KEY);
    }
}