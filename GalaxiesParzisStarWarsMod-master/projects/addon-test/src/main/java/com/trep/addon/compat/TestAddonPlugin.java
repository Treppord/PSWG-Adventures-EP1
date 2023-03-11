package com.trep.addon.compat;
import com.trep.addon.TestAddon;
import com.trep.addon.blocks.AdventureBlocks;
import com.trep.addon.recipe.FabricatorRecipe;

import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.entry.EntryRegistry;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.item.ItemStack;

public class TestAddonPlugin implements REIClientPlugin


{
    public static final CategoryIdentifier<FabricatorDisplay> FABRICATOR_DISPLAY_CATEGORY_IDENTIFIER = CategoryIdentifier.of(FabricatorRecipe.Type.ID);


    @Override
    public void registerCategories(CategoryRegistry registry)
    {
        registry.add(new FabricatorCategory());

        registry.addWorkstations(FABRICATOR_DISPLAY_CATEGORY_IDENTIFIER, EntryStacks.of(AdventureBlocks.SMITHING_ANVIL));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry)
    {
        registry.registerFiller(FabricatorRecipe.class, FabricatorDisplay::new);
    }

    @Override
    public void registerEntries(EntryRegistry registry)
    {
        registry.removeEntry(EntryStacks.of(new ItemStack(TestAddon.PSWGADDON_TAB_ITEM)));
    }
}