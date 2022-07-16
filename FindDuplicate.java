package adhocthinking;

import java.util.Arrays;

public class FindDuplicate 
{

	//TC:O(n^2) SC:O(1)
	public static int findDuplicate1(int[] in) 
	{
		System.out.println("Array Elements from findDuplicate1 method: " +Arrays.toString(in));
		for (int i = 0; i < in.length; ++i) 
		{
			for (int j = i + 1; j < in.length; ++j) 
			{
				if (in[i] == in[j])
				{
					System.out.print("Duplicate Element in array is: ");
					return in[i];
				}
			}
		}
		return Integer.MIN_VALUE;
	}
	
	//TC:O(n log n) SC:O(1)
	public static int findDuplicate2(int[] in) 
	{
		System.out.println("Array Elements from findDuplicate2 method: " +Arrays.toString(in));
	
		Arrays.sort(in);
		
		System.out.println("Array Elements After sorting in findDuplicate2 method: " +Arrays.toString(in));
		
		for (int i = 0; i < in.length; i++)
		{
			if (in[i] == in[i + 1])
			{
				System.out.print("Duplicate Element in array is: ");
				return in[i];
			}
		}
		return Integer.MIN_VALUE;
	}
	
	
	public static int findDuplicate3(int[] in) 
	{
//		System.out.println("Array Elements from findDuplicate3 method: " +Arrays.toString(in));
		
		boolean[] aux = new boolean[in.length];
		
//		System.out.println("Default Boolean Array Elements from findDuplicate3 method: " +Arrays.toString(aux));
		
		
		for (int i = 0; i < in.length; ++i) 
		{
			int tmp = in[i];
			if (aux[tmp] == true)
			{
//				System.out.println("==============");
//				System.out.println("Boolean Array Elements After finding duplicate: " +Arrays.toString(aux));
				System.out.print("Duplicate Element in array is: ");
				return tmp;
				
			}
			aux[tmp] = true;
		}
		
		
		return Integer.MIN_VALUE;
	}
	
	
	public static int findDuplicate4(int[] in) 
	{
//		System.out.println("Array Elements from findDuplicate4 method: " +Arrays.toString(in));
		
		for (int i = 0; i < in.length; ++i) 
		{
			int tmp = Math.abs(in[i]);
			if (in[tmp] < 0)
			{
				System.out.print("Duplicate Element in array is: ");
				return tmp;
			}
			in[tmp] *= -1;
		}
		return Integer.MIN_VALUE;
	}
	
	
	public static void testCase1(int[] in) 
	{
		int i;
		for (i = 0; i < in.length - 1; ++i)
		{
			in[i] = i + 1;
		}
		in[i] = in.length - 1;
		
//		System.out.println("Array Elements from testCase1 method: " + Arrays.toString(in));
	}

	public static void testCase2(int[] in) 
	{
		int i;
		for (i = 0; i < in.length - 1; ++i)
		{
			in[i] = in.length - 1 - i;
		}
		in[i] = in.length - 1;
		
//		System.out.println("Array Elements from testCase2 method: " + Arrays.toString(in));

	}
	
	public static void main(String[] args) 
	{
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];
		testCase1(in);
//		System.out.println(Arrays.toString(in));
		long start = System.currentTimeMillis();
		System.out.println(findDuplicate4(in));
		long end = System.currentTimeMillis();
		System.out.println("Time taken:" + (end - start) / 1000.0 + "secs");
	}

}
