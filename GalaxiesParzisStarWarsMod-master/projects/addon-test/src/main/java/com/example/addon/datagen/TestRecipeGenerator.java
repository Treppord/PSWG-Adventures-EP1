package com.example.addon.datagen;

import com.example.addon.TestBlocks;
import com.example.addon.TestItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class TestRecipeGenerator extends FabricRecipeProvider {
    public TestRecipeGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerSmelting(exporter, List.of(TestBlocks.SCRAP_METAL), RecipeCategory.BUILDING_BLOCKS, TestItems.BESKAR_SCRAPS,
                3f, 300, "beskar");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, TestItems.BESKAR_SCRAPS, RecipeCategory.DECORATIONS, TestBlocks.SCRAP_METAL);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, TestItems.BESKAR_ALLOY)
                .pattern("###")
                .pattern("#I#")
                .pattern("###")
                .input('I', Items.IRON_INGOT)
                .input('#', TestItems.SILVER_CREDIT)
                .criterion(FabricRecipeProvider.hasItem(Items.IRON_INGOT),
                        FabricRecipeProvider.conditionsFromItem(Items.IRON_INGOT))
                .criterion(FabricRecipeProvider.hasItem(TestItems.SILVER_CREDIT),
                        FabricRecipeProvider.conditionsFromItem(TestItems.SILVER_CREDIT))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(TestItems.BESKAR_ALLOY)));
    }
}