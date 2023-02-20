package com.example.addon.recipe;

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

public class MarketRecipe implements Recipe<SimpleInventory> {
    private final Identifier id;
    private final ItemStack output;
    private final DefaultedList<Ingredient> recipeItems;

    public MarketRecipe(Identifier id, ItemStack output, DefaultedList<Ingredient> recipeItems) {
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
    }

    @Override
    public boolean matches(SimpleInventory inventory, World world) {
        if(world.isClient()) {
            return false;
        }

        return recipeItems.get(0).test(inventory.getStack(1));
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

    public static class Type implements RecipeType<MarketRecipe> {
        private Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "market";
    }

    public static class Serializer implements RecipeSerializer<MarketRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "market";
        // this is the name given in the json file

        @Override
        public MarketRecipe read(Identifier id, JsonObject json) {
            ItemStack output = ShapedRecipe.outputFromJson(JsonHelper.getObject(json, "output"));

            JsonArray ingredients = JsonHelper.getArray(json, "ingredients");
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(1, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new MarketRecipe(id, output, inputs);
        }

        @Override
        public MarketRecipe read(Identifier id, PacketByteBuf buf) {
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(buf.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromPacket(buf));
            }

            ItemStack output = buf.readItemStack();
            return new MarketRecipe(id, output, inputs);
        }

        @Override
        public void write(PacketByteBuf buf, MarketRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());
            for (Ingredient ing : recipe.getIngredients()) {
                ing.write(buf);
            }
            buf.writeItemStack(recipe.getOutput());
        }
    }
}