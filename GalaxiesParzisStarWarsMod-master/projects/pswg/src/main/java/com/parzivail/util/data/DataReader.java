package com.parzivail.util.data;

import com.parzivail.util.ParziUtil;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtIo;
import net.minecraft.registry.Registries;
import net.minecraft.state.property.Property;
import net.minecraft.util.Identifier;
import org.joml.Matrix4f;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.StandardOpenOption;

public class DataReader
{
	public static String readNullTerminatedString(DataInput s) throws IOException
	{
		var str = new StringBuilder();
		while (true)
		{
			var b = s.readByte();
			if (b == 0)
				return str.toString();
			str.append((char)b);
		}
	}

	public static int read7BitEncodedInt(InputStream is) throws IOException
	{
		var count = 0;
		var shift = 0;
		var more = true;
		while (more)
		{
			var b = (byte)is.read();
			count |= (b & 0x7F) << shift;
			shift += 7;
			if ((b & 0x80) == 0)
			{
				more = false;
			}
		}
		return count;
	}

	public static NbtCompound readUncompressedNbt(DataInput s, int len) throws IOException
	{
		var bytesNbt = new byte[len];
		s.readFully(bytesNbt);

		var stream = new DataInputStream(new ByteArrayInputStream(bytesNbt));
		var tag = NbtIo.read(stream);
		stream.close();
		return tag;
	}

	public static FileChannel getFile(String domain, Identifier resourceLocation)
	{
		try
		{
			var container = FabricLoader.getInstance().getModContainer(resourceLocation.getNamespace()).orElseThrow(IllegalStateException::new);
			var path = container.findPath(domain + "/" + resourceLocation.getNamespace() + "/" + resourceLocation.getPath()).orElseThrow(IllegalStateException::new);

			return FileChannel.open(path, StandardOpenOption.READ);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		return null;
	}

	public static BlockState readBlockState(DataInput stream) throws IOException
	{
		var name = readNullTerminatedString(stream);
		var hasProperties = stream.readByte() == 1;

		var blockRegistry = Registries.BLOCK;
		var block = blockRegistry.get(new Identifier(name));
		var blockState = block.getDefaultState();

		if (hasProperties)
		{
			var stateManager = block.getStateManager();

			var tagLen = stream.readInt();
			var props = readUncompressedNbt(stream, tagLen);

			for (var key : props.getKeys())
			{
				var property = stateManager.getProperty(key);
				if (property != null)
					blockState = withProperty(blockState, property, key, props, blockState.toString());
			}
		}

		return blockState;
	}

	private static <T extends Comparable<T>> BlockState withProperty(BlockState state, Property<T> property, String key, NbtCompound propertiesTag, String context)
	{
		var optional = property.parse(propertiesTag.getString(key));
		if (optional.isPresent())
			return state.with(property, optional.get());
		else
		{
			ParziUtil.LOG.warn("Unable to read property: %s with value: %s for blockstate: %s", key, propertiesTag.getString(key), context);
			return state;
		}
	}

	public static Matrix4f readMatrix4f(DataInput s) throws IOException
	{
		var dat = new float[16];

		for (int i = 0; i < 16; i++)
			dat[i] = s.readFloat();

		return new Matrix4f().setTransposed(dat);
	}
}
