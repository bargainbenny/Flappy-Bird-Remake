package com.bargainbenny.flappybird.math;

public class Matrix4f {
	
	public final static int SIZE = 4*4;
	public float[] elements = new float[SIZE];
	
	public Matrix4f()
	{
		
	}
	
	public static Matrix4f identity()
	{
		Matrix4f result = new Matrix4f();
		for(int i = 0; i < SIZE; i++)
		{
			result.elements[i] = 0.0f;
		}
		
		result.elements[0 + 0 * 4] = 1.0f;
		result.elements[1 + 1 * 4] = 1.0f;
		result.elements[2 + 2 * 4] = 1.0f;
		result.elements[3 + 3 * 4] = 1.0f;
		
		return result;
	}
	
}
