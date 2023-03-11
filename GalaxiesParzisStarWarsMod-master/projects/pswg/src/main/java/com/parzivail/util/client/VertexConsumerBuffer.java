package com.parzivail.util.client;

import com.parzivail.util.math.MathUtil;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Vec3d;
import org.joml.Vector3f;
import org.joml.Vector4f;

public enum VertexConsumerBuffer
{
	Instance;

	private VertexConsumer vertexConsumer;
	private MatrixStack.Entry matrices;
	private float r;
	private float g;
	private float b;
	private float a;
	private int overlay;
	private int light;

	public void init(VertexConsumer vertexConsumer, MatrixStack.Entry matrices, float r, float g, float b, float a, int overlay, int light)
	{
		this.vertexConsumer = vertexConsumer;
		this.matrices = matrices;
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
		this.overlay = overlay;
		this.light = light;
	}

	public void setMatrices(MatrixStack.Entry matrices)
	{
		this.matrices = matrices;
	}

	public void setColor(float r, float g, float b, float a)
	{
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
	}

	public void setColor(int argb)
	{
		this.a = ((argb >> 24) & 0xFF) / 255f;
		this.r = ((argb >> 16) & 0xFF) / 255f;
		this.g = ((argb >> 8) & 0xFF) / 255f;
		this.b = (argb & 0xFF) / 255f;
	}

	public void setColor(int baseRgb, int a)
	{
		this.a = (a & 0xFF) / 255f;
		this.r = ((baseRgb >> 16) & 0xFF) / 255f;
		this.g = ((baseRgb >> 8) & 0xFF) / 255f;
		this.b = (baseRgb & 0xFF) / 255f;
	}

	public void setOverlay(int overlay)
	{
		this.overlay = overlay;
	}

	public void setLight(int light)
	{
		this.light = light;
	}

	public void vertex(Vector3f pos, Vector3f normal, float u, float v)
	{
		var pos4 = new Vector4f(pos.x, pos.y, pos.z, 1);
		normal = new Vector3f(normal);

		pos4.mul(matrices.getPositionMatrix());
		normal.mul(matrices.getNormalMatrix());

		vertexConsumer.vertex(pos4.x, pos4.y, pos4.z, r, g, b, a, u, v, overlay, light, normal.x, normal.y, normal.z);
	}

	public void vertex(float x, float y, float z, float nx, float ny, float nz, float u, float v)
	{
		vertex(new Vector3f(x, y, z), new Vector3f(nx, ny, nz), u, v);
	}

	public void line(float x1, float y1, float z1, float x2, float y2, float z2)
	{
		var start = new Vector3f(x1, y1, z1);
		var end = new Vector3f(x2, y2, z2);
		var normal = new Vector3f(x2, y2, z2);
		normal.sub(start);
		normal.normalize();

		vertex(start, normal,0, 0);
		vertex(end, normal,0, 0);
	}

	public void line(Vec3d start, Vec3d end)
	{
		var normal = new Vec3d(end.x, end.y, end.z).subtract(start).normalize();

		vertex((float)start.x, (float)start.y, (float)start.z, (float)normal.x, (float)normal.y, (float)normal.z,0, 0);
		vertex((float)end.x, (float)end.y, (float)end.z, (float)normal.x, (float)normal.y, (float)normal.z,0, 0);
	}

	public void axes(float scale)
	{
		setColor(1, 0, 0, 1);
		line(Vec3d.ZERO, MathUtil.POSX.multiply(scale));
		setColor(0, 1, 0, 1);
		line(Vec3d.ZERO, MathUtil.POSY.multiply(scale));
		setColor(0, 0, 1, 1);
		line(Vec3d.ZERO, MathUtil.POSZ.multiply(scale));
	}
}
