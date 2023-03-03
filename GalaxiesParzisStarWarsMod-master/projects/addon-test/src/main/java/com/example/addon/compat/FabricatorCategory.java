package com.example.addon.compat;

import com.example.addon.blocks.AdventureBlocks;
import com.example.addon.screen.FabricatorScreen;
import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.entry.EntryStack;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;

import java.util.ArrayList;
import java.util.List;

public class FabricatorCategory implements DisplayCategory<FabricatorDisplay> {
    public static final Text TITLE = Text.translatable("rei.pswg-adventures.fabricator");
    public static final EntryStack<ItemStack> ICON = EntryStacks.of(AdventureBlocks.SMITHING_ANVIL);

    @Override
    public Renderer getIcon() {
        return ICON;
    }

    @Override
    public Text getTitle() {
        return TITLE;
    }

    @Override
    public CategoryIdentifier<? extends FabricatorDisplay> getCategoryIdentifier() {
        return TestAddonPlugin.FABRICATOR_DISPLAY_CATEGORY_IDENTIFIER;
    }

    @Override
    public List<Widget> setupDisplay(FabricatorDisplay display, Rectangle bounds) {
        List<Widget> widgets = new ArrayList<>();

        Point startPoint = new Point(bounds.getCenterX() - 20, bounds.getCenterY() - 26);
        Point outputPoint = new Point(bounds.getCenterX() + 37, bounds.getCenterY());

        widgets.add(Widgets.createRecipeBase(bounds));
        widgets.add(Widgets.createTexturedWidget(FabricatorScreen.TEXTURE, startPoint.x, startPoint.y + 16, 20, 32, 16, 20, 16, 20, 256, 256));
        widgets.add(Widgets.createArrow(new Point(bounds.getCenterX(), bounds.getCenterY())));

        List<EntryIngredient> inputs = display.getInputEntries();
        widgets.add(Widgets.createSlot(new Point(startPoint.x, startPoint.y)).entries(inputs.get(0)).markInput());
        widgets.add(Widgets.createSlot(new Point(startPoint.x, bounds.getCenterY() + 10)).entries(inputs.get(1)).markInput());

        widgets.add(Widgets.createResultSlotBackground(outputPoint));
        widgets.add(Widgets.createSlot(outputPoint).entries(display.getOutputEntries().get(0)).disableBackground().markOutput());

        return widgets;
    }
}