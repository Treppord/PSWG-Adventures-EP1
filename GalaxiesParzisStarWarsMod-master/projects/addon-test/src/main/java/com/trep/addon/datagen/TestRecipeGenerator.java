package com.trep.addon.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

import com.trep.addon.blocks.AdventureBlocks;
import com.trep.addon.items.AdventureItems;

public class TestRecipeGenerator extends FabricRecipeProvider {
    public TestRecipeGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerSmelting(exporter, List.of(AdventureBlocks.SCRAP_METAL), RecipeCategory.BUILDING_BLOCKS, AdventureItems.BESKAR_SCRAPS,
                3f, 300, "beskar");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, AdventureItems.BESKAR_SCRAPS, RecipeCategory.DECORATIONS, AdventureBlocks.SCRAP_METAL);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, AdventureItems.BESKAR_ALLOY)
                .pattern("###")
                .pattern("#I#")
                .pattern("###")
                .input('I', Items.IRON_INGOT)
                .input('#', AdventureItems.SILVER_CREDIT)
                .criterion(FabricRecipeProvider.hasItem(Items.IRON_INGOT),
                        FabricRecipeProvider.conditionsFromItem(Items.IRON_INGOT))
                .criterion(FabricRecipeProvider.hasItem(AdventureItems.SILVER_CREDIT),
                        FabricRecipeProvider.conditionsFromItem(AdventureItems.SILVER_CREDIT))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(AdventureItems.BESKAR_ALLOY)));
    }
}