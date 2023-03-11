package com.trep.addon.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

/**
 * The type Armor station recipe.
 */
public class ArmorStationRecipe implements Recipe<SimpleInventory> {
    private final Identifier id;
    private final ItemStack output;
    private final DefaultedList<Ingredient> recipeItems;

    /**
     * Instantiates a new Armor station recipe.
     *
     * @param id          the id
     * @param output      the output
     * @param recipeItems the recipe items
     */
    public ArmorStationRecipe(Identifier id, ItemStack output, DefaultedList<Ingredient> recipeItems) {
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
    }

    @Override
    public boolean matches(SimpleInventory inventory, World world) {
        if(world.isClient()) {
            return false;
        }
        if(recipeItems.get(0).test(inventory.getStack(1))) {
            return recipeItems.get(1).test(inventory.getStack(2));


        }


        return false;
    }

    @Override
    public ItemStack craft(SimpleInventory inventory) {
        return output;
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getOutput() {
        return output.copy();
    }

    @Override
    public Identifier getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;

    }

    /**
     * The type Type.
     */
    public static class Type implements RecipeType<ArmorStationRecipe> {
        private Type() { }

        /**
         * The constant INSTANCE.
         */
        public static final Type INSTANCE = new Type();
        /**
         * The constant ID.
         */
        public static final String ID = "armor_station";
    }

    /**
     * The type Serializer.
     */
    public static class Serializer implements RecipeSerializer<ArmorStationRecipe> {
        /**
         * The constant INSTANCE.
         */
        public static final Serializer INSTANCE = new Serializer();
        /**
         * The constant ID.
         */
        public static final String ID = "armor_station";
        // this is the name given in the json file

        @Override
        public ArmorStationRecipe read(Identifier id, JsonObject json) {
            ItemStack output = ShapedRecipe.outputFromJson(JsonHelper.getObject(json, "output"));

            JsonArray ingredients = JsonHelper.getArray(json, "ingredients");
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(2, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new ArmorStationRecipe(id, output, inputs);
        }

        @Override
        public ArmorStationRecipe read(Identifier id, PacketByteBuf buf) {
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(buf.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromPacket(buf));
            }

            ItemStack output = buf.readItemStack();
            return new ArmorStationRecipe(id, output, inputs);
        }

        @Override
        public void write(PacketByteBuf buf, ArmorStationRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());
            for (Ingredient ing : recipe.getIngredients()) {
                ing.write(buf);
            }
            buf.writeItemStack(recipe.getOutput());
        }
    }
}