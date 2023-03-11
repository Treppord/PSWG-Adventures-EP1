package com.trep.addon.world.feature;


import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.List;

import com.trep.addon.TestAddon;
import com.trep.addon.blocks.AdventureBlocks;

public class TestConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?,?>> BESKAR_GEODE_KEY = registerKey("BESKAR_GEODE");


    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        var placedFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);

        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplaceables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endstoneReplaceables = new BlockMatchRuleTest(Blocks.END_STONE);


        register(context, BESKAR_GEODE_KEY, Feature.GEODE ,
                new GeodeFeatureConfig(new GeodeLayerConfig(BlockStateProvider.of(Blocks.AIR),
                        BlockStateProvider.of(Blocks.DEEPSLATE),
                        BlockStateProvider.of(AdventureBlocks.SCRAP_METAL),
                        BlockStateProvider.of(Blocks.COBBLED_DEEPSLATE),
                        BlockStateProvider.of(Blocks.COBBLESTONE),
                        List.of(AdventureBlocks.SCRAP_METAL.getDefaultState()),
                        BlockTags.FEATURES_CANNOT_REPLACE , BlockTags.GEODE_INVALID_BLOCKS),
                        new GeodeLayerThicknessConfig(1.7D, 1.2D, 2.5D, 3.5D),
                        new GeodeCrackConfig(0.25D, 1.5D, 1),
                        0.5D, 0.1D,
                        true, UniformIntProvider.create(3, 8),
                        UniformIntProvider.create(2, 6), UniformIntProvider.create(1, 2),
                        -18, 18, 0.075D, 1));

    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(TestAddon.MODID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}