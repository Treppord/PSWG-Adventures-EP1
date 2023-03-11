package com.parzivail.util.block;

import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

public class VoxelShapeUtil
{
	public static VoxelShape getCenteredCube(float width, float height)
	{
		width /= 32;
		height /= 16;
		return VoxelShapes.cuboid(0.5 - width, 0, 0.5 - width, 0.5 + width, height, 0.5 + width);
	}

	public static VoxelShape getCenteredCube(float width, float height, float dX, float dZ)
	{
		width /= 32;
		height /= 16;
		dX /= 16;
		dZ /= 16;
		return VoxelShapes.cuboid(0.5 - width + dX, 0, 0.5 - width + dZ, 0.5 + width + dX, height, 0.5 + width + dZ);
	}

	public static VoxelShape getCentered(float length, float width, float height)
	{
		length /= 32;
		width /= 32;
		height /= 16;
		return VoxelShapes.cuboid(0.5 - length, 0, 0.5 - width, 0.5 + length, height, 0.5 + width);
	}

	public static VoxelShape rotateToFace(VoxelShape shape, Direction direction)
	{
		if (direction == Direction.UP)
			return VoxelShapeUtil.rotate(shape, Direction.Axis.Z, 3, 0.5f, 0.5f, 0.5f);
		if (direction == Direction.DOWN)
			return VoxelShapeUtil.rotate(shape, Direction.Axis.Z, 1, 0.5f, 0.5f, 0.5f);
		// East isn't zero, but everything defaults to facing east
		return VoxelShapeUtil.rotate(shape, (direction.getHorizontal() + 1) % 4);
	}

	public static VoxelShape rotate(VoxelShape shape, int times)
	{
		return rotate(shape, Direction.Axis.Y, times, 0.5f, 0, 0.5f);
	}

	public static VoxelShape rotate(VoxelShape shape, Direction.Axis axis, int times, float cX, float cY, float cZ)
	{
		var rotatedShape = VoxelShapes.empty();
		for (var box : shape.getBoundingBoxes())
		{
			var rotatedBox = rotateAABB(box, axis, times, cX, cY, cZ);
			rotatedShape = VoxelShapes.union(rotatedShape, rotatedBox);
		}
		return rotatedShape;
	}

	private static VoxelShape rotateAABB(Box box, Direction.Axis axis, int times, float cX, float cY, float cZ)
	{
		double tmp;

		var minX = box.getMin(Direction.Axis.X);
		var minY = box.getMin(Direction.Axis.Y);
		var minZ = box.getMin(Direction.Axis.Z);

		var maxX = box.getMax(Direction.Axis.X);
		var maxY = box.getMax(Direction.Axis.Y);
		var maxZ = box.getMax(Direction.Axis.Z);

		switch (axis)
		{
			case X:
				for (var i = 0; i < times; i++)
				{
					tmp = minY;
					minY = cY + minZ - cZ;
					minZ = cZ - tmp + cY;
					tmp = maxY;
					maxY = cY + maxZ - cZ;
					maxZ = cZ - tmp + cY;
				}
				break;
			case Y:
				for (var i = 0; i < times; i++)
				{
					tmp = minZ;
					minZ = cZ + minX - cX;
					minX = cX - tmp + cZ;
					tmp = maxZ;
					maxZ = cZ + maxX - cX;
					maxX = cX - tmp + cZ;
				}
				break;
			case Z:
				for (var i = 0; i < times; i++)
				{
					tmp = minX;
					minX = cX + minY - cY;
					minY = cY - tmp + cX;
					tmp = maxX;
					maxX = cX + maxY - cY;
					maxY = cY - tmp + cX;
				}
				break;
		}

		if (minX > maxX)
		{
			var temp = minX;
			minX = maxX;
			maxX = temp;
		}

		if (minY > maxY)
		{
			var temp = minY;
			minY = maxY;
			maxY = temp;
		}

		if (minZ > maxZ)
		{
			var temp = minZ;
			minZ = maxZ;
			maxZ = temp;
		}

		return VoxelShapes.cuboid(minX, minY, minZ, maxX, maxY, maxZ);
	}

	public static Vec3d getCenter(VoxelShape shape)
	{
		return new Vec3d((shape.getMin(Direction.Axis.X) + shape.getMax(Direction.Axis.X)) / 2,
		                 (shape.getMin(Direction.Axis.Y) + shape.getMax(Direction.Axis.Y)) / 2,
		                 (shape.getMin(Direction.Axis.Z) + shape.getMax(Direction.Axis.Z)) / 2);
	}
}
