package com.trep.addon.items;


import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TatooineHolodriveItem extends Item {
    public TatooineHolodriveItem(Settings settings) {
        super(settings);
    }


    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(Screen.hasShiftDown()) {
            tooltip.add(Text.literal("Tatooine").formatted(Formatting.GRAY));
        } else {
            tooltip.add(Text.literal("<Press Shift for more info!>").formatted(Formatting.GRAY));
        }

        super.appendTooltip(stack, world, tooltip, context);
    }

}