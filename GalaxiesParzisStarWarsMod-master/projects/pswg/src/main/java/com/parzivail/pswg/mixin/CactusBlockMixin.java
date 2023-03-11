package com.parzivail.pswg.mixin;

import com.parzivail.pswg.container.SwgTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.CactusBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CactusBlock.class)
public abstract class CactusBlockMixin
{
	@Inject(method = "canPlaceAt", at = @At(value = "RETURN", ordinal = 1), cancellable = true)
	private void canPlaceAt(BlockState state, WorldView world, BlockPos pos, CallbackInfoReturnable<Boolean> cir)
	{
		var below = world.getBlockState(pos.down());
		if (below.isIn(SwgTags.Block.DESERT_SAND))
			cir.setReturnValue(true);
	}
}
