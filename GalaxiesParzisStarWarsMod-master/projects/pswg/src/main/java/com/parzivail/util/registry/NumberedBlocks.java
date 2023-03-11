package com.parzivail.util.registry;

import net.minecraft.block.Block;

import java.util.function.Function;

public class NumberedBlocks extends Numbered<Block>
{
	public NumberedBlocks(int count, Function<Integer, Block> blockFunction)
	{
		super(count, blockFunction);
	}
}
