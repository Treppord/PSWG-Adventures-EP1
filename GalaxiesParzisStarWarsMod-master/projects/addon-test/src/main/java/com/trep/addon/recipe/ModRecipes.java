package com.trep.addon.recipe;

import com.trep.addon.TestAddon;

import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {

    public static RecipeType<FabricatorRecipe> SMITHING_ANVIL_RECIPE_TYPE;
    public static void registerRecipes() {
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(TestAddon.MODID, ArmorStationRecipe.Serializer.ID),
                ArmorStationRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(TestAddon.MODID, ArmorStationRecipe.Type.ID),
                ArmorStationRecipe.Type.INSTANCE);

        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(TestAddon.MODID, MarketRecipe.Serializer.ID),
                MarketRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(TestAddon.MODID, MarketRecipe.Type.ID),
                MarketRecipe.Type.INSTANCE);


        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(TestAddon.MODID, BlasterTableRecipe.Serializer.ID),
                BlasterTableRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(TestAddon.MODID, BlasterTableRecipe.Type.ID),
                BlasterTableRecipe.Type.INSTANCE);

        SMITHING_ANVIL_RECIPE_TYPE = Registry.register(Registries.RECIPE_TYPE, FabricatorRecipe.Type.ID, FabricatorRecipe.Type.INSTANCE);
        Registry.register(Registries.RECIPE_SERIALIZER, FabricatorRecipe.Type.ID, FabricatorRecipe.Serializer.INSTANCE);




    }
}