package sorting;

import algs4.cs.princeton.edu.StdRandom;
@SuppressWarnings("rawtypes")
public class QuickSort {

	// This class should not be instantiated.
	private QuickSort(){}


	public static void sort(Comparable[] a)
	{
		StdRandom.shuffle(a);
		sort(a, 0, a.length-1);
	}

	private static void sort(Comparable[] a, int lo, int hi)
	{
		if( hi <= lo) return;
		
		int j = partition(a, lo, hi);
		sort(a, lo, j-1);
		sort(a, j+1, hi);
	}

	
	private static int partition(Comparable[] a, int lo, int hi)
	{
		int i = lo, j = hi + 1;
		
		Comparable v = a[lo];
		
		while(true)
		{
			while(less(a[++i], v))
				if(i == hi) break;

			while(less(v, a[--j]))
				if(j == lo) break;

			if(i>=j) break;
			
			exch(a, i, j);
		}
		
        exch(a, lo, j);

        return j;						
	}

	private static void exch(Object[] a, int i, int j)
	{
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
	
	private static boolean less(Comparable v, Comparable w) 
	{	
		return v.compareTo(w) < 0;
	}

	private static boolean isSorted(Comparable[] a) 
	{

		return isSorted(a, 0, a.length-1);
	}

	private static boolean isSorted(Comparable[] a, int lo, int hi) 
	{
		for(int i = lo + 1; i <= hi; i++)
			if(less(a[i], a[i-1])) return false;

		return true;
	}
}
