package com.trep.addon.items;

import com.parzivail.pswg.container.SwgSounds;
import com.trep.addon.entity.CustomSnowballEntity;
import com.trep.addon.util.AdventureSounds;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class CustomSnowballItem extends Item {

    public CustomSnowballItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		ItemStack itemStack = user.getStackInHand(hand); // creates a new ItemStack instance of the user's itemStack in-hand
		world.playSound(null, user.getX(), user.getY(), user.getZ(), SwgSounds.Blaster.BYPASS_SECONDARY, SoundCategory.NEUTRAL, 0.5F, 1F); // plays a globalSoundEvent
		user.getItemCooldownManager().set(this, 50);
		/*
		user.getItemCooldownManager().set(this, 5);
		Optionally, you can add a cooldown to your item's right-click use, similar to Ender Pearls.
		*/
		if (!world.isClient) {
			CustomSnowballEntity snowballEntity = new CustomSnowballEntity(world, user);
			snowballEntity.setItem(itemStack);
			snowballEntity.setVelocity(user, user.prevPitch, user.prevYaw, 0.0F, 1.5F, 0F);
                        /*
                        snowballEntity.setProperties(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 1.0F);
                        In 1.17,we will use setProperties instead of setVelocity.                                                        
                        */
			world.spawnEntity(snowballEntity); // spawns entity
			itemStack.decrement(1);
		}
 
		return TypedActionResult.success(itemStack, world.isClient());
	}
}