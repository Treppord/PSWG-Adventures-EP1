package com.parzivail.util.world;

import com.parzivail.util.math.MathUtil;
import com.parzivail.util.noise.InfiniteWorleyNoise;
import com.parzivail.util.noise.OpenSimplex2F;
import net.minecraft.util.math.MathHelper;

public class ProcNoise
{
	private final OpenSimplex2F _noise;
	private final InfiniteWorleyNoise _worley;
	private final long _seed;

	public ProcNoise(long seed)
	{
		_seed = seed;
		_noise = new OpenSimplex2F(seed);
		_worley = new InfiniteWorleyNoise(seed);
	}

	public double noise(double x, double z)
	{
		return (_noise.noise2(x, z) + 1) / 2;
	}

	public double rawNoise(double x, double z)
	{
		return _noise.noise2(x, z);
	}

	public double noise(double x, double y, double z)
	{
		return (_noise.noise3_XZBeforeY(x, y, z) + 1) / 2;
	}

	public double rawNoise(double x, double y, double z)
	{
		return _noise.noise3_XZBeforeY(x, y, z);
	}

	public double noise(double x, double y, double z, double w)
	{
		return (_noise.noise4_XZBeforeYW(x, y, z, w) + 1) / 2;
	}

	public double rawNoise(double x, double y, double z, double w)
	{
		return _noise.noise4_XZBeforeYW(x, y, z, w);
	}

	public double worley(double x, double z)
	{
		return _worley.eval(x, z);
	}

	public double rawWorley(double x, double z)
	{
		return _worley.eval(x, z) * 2 - 1;
	}

	public double worley(double x, double y, double z)
	{
		return _worley.eval((float)x, (float)y, (float)z);
	}

	public double rawWorley(double x, double y, double z)
	{
		return _worley.eval((float)x, (float)y, (float)z) * 2 - 1;
	}

	public double noiseDx(double x, double z)
	{
		var n = noise(x, z);
		var d = 0.001;
		return noise(x, z + d) - n;
	}

	public double noiseDz(double x, double z)
	{
		var n = noise(x, z);
		var d = 0.001;
		return noise(x + d, z) - n;
	}

	public double octaveNoise(double x, double z, int octaves)
	{
		var n = noise(x, z) / 2;
		if (octaves <= 1)
			return n / (1 - 1 / Math.pow(2, octaves));
		return n + octaveNoise((x + octaves * 100) * 2, (z + octaves * 100) * 2, octaves - 1) / 2;
	}

	public double octaveWorley(double x, double z, int octaves)
	{
		var n = worley(x, z) / 2;
		if (octaves <= 1)
			return n / (1 - 1 / Math.pow(2, octaves));
		return n + octaveWorley((x + octaves * 100) * 2, (z + octaves * 100) * 2, octaves - 1) / 2;
	}

	public double octaveInvWorley(double x, double z, int octaves)
	{
		var n = (1 - worley(x, z)) / 2;
		if (octaves <= 1)
			return n / (1 - 1 / Math.pow(2, octaves));
		return n + octaveInvWorley((x + octaves * 100) * 2, (z + octaves * 100) * 2, octaves - 1) / 2;
	}

	public double hashA(double x, double z)
	{
		return MathUtil.fract(Math.sin(MathUtil.seed(x - 173.37, _seed) * 7441.35 - 4113.21 * Math.cos(x * z) + MathUtil.seed(z - 1743.7, _seed) * 1727.93 * 1291.27) * 2853.85 + MathUtil.ONE_OVER_GOLDEN_RATIO);
	}

	public double hashB(double x, double z)
	{
		return MathUtil.fract(Math.cos(MathUtil.seed(z - 143.37, _seed) * 4113.21 - 2853.85 * Math.sin(x * z) + MathUtil.seed(x - 743.37, _seed) * 1291.27 * 1727.93) * 4113.21 + MathUtil.ONE_OVER_GOLDEN_RATIO);
	}

	public double swissTurbulence(double pX, double pY, int octaves, double lacunarity, double gain, double warp)
	{
		double sum = 0;
		double freq = 1;
		double amp = 1;
		double dSumX = 0;
		double dSumY = 0;

		for (var i = 0; i < octaves; i++)
		{
			var x = (pX + warp * dSumX) * freq + i * 1000;
			var y = (pY + warp * dSumY) * freq + i * 1000;

			var nX = noise(x, y);
			var nY = noiseDx(x, y);
			var nZ = noiseDz(x, y);

			sum = sum + amp * (1 - Math.abs(nX));
			dSumX = dSumX + amp * nY * -nX;
			dSumY = dSumY + amp * nZ * -nX;
			freq = freq * lacunarity;
			amp = amp * gain * MathHelper.clamp(sum, 0, 1);
		}

		return sum;
	}
}
