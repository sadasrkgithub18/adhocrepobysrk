package adhocthinking;

import java.util.Arrays;
import java.util.Random;

public class AnagramCheck 
{

	    // TC:Theta(n^2) SC:O(1)
		public static boolean anagramCheck1(String s1, String s2) 
		{
			return false;
		}

		// TC:Theta(n log n) SC:O(n)
		public static boolean anagramCheck2(String s1, String s2) 
		{
			char[] tmp1 = s1.toCharArray();
			char[] tmp2 = s2.toCharArray();
			Arrays.sort(tmp1);
			Arrays.sort(tmp2);
			for (int i = 0; i < tmp1.length; ++i) 
			{
				if (tmp1[i] != tmp2[i])
				{
					return false;
				}
			}
			return true;
		}
		
		
		// TC:Theta(n) SC:O(1)
		public static boolean anagramCheck3(String s1, String s2) 
		{
			int[] counts = new int[26];
			int n = s1.length();
			
			//s1.charAt(i) returns the i'th character of the String s1. 
			//Assuming that this String contains only lower case letters (i.e. 'a' to 'z'), 
			//s1.charAt(i)-'a' maps the character 'a' to index 0, 'b' to index 1, and
			//so on ('z' is mapped to index 25).
			for(int i = 0; i < n; ++i) 
			{
				int tmp = s1.charAt(i) - 'a';
				++counts[tmp];
			}
			
			for (int i = 0; i < n; ++i) 
			{
				int tmp = s2.charAt(i) - 'a';
				if (counts[tmp] <= 0)
				{
					return false;
				}
				--counts[tmp];
			}
			
			return true;
		}

		
		private static String randomString(int n)
		{
			//Generate Random Character Using random.nextInt() in Java
			//We can use a character as a bound in the nextInt() function.
			//Random class is created and then (random.nextInt(26) + 'a') is used.
			//Here, the character 'a' corresponds to the number 97, using which 
			//we can generate 26 random integers that correspond to the lower-case alphabet.
			String res = "";
			Random r = new Random();
			for (int i = 0; i < n; ++i) 
			{
				char tmp = (char) ('a' + r.nextInt(26));
				res += tmp;
			}
			
			return res;
		}
		
	public static void main(String[] args) 
	{
		int n = Integer.parseInt(args[0]);
//		String s1 = randomString(n);
//		String s2 = randomString(n);
		
		String s1 = "abaac";
		String s2 = "acaba";
		System.out.println("Generated Random String s1 is: "+s1);
		System.out.println("Generated Random String s2 is: "+s2);
		
//		System.out.println(anagramCheck2(s1, s2));
		System.out.println(anagramCheck3(s1, s2));
	}

}
