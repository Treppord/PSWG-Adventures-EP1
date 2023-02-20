package com.example.addon.compat;
import com.example.addon.TestAddon;
import com.example.addon.TestBlocks;
import com.example.addon.recipe.SmithingAnvilRecipe;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.entry.EntryRegistry;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.item.ItemStack;

public class TestAddonPlugin implements REIClientPlugin


{
    public static final CategoryIdentifier<SmithingAnvilDisplay> SMITHING_ANVIL_CATEGORY = CategoryIdentifier.of(SmithingAnvilRecipe.Type.ID);


    @Override
    public void registerCategories(CategoryRegistry registry)
    {
        registry.add(new SmithingAnvilCategory());

        registry.addWorkstations(SMITHING_ANVIL_CATEGORY, EntryStacks.of(TestBlocks.SMITHING_ANVIL));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry)
    {
        registry.registerFiller(SmithingAnvilRecipe.class, SmithingAnvilDisplay::new);
    }

    @Override
    public void registerEntries(EntryRegistry registry)
    {
        registry.removeEntry(EntryStacks.of(new ItemStack(TestAddon.PSWGADDON_TAB_ITEM)));
    }
}