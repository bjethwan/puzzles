package geeky;

import java.util.Arrays;

/*
 * Q. Write a method to randomly generate a set of m integers from an array of size n.
 *    Each element must have equal probability of being chosen. 
 *    
 *    Our first instinct on this problem might be to randomly pick elements from the array
 *    and put them into our new subset array. But then, what if we pick the same element twice?
 *    
 *    Either we would have to mark the entries already taken and then keep generating the 
 *    random numbers till we get to a un-picked entry.
 *    
 *    Or we'd want to somehow "shrink" the array to no longer contain that element. 
 *    Shrinking is expensive though because of all the shifting required.
 *    
 *    In below trick we would rather mark to entries dead at the front of the array.
 */
public class RandomSubArray {

	/** Random # between lo and hi, inclusive. */
	public static int rand(int lo, int hi)
	{
		return lo + (int) (Math.random() * (hi - lo + 1));
	}
	
	public static int[] pickMRandomly(int[] original, int m)
	{
		int[] subset = new int[m];
		int[] array = original.clone();
		
		for(int i = 0; i < m; i++)
		{
			int index = rand(i, array.length-1);
			subset[i] = array[index];
			array[index] = array[i]; // array[i] is dead now.
		}

		return subset;
	}
	
	public static void main(String[] args) {
		int m = 5;
		int input[] = {1,2,3,4,5,6,7,8,9};
		int subset[] = pickMRandomly(input, 5);
		
		for(int i=0;i<m;i++)
			System.out.print(subset[i] +", ");
		
				
	}
}

