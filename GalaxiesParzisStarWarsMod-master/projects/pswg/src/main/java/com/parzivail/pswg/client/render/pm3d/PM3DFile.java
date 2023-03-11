package com.parzivail.pswg.client.render.pm3d;

import com.google.common.io.LittleEndianDataInputStream;
import com.parzivail.pswg.util.PIO;
import com.parzivail.util.client.model.ModelUtil;
import com.parzivail.util.data.DataReader;
import net.minecraft.util.Identifier;
import net.minecraft.util.crash.CrashException;
import net.minecraft.util.crash.CrashReport;
import net.minecraft.util.math.MathHelper;
import org.apache.commons.lang3.ArrayUtils;
import org.joml.Vector3f;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public record PM3DFile(PM3DLod[] lods)
{
	private static final String MAGIC = "Pm3D";
	private static final int[] ACCEPTED_VERSIONS = { 0x05 };

	public PM3DLod getLevelOfDetail(int lod)
	{
		return lods[MathHelper.clamp(lod, 0, lods.length - 1)];
	}

	public static PM3DFile tryLoad(Identifier modelFile, boolean blockOffset)
	{
		try
		{
			return load(modelFile, blockOffset);
		}
		catch (NullPointerException | IOException ex)
		{
			ex.printStackTrace();
			var crashReport = CrashReport.create(ex, String.format("Loading PM3D file: %s (%s)", modelFile, ex.getMessage()));
			throw new CrashException(crashReport);
		}
	}

	public static PM3DFile loadOrNull(Identifier modelFile, boolean blockOffset)
	{
		try
		{
			return load(modelFile, blockOffset);
		}
		catch (NullPointerException | IOException ex)
		{
			return null;
		}
	}

	private static PM3DFile load(Identifier modelFile, boolean blockOffset) throws IOException
	{
		// TODO: convert this to a KeyedReloadableLoader
		var reader = PIO.getStream("assets", modelFile);
		var objStream = new LittleEndianDataInputStream(reader);

		var identBytes = new byte[MAGIC.length()];
		var read = objStream.read(identBytes);
		var ident = new String(identBytes);
		if (!ident.equals(MAGIC) || read != identBytes.length)
			throw new IOException("Input file not PM3D model");

		var version = objStream.readInt();

		if (!ArrayUtils.contains(ACCEPTED_VERSIONS, version))
			throw new IOException(String.format("Input file version is 0x%s, expected one of: %s", Integer.toHexString(version), getAcceptedVersionString()));

		var numLods = objStream.readInt();

		var lods = new PM3DLod[numLods];

		for (var i = 0; i < numLods; i++)
		{
			var numVerts = objStream.readInt();
			var numNormals = objStream.readInt();
			var numUvs = objStream.readInt();
			var numObjects = objStream.readInt();

			var verts = loadVerts(numVerts, objStream, blockOffset);
			var normals = loadNormals(numNormals, objStream);
			var uvs = loadUvs(numUvs, objStream);
			var objects = loadObjects(numObjects, objStream);

			var bounds = ModelUtil.getBounds(List.of(verts));

			lods[i] = new PM3DLod(modelFile, verts, normals, uvs, objects, bounds);
		}

		return new PM3DFile(lods);
	}

	private static String getAcceptedVersionString()
	{
		return Arrays.stream(ACCEPTED_VERSIONS).mapToObj(i -> "0x" + Integer.toHexString(i)).collect(Collectors.joining(", "));
	}

	private static Vector3f[] loadVerts(int num, LittleEndianDataInputStream objStream, boolean blockOffset) throws IOException
	{
		var verts = new Vector3f[num];

		for (var i = 0; i < num; i++)
		{
			var x = objStream.readFloat();
			var y = objStream.readFloat();
			var z = objStream.readFloat();

			if (blockOffset)
			{
				x += 0.5f;
				z += 0.5f;
			}

			verts[i] = new Vector3f(x, y, z);
		}

		return verts;
	}

	private static Vector3f[] loadNormals(int num, LittleEndianDataInputStream objStream) throws IOException
	{
		var verts = new Vector3f[num];

		for (var i = 0; i < num; i++)
		{
			var x = objStream.readFloat();
			var y = objStream.readFloat();
			var z = objStream.readFloat();

			verts[i] = new Vector3f(x, y, z);
		}

		return verts;
	}

	private static Vector3f[] loadUvs(int num, LittleEndianDataInputStream objStream) throws IOException
	{
		var uvs = new Vector3f[num];

		for (var i = 0; i < num; i++)
		{
			var u = objStream.readFloat();
			var v = objStream.readFloat();

			uvs[i] = new Vector3f(u, v, 0);
		}

		return uvs;
	}

	private static PM3DObject[] loadObjects(int num, LittleEndianDataInputStream objStream) throws IOException
	{
		var objects = new PM3DObject[num];

		for (var i = 0; i < num; i++)
		{
			var objName = DataReader.readNullTerminatedString(objStream);
			var numFaces = objStream.readInt();

			var faces = new ArrayList<PM3DFace>();

			for (var j = 0; j < numFaces; j++)
			{
				var material = objStream.readByte();
				var face = new PM3DFace(material);
				var numVerts = objStream.readInt();
				for (var k = 0; k < numVerts; k++)
				{
					var vertex = DataReader.read7BitEncodedInt(objStream);
					var normal = DataReader.read7BitEncodedInt(objStream);
					var texture = DataReader.read7BitEncodedInt(objStream);
					face.verts.add(new PM3DVertPointer(vertex, normal, texture));
				}

				faces.add(face);
			}

			objects[i] = new PM3DObject(objName, faces);
		}

		return objects;
	}
}
