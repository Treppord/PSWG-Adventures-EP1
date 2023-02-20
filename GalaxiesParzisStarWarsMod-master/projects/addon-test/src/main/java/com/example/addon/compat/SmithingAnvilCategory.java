package com.example.addon.compat;

import com.example.addon.TestBlocks;
import com.example.addon.screen.SmithingAnvilScreen;
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

public class SmithingAnvilCategory implements DisplayCategory<SmithingAnvilDisplay> {
    public static final Text TITLE = Text.translatable("rei.pswg-addon-test.fabricator");
    public static final EntryStack<ItemStack> ICON = EntryStacks.of(TestBlocks.SMITHING_ANVIL);

    @Override
    public Renderer getIcon() {
        return ICON;
    }

    @Override
    public Text getTitle() {
        return TITLE;
    }

    @Override
    public CategoryIdentifier<? extends SmithingAnvilDisplay> getCategoryIdentifier() {
        return TestAddonPlugin.SMITHING_ANVIL_CATEGORY;
    }

    @Override
    public List<Widget> setupDisplay(SmithingAnvilDisplay display, Rectangle bounds) {
        List<Widget> widgets = new ArrayList<>();

        Point startPoint = new Point(bounds.getCenterX() - 20, bounds.getCenterY() - 26);
        Point outputPoint = new Point(bounds.getCenterX() + 37, bounds.getCenterY());

        widgets.add(Widgets.createRecipeBase(bounds));
        widgets.add(Widgets.createTexturedWidget(SmithingAnvilScreen.TEXTURE, startPoint.x, startPoint.y + 16, 20, 32, 16, 20, 16, 20, 256, 256));
        widgets.add(Widgets.createArrow(new Point(bounds.getCenterX(), bounds.getCenterY())));

        List<EntryIngredient> inputs = display.getInputEntries();
        widgets.add(Widgets.createSlot(new Point(startPoint.x, startPoint.y)).entries(inputs.get(0)).markInput());
        widgets.add(Widgets.createSlot(new Point(startPoint.x, bounds.getCenterY() + 10)).entries(inputs.get(1)).markInput());

        widgets.add(Widgets.createResultSlotBackground(outputPoint));
        widgets.add(Widgets.createSlot(outputPoint).entries(display.getOutputEntries().get(0)).disableBackground().markOutput());

        return widgets;
    }
}