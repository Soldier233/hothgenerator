package biz.orgin.minecraft.hothgenerator.schematic;

import biz.orgin.minecraft.hothgenerator.HothUtils;

public class MiniDome implements Schematic
{
	public static Schematic instance = new MiniDome();
	private static int WIDTH = 17;
	private static int LENGTH = 17;
	private static int HEIGHT = 9;
	private static String name = "MiniDome";
	
	private final int[][][] matrix = new int[][][]
	{
			{  // Floor 0
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{-1,-1,-1,-1,-1,-1,-1,44,44,44,-1,-1,-1,-1,-1,-1,-1,  0,0,0,0,0,0,0,5,5,5,0,0,0,0,0,0,0},
				{-1,-1,-1,-1,-1,-1,44,98,109,98,44,-1,-1,-1,-1,-1,-1, 0,0,0,0,0,0,5,0,3,0,5,0,0,0,0,0,0},
				{-1,-1,-1,-1,-1,-1,44,109,0,109,44,-1,-1,-1,-1,-1,-1, 0,0,0,0,0,0,5,1,0,0,5,0,0,0,0,0,0},
				{-1,-1,-1,-1,-1,-1,44,98,109,98,44,-1,-1,-1,-1,-1,-1, 0,0,0,0,0,0,5,0,2,0,5,0,0,0,0,0,0},
				{-1,-1,-1,-1,-1,-1,-1,44,44,44,-1,-1,-1,-1,-1,-1,-1,  0,0,0,0,0,0,0,5,5,5,0,0,0,0,0,0,0},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
			},
			{  // Floor 1
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{-1,-1,-1,-1,-1,-1,-1,44,44,44,-1,-1,-1,-1,-1,-1,-1,  0,0,0,0,0,0,0,5,5,5,0,0,0,0,0,0,0},
				{-1,-1,-1,-1,-1,44,98,98,98,98,98,44,-1,-1,-1,-1,-1,  0,0,0,0,0,5,0,0,0,0,0,5,0,0,0,0,0},
				{-1,-1,-1,-1,-1,98,98,98,98,98,98,98,-1,-1,-1,-1,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{-1,-1,-1,-1,44,98,98,89,98,89,98,98,44,-1,-1,-1,-1,  0,0,0,0,5,0,0,0,3,0,0,0,5,0,0,0,0},
				{-1,-1,-1,-1,44,98,98,98, 0,98,98,98,44,-1,-1,-1,-1,  0,0,0,0,5,0,0,3,0,3,0,0,5,0,0,0,0},
				{-1,-1,-1,-1,44,98,98,89,98,89,98,98,44,-1,-1,-1,-1,  0,0,0,0,5,0,0,0,3,0,0,0,5,0,0,0,0},
				{-1,-1,-1,-1,-1,98,98,98,98,98,98,98,-1,-1,-1,-1,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{-1,-1,-1,-1,-1,44,98,98,98,98,98,44,-1,-1,-1,-1,-1,  0,0,0,0,0,5,0,0,0,0,0,5,0,0,0,0,0},
				{-1,-1,-1,-1,-1,-1,-1,44,44,44,-1,-1,-1,-1,-1,-1,-1,  0,0,0,0,0,0,0,5,5,5,0,0,0,0,0,0,0},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
			},
			{  // Floor 2
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{-1,-1,-1,-1,-1,-1,-1,44,44,44,-1,-1,-1,-1,-1,-1,-1,  0,0,0,0,0,0,0,5,5,5,0,0,0,0,0,0,0},
				{-1,-1,-1,-1,-1,44,44,98,98,98,44,44,-1,-1,-1,-1,-1,  0,0,0,0,0,5,5,0,0,0,5,5,0,0,0,0,0},
				{-1,-1,-1,-1,44,98,98, 0, 0, 0,98,98,44,-1,-1,-1,-1,  0,0,0,0,5,0,0,0,0,0,0,0,5,0,0,0,0},
				{-1,-1,-1,44,98, 0, 0, 0, 0, 0, 0, 0,98,44,-1,-1,-1,  0,0,0,5,0,0,0,0,0,0,0,0,0,5,0,0,0},
				{-1,-1,-1,44,98, 0, 0, 0, 0, 0, 0, 0,98,44,-1,-1,-1,  0,0,0,5,0,0,0,0,0,0,0,0,0,5,0,0,0},
				{-1,-1,44,98, 0, 0, 0, 0, 0, 0, 0, 0, 0,98,44,-1,-1,  0,0,5,0,0,0,0,0,0,0,0,0,0,0,5,0,0},
				{-1,-1,44,98, 0, 0, 0, 0, 0, 0, 0, 0, 0,98,44,-1,-1,  0,0,5,0,0,0,0,0,0,0,0,0,0,0,5,0,0},
				{-1,-1,44,98, 0, 0, 0, 0, 0, 0, 0, 0, 0,98,44,-1,-1,  0,0,5,0,0,0,0,0,0,0,0,0,0,0,5,0,0},
				{-1,-1,-1,44,98, 0, 0, 0, 0, 0, 0, 0,98,44,-1,-1,-1,  0,0,0,5,0,0,0,0,0,0,0,0,0,5,0,0,0},
				{-1,-1,-1,44,98, 0, 0, 0, 0, 0, 0, 0,98,44,-1,-1,-1,  0,0,0,5,0,0,0,0,0,0,0,0,0,5,0,0,0},
				{-1,-1,-1,-1,44,98,98, 0, 0, 0,98,98,44,-1,-1,-1,-1,  0,0,0,0,5,0,0,0,0,0,0,0,5,0,0,0,0},
				{-1,-1,-1,-1,-1,44,44,98,98,98,44,44,-1,-1,-1,-1,-1,  0,0,0,0,0,5,5,0,0,0,5,5,0,0,0,0,0},
				{-1,-1,-1,-1,-1,-1,-1,44,44,44,-1,-1,-1,-1,-1,-1,-1,  0,0,0,0,0,0,0,5,5,5,0,0,0,0,0,0,0},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
			},
			{  // Floor 3
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{-1,-1,-1,-1,-1,-1,44,98,98,98,44,-1,-1,-1,-1,-1,-1,  0,0,0,0,0,0,5,0,0,0,5,0,0,0,0,0,0},
				{-1,-1,-1,-1,44,98,98, 0, 0, 0,98,98,44,-1,-1,-1,-1,  0,0,0,0,5,0,0,0,0,0,0,0,5,0,0,0,0},
				{-1,-1,-1,44,98, 0, 0,98,98,98, 0, 0,98,44,-1,-1,-1,  0,0,0,5,0,0,0,3,3,3,0,0,0,5,0,0,0},
				{-1,-1,44,98, 0,98,98, 0, 0, 0,98,98, 0,98,44,-1,-1,  0,0,5,0,0,3,3,0,0,0,3,3,0,0,5,0,0},
				{-1,-1,98, 0,98, 0, 0, 0, 0, 0, 0, 0,98, 0,98,-1,-1,  0,0,0,0,3,0,0,0,0,0,0,0,3,0,0,0,0},
				{-1,44,98, 0,98, 0, 0, 0, 0, 0, 0, 0,98, 0,98,44,-1,  0,5,0,0,3,0,0,0,0,0,0,0,3,0,0,5,0},
				{-1,98, 0,98, 0, 0, 0, 0, 0, 0, 0, 0, 0,98, 0,98,-1,  0,0,0,3,0,0,0,0,0,0,0,0,0,3,0,0,0},
				{-1,98, 0,98, 0, 0, 0, 0, 0, 0, 0, 0, 0,98, 0,98,-1,  0,0,0,3,0,0,0,0,0,0,0,0,0,3,0,0,0},
				{-1,98, 0,98, 0, 0, 0, 0, 0, 0, 0, 0, 0,98, 0,98,-1,  0,0,0,3,0,0,0,0,0,0,0,0,0,3,0,0,0},
				{-1,44,98, 0,98, 0, 0, 0, 0, 0, 0, 0,98, 0,98,44,-1,  0,5,0,0,3,0,0,0,0,0,0,0,3,0,0,5,0},
				{-1,-1,98, 0,98, 0, 0, 0, 0, 0, 0, 0,98, 0,98,-1,-1,  0,0,0,0,3,0,0,0,0,0,0,0,3,0,0,0,0},
				{-1,-1,44,98, 0,98,98, 0, 0, 0,98,98, 0,98,44,-1,-1,  0,0,5,0,0,3,3,0,0,0,3,3,0,0,5,0,0},
				{-1,-1,-1,44,98, 0, 0,98,98,98, 0, 0,98,44,-1,-1,-1,  0,0,0,5,0,0,0,3,3,3,0,0,0,5,0,0,0},
				{-1,-1,-1,-1,44,98,98, 0, 0, 0,98,98,44,-1,-1,-1,-1,  0,0,0,0,5,0,0,0,0,0,0,0,5,0,0,0,0},
				{-1,-1,-1,-1,-1,-1,44,98,98,98,44,-1,-1,-1,-1,-1,-1,  0,0,0,0,0,0,5,0,0,0,5,0,0,0,0,0,0},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
			},
			{  // Floor 4
				{-1,-1,-1,-1,-1,-1,98,98,98,98,98,-1,-1,-1,-1,-1,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{-1,-1,-1,-1,98,98,98,98,98,98,98,98,98,-1,-1,-1,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{-1,-1,-1,98,98,98,98,98,98,98,98,98,98,98,-1,-1,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{-1,-1,98,98,98,98,98,98,98,98,98,98,98,98,98,-1,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{-1,98,98,98,98,98,98,98,98,98,98,98,98,98,98,98,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{-1,98,98,98,98,98,98,98,98,98,98,98,98,98,98,98,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{98,98,98,98,98,98,98,98,98,98,98,98,98,98,98,98,98,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{98,98,98,98,98,98,98, 0, 0,98,98,98,98,98,98,98,98,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{98,98,98,98,98,98,98, 0,98,98,98,98,98,98,98,98,98,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{98,98,98,98,98,98,98,109,98,98,98,98,98,98,98,98,98, 0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0},
				{98,98,98,98,98,98,98,98,98,98,98,98,98,98,98,98,98,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{-1,98,98,98,98,98,98,98,98,98,98,98,98,98,98,98,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{-1,98,98,98,98,98,98,98,98,98,98,98,98,98,98,98,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{-1,-1,98,98,98,98, 8,98,98,98,98,98,98,98,98,-1,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{-1,-1,-1,98,98,98,98,98,98,98,98,98,98,98,-1,-1,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{-1,-1,-1,-1,98,98,98,98,98,98,98,98,98,-1,-1,-1,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{-1,-1,-1,-1,-1,-1,98,98,98,98,98,-1,-1,-1,-1,-1,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
			},
			{  // Floor 5
				{-1,-1,-1,-1,-1,98,98,98,98,98,98,98,-1,-1,-1,-1,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{-1,-1,-1,98,98,98, 0, 0, 0, 0, 0,98,98,98,-1,-1,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{-1,-1,98, 0, 0,98, 0, 0, 0, 0, 0,98,44, 0,98,-1,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{-1,98, 0, 0, 0,98, 0, 0, 0, 0, 0,98, 0, 0, 0,98,-1,  0,0,0,0,0,0,0,0,0,0,0,3,0,0,0,0,0},
				{-1,98, 0, 0, 0,98, 0, 0, 0, 0, 0,98, 0, 0, 0,98,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{98,98,98,98,98,98, 0, 0, 0, 0, 0,98,98,98,98,98,98,  0,0,0,3,0,0,0,0,0,0,0,0,0,3,0,0,0},
				{98,44, 0, 0, 0,44,98,98,98,98,98, 0, 0, 0, 0, 0,98,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{98,44, 0, 0, 0,44,98, 0, 0, 0,98, 0, 0, 0, 0, 0,98,  0,0,0,0,0,0,0,0,0,0,3,0,0,0,0,0,0},
				{98,44, 0, 0, 0,44,98,109,98,98,98,0, 0, 0, 0, 0,98,  0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0},
				{98,44, 0, 0, 0,44,98,98,98,98,98, 0, 0, 0, 0, 0,98,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{98,98,98,98,98,98,98,98,98,98,98, 0, 0, 0, 0, 0,98,  0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{98,98,98,98, 0, 0, 0, 0, 0,98,98, 0, 0, 0, 0, 0,98,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{-1,98,98,98, 0, 0, 0, 0, 0,98,98,98,98,98,98,98,-1,  0,0,0,0,0,0,0,0,0,0,0,3,0,0,0,0,0},
				{-1,98,98,98, 0, 0, 0, 0, 0,98,44, 0,44,98,98,98,-1,  0,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{-1,-1,98,98, 0, 0, 0, 0, 0,98, 0, 0, 0,98,98,-1,-1,  0,0,0,0,0,0,0,0,0,3,0,0,0,0,0,0,0},
				{-1,-1,-1,98,98, 0, 0, 0, 0,98, 0, 0,98,98,-1,-1,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{-1,-1,-1,-1,-1,98,98,98,98,98,98,98,-1,-1,-1,-1,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
			},
			{  // Floor 6
				{-1,-1,-1,-1,98,98,98,98,98,98,98,98,98,-1,-1,-1,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{-1,-1,98,98,98,98, 0, 0, 0, 0, 0,98,98,98,98,-1,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{-1,98, 0, 0, 0,98,54, 0, 0, 0, 0,98,44, 0,44,98,-1,  0,0,0,0,0,0,3,0,0,0,0,0,0,0,0,0,0},
				{-1,98, 0, 0, 0,98, 0, 0, 0, 0, 0, 0, 0, 0, 0,98,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{98,98, 0, 0, 0,98,54, 0, 0, 0, 0,98, 0, 0, 0,98,98,  0,0,0,0,0,0,3,0,0,0,0,0,0,0,0,0,0},
				{98,98,98, 0,98,98, 0, 0, 0, 0, 0,98,98, 0,98,98,98,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{98,44, 0, 0, 0,44,98,98,98,98,98, 0, 0, 0, 0, 0,98,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{98,44, 0, 0, 0,44,98,109,0, 0, 0, 0, 0, 0, 0,54,98,  0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,2,0},
				{98,44, 0, 0, 0,44,98,98,98,98,98, 0, 0, 0, 0, 0,98,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{98,44, 0, 0, 0,44,98,98,98,98,98, 0, 0, 0, 0, 0,98,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{98,98, 0,98,98,98,98,98,98,98,98, 0, 0, 0, 0,54,98,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0},
				{98,98, 0,98, 0, 0, 0, 0, 0,98,98, 0, 0, 0, 0, 0,98,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{98,98, 0,98, 0, 0, 0, 0, 0,98,98, 0,98,98,98,98,98,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{-1,98, 0, 0, 0, 0, 0, 0, 0,98,44, 0,44,98,98,98,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{-1,98,98,98, 0, 0, 0, 0, 0, 0, 0, 0, 0,98,98,98,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{-1,-1,98,98, 0, 0, 0, 0, 0,98, 0, 0, 0,98,98,-1,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{-1,-1,-1,-1,98,98,98,98,98,98,98,98,98,-1,-1,-1,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
			},
			{  // Floor 7
				{-1,-1,-1,-1,98,98,98,98,98,98,98,98,98,-1,-1,-1,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{-1,-1,98,98,98,98, 0, 0, 0, 0, 0,98,98,98,98,-1,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{-1,98, 0,54, 0,98,44, 0, 0, 0, 0,98, 0, 0, 0,98,-1,  0,0,0,1,0,0,13,0,0,0,0,0,0,0,0,0,0},
				{-1,98, 0, 0, 0,98, 0, 0, 0, 0, 0, 0, 0, 0, 0,98,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{98,98, 0, 0, 0,98,44, 0, 0, 0, 0,98, 0, 0, 0,98,98,  0,0,0,0,0,0,13,0,0,0,0,0,0,0,0,0,0},
				{98,98,98, 0,98,98, 0, 0, 0, 0, 0,98,98, 0,98,98,98,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{98, 0, 0, 0, 0, 0,98,98,98,98,98, 0, 0, 0, 0, 0,98,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{98, 0, 0, 0, 0, 0,98,98,109,0, 0, 0, 0, 0, 0,109,98, 0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,4,0},
				{98, 0, 0, 0, 0, 0,98,98,98,98,98, 0, 0, 0, 0, 0,98,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{98, 0, 0, 0, 0, 0,98,98,98,98,98, 0, 0, 0, 0, 0,98,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{98,98, 0,98,98,98,98,98,98,98,98, 0, 0, 0, 0,109,98, 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,0},
				{98,98, 0,98, 0, 0, 0, 0, 0,98,98, 0, 0, 0, 0, 0,98,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{98,98, 0,98, 0, 0,109,0, 0,98,98, 0,98,98,98,98,98,  0,0,0,0,0,0,6,0,0,0,0,0,0,0,0,0,0},
				{-1,98, 0, 0, 0,109,8,109,0,98, 0, 0, 0,98,98,98,-1,  0,0,0,0,0,4,0,5,0,0,0,0,0,0,0,0,0},
				{-1,98,98,98, 0, 0,109,0, 0, 0, 0, 0, 0,98,98,98,-1,  0,0,0,0,0,0,7,0,0,0,0,0,0,0,0,0,0},
				{-1,-1,98,98, 0, 0, 0, 0, 0,98, 0, 0, 0,98,98,-1,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{-1,-1,-1,-1,98,98,98,98,98,98,98,98,98,-1,-1,-1,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
			},
			{  // Floor 7
				{-1,-1,-1,-1,98,98,98,98,98,98,98,98,98,-1,-1,-1,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{-1,-1,98,98,98,98,98,98,98,98,98,98,98,98,98,-1,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{-1,98,98,98,98,98,98,89,98,89,98,98,98,98,98,98,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{-1,98,98,89,98,98,98,98,98,98,98,98,98,89,98,98,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{98,98,98,98,98,98,98,89,98,89,98,98,98,98,98,98,98,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{98,98,98,98,98,98,98,98,98,98,98,98,98,98,98,98,98,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{98,98,98,98,98,98,98,98,98,98,98,98,98,98,98,98,98,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{98,98,89,98,98,98,98,98,98,98,98,98,89,98,89,98,98,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{98,98,98,98,89,98,98,98,98,98,98,98,98,98,98,98,98,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{98,98,98,98,98,98,98,98,98,98,98,98,98,98,98,98,98,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{98,98,98,98,98,98,98,98,98,98,98,98,89,98,89,98,98,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{98,98,98,98,98,98,98,98,98,98,98,98,98,98,98,98,98,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{98,98,98,98,98,89,98,89,98,98,98,98,98,98,98,98,98,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{-1,98,98,98,98,98,98,98,98,98,98,98,98,98,98,98,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{-1,98,98,98,98,89,98,89,98,98,98,89,98,98,98,98,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{-1,-1,98,98,98,98,98,98,98,98,98,98,98,98,98,-1,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{-1,-1,-1,-1,98,98,98,98,98,98,98,98,98,-1,-1,-1,-1,  0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
			}

		};
	
	private MiniDome()
	{
	}
	
	public int getWidth() // Inner
	{
		return MiniDome.WIDTH;
	}
	public int getLength() // Middle
	{
		return MiniDome.LENGTH;
	}
	public int getHeight() // Outer
	{
		return MiniDome.HEIGHT;
	}
	
	public int[][][] getMatrix()
	{
		return this.matrix;
	}

	@Override
	public String getName()
	{
		return MiniDome.name;
	}

	@Override
	public Schematic rotate(int direction)
	{
		return HothUtils.rotateSchematic(direction, this);
	}
}