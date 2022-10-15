package Combinatorics;

public class Cheat
{
	// Iterative function to calculate factorial of a number
	public static long factorial(int n)
	{
		long fact = 1;
		for (int i = 1; i <= n; i++) {
			fact = fact * i;
		}
		return fact;
	}

	// Function to find the lexicographic rank of a string
	public static long findLexicographicRank(String str)
	{
		// base case
		if (str == null) {
			return 0;
		}

		// rank starts from 1
		long rank = 1;

		for (int i = 0; i < str.length() - 1; i++)
		{
			// count all smaller characters than `str[i]` to the right of `i`
			int count = 0;
			for (int j = i + 1; j < str.length(); j++)
			{
				if (str.charAt(i) > str.charAt(j)) {
					count++;
				}
			}

			// add the current count to the rank
			rank += count * factorial(str.length() - 1 - i);
		}

		return rank;
	}

	public static void main(String[] args)
	{
		String str = "VIEW";

		System.out.println("The lexicographic rank of " + str + " is "
				+ findLexicographicRank(str));
	}
}