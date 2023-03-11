package com.example.addon;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class TestBlocks {

    public static final Block ARMOR_STATION = registerBlock("armor_station",
            new ArmorStationBlock(FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool().nonOpaque()), ItemGroups.INGREDIENTS);

    public static final Block SCRAP_METAL = registerBlock("scrap_metal",
            new Block(FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool()), ItemGroups.INGREDIENTS);

    private static Block registerBlock(String name, Block block, ItemGroup group, String tooltipKey) {
        registerBlockItem(name, block, group, tooltipKey);
        return Registry.register(Registries.BLOCK, new Identifier(TestAddon.MODID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group, String tooltipKey) {
        return Registry.register(Registries.ITEM, new Identifier(TestAddon.MODID, name),
                new BlockItem(block, new FabricItemSettings()) {
                    @Override
                    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
                        tooltip.add(Text.translatable(tooltipKey));
                    }
                });
    }

    private static Block registerBlockWithoutBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registries.BLOCK, new Identifier(TestAddon.MODID, name), block);
    }

    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registries.BLOCK, new Identifier(TestAddon.MODID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registries.ITEM, new Identifier(TestAddon.MODID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {

        System.out.println("Registering Mod Blocks for " + TestAddon.MODID);
    }
}