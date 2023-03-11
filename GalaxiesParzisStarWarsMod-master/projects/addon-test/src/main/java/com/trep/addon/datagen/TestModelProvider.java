package com.trep.addon.datagen;

import com.trep.addon.blocks.AdventureBlocks;
import com.trep.addon.items.AdventureItems;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class TestModelProvider extends FabricModelProvider {
    public TestModelProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerCubeAllModelTexturePool(AdventureBlocks.ARMOR_STATION);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(AdventureItems.WAMPA_HIDE, Models.GENERATED);
    }
}