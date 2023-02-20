package com.example.addon.custom;


import net.minecraft.client.gui.screen.Screen;
        import net.minecraft.client.item.TooltipContext;
        import net.minecraft.entity.player.PlayerEntity;
        import net.minecraft.item.Item;
        import net.minecraft.item.ItemStack;
        import net.minecraft.text.Text;
        import net.minecraft.util.Formatting;
        import net.minecraft.util.Hand;
        import net.minecraft.util.TypedActionResult;
        import net.minecraft.util.math.random.Random;
        import net.minecraft.world.World;
        import org.jetbrains.annotations.Nullable;

        import java.util.List;

public class HolodriveItem extends Item {
    public HolodriveItem(Settings settings) {
        super(settings);
    }


    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(Screen.hasShiftDown()) {
            tooltip.add(Text.literal("<EMPTY>").formatted(Formatting.GRAY));
        } else {
            tooltip.add(Text.literal("<Press Shift for more info!>").formatted(Formatting.GRAY));
        }

        super.appendTooltip(stack, world, tooltip, context);
    }

}