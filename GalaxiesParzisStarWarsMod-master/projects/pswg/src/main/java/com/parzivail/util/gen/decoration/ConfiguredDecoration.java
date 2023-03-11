package com.parzivail.util.gen.decoration;

import com.parzivail.util.gen.decorator.Decorator;
import com.parzivail.util.gen.world.WorldGenView;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.chunk.ChunkGenerator;

import java.util.Random;

public record ConfiguredDecoration(Decorator decorator, Decoration decoration)
{
	public void generate(WorldGenView world, ChunkGenerator generator, Random random, BlockPos pos) {
		for (BlockPos p : decorator.findPositions(world, generator, random, pos))
		{
			decoration.generate(world, generator, random, p);
		}
	}

	public static ConfiguredDecoration of(Decorator decorator, Decoration decoration) {
		return new ConfiguredDecoration(decorator, decoration);
	}
}
