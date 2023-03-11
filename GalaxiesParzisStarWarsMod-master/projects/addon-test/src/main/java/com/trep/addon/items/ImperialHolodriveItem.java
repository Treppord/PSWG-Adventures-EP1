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

public class ImperialHolodriveItem extends Item {
    public ImperialHolodriveItem(Settings settings) {
        super(settings);
    }


    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(Screen.hasShiftDown()) {
            tooltip.add(Text.literal("Imperial").formatted(Formatting.GRAY));
        } else {
            tooltip.add(Text.literal("<Press Shift for more info!>").formatted(Formatting.GRAY));
        }

        super.appendTooltip(stack, world, tooltip, context);
    }

}