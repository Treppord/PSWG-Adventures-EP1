package com.trep.addon.compat;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.trep.addon.recipe.FabricatorRecipe;

public class FabricatorDisplay implements Display
{
    private final List<EntryIngredient> inputs;
    private final EntryIngredient output;

    public FabricatorDisplay(FabricatorRecipe recipe)
    {
        EntryIngredient hammerInput = EntryIngredients.ofIngredient(recipe.getIngredients().get(0));

        EntryIngredient materials = EntryIngredients.ofItemStacks(
                Arrays.stream(recipe.getIngredients().get(1).getMatchingStacks()).peek(stack -> stack.setCount(recipe.getMaterialCost())).toList());
        inputs = List.of(hammerInput, materials);
        output = EntryIngredients.of(recipe.getOutput());
    }

    @Override
    public List<EntryIngredient> getInputEntries()
    {
        return inputs;
    }

    @Override
    public List<EntryIngredient> getOutputEntries()
    {
        return Collections.singletonList(output);
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier()
    {
        return TestAddonPlugin.FABRICATOR_DISPLAY_CATEGORY_IDENTIFIER;
    }
}