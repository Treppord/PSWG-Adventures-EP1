package com.example.addon.recipe;

import com.parzivail.pswg.Resources;
import com.parzivail.pswg.container.SwgRecipeType;
import com.parzivail.pswg.recipe.VaporatorRecipe;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;

public class TestRecipeType {
    public static final ArrayList<RecipeType<?>> RECIPE_TYPES = new ArrayList<>();

    public static final RecipeType<ArmorStationRecipe> ARMOR_STATION = register(Resources.id("armor_station"));

    public static void register()
    {
    }

    private static <T extends Recipe<?>> TestRecipeType.RecipeTypeImpl<T> register(Identifier identifier)
    {
        TestRecipeType.RecipeTypeImpl<T> type = Registry.register(Registries.RECIPE_TYPE, identifier, new TestRecipeType.RecipeTypeImpl<>(identifier));
        RECIPE_TYPES.add(type);
        return type;
    }

    private record RecipeTypeImpl<T extends Recipe<?>>(Identifier identifier) implements RecipeType<T>
    {

        @Override
        public String toString()
        {
            return identifier.toString();
        }
    }
}
