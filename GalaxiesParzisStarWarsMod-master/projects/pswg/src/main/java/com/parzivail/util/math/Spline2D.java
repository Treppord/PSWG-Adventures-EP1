package com.parzivail.util.math;

import net.minecraft.util.math.Vec2f;

public class Spline2D
{
	private Spline splineX;
	private Spline splineY;
	/**
	 * Total length tracing the points on the spline
	 */
	private double length;

	/**
	 * Creates a new Spline2D.
	 *
	 * @param points
	 */
	public Spline2D(Vec2f[] points)
	{
		var x = new double[points.length];
		var y = new double[points.length];

		for (var i = 0; i < points.length; i++)
		{
			x[i] = points[i].x;
			y[i] = points[i].y;
		}

		init(x, y);
	}

	/**
	 * Creates a new Spline2D.
	 *
	 * @param x
	 * @param y
	 */
	public Spline2D(double[] x, double[] y)
	{
		init(x, y);
	}

	private void init(double[] x, double[] y)
	{
		if (x.length != y.length)
		{
			throw new IllegalArgumentException("Arrays must have the same length.");
		}

		if (x.length < 2)
		{
			throw new IllegalArgumentException("Spline edges must have at least two points.");
		}

		/*
	  Array representing the relative proportion of the total squareDistance
	  of each point in the line ( i.e. first point is 0.0, end point is
	  1.0, a point halfway on line is 0.5 ).
	 */
		var t = new double[x.length];
		t[0] = 0.0; // start point is always 0.0

		// Calculate the partial proportions of each section between each set
		// of points and the total length of sum of all sections
		for (var i = 1; i < t.length; i++)
		{
			var lx = x[i] - x[i - 1];
			var ly = y[i] - y[i - 1];
			// If either diff is zero there is no point performing the square root
			if (0.0 == lx)
			{
				t[i] = Math.abs(ly);
			}
			else if (0.0 == ly)
			{
				t[i] = Math.abs(lx);
			}
			else
			{
				t[i] = Math.sqrt(lx * lx + ly * ly);
			}

			length += t[i];
			t[i] += t[i - 1];
		}

		for (var i = 1; i < (t.length) - 1; i++)
		{
			t[i] = t[i] / length;
		}

		t[(t.length) - 1] = 1.0; // end point is always 1.0

		splineX = new Spline(t, x);
		splineY = new Spline(t, y);
	}

	/**
	 * @param t 0 <= t <= 1
	 */
	public Vec2f getPoint(double t)
	{
		return new Vec2f((float)splineX.getValue(t), (float)splineY.getValue(t));
	}

	/**
	 * Used to check the correctness of this spline
	 */
	public boolean checkValues()
	{
		return (splineX.checkValues() && splineY.checkValues());
	}

	public double getDx(double t)
	{
		return splineX.getDx(t);
	}

	public double getDy(double t)
	{
		return splineY.getDx(t);
	}

	public Spline getSplineX()
	{
		return splineX;
	}

	public Spline getSplineY()
	{
		return splineY;
	}

	public double getLength()
	{
		return length;
	}
}
