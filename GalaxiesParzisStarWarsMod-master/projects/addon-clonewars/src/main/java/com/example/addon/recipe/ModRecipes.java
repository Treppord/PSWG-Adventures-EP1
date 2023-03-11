package com.example.addon.recipe;

import com.example.addon.TestAddon;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {
    public static void registerRecipes() {
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(TestAddon.MODID, ArmorStationRecipe.Serializer.ID),
                ArmorStationRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(TestAddon.MODID, ArmorStationRecipe.Type.ID),
                ArmorStationRecipe.Type.INSTANCE);
    }
}