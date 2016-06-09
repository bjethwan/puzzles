package sorting;

import algs4.cs.princeton.edu.StdRandom;
@SuppressWarnings({"rawtypes", "unchecked"})
public class QuickSelect {

	private QuickSelect(){}

	public static Comparable select( Comparable[] a, int k)
	{
		StdRandom.shuffle(a);

		int lo = 0, hi = a.length - 1;

		while(hi > lo)
		{
			int j = partition(a, lo, hi);
			
			if		(j < k)	lo = j + 1;
			else if	(j > k)	hi = j - 1;
			else				return a[k];
		}

		return a[k];
	}

	private static int partition(Comparable[] a, int lo, int hi) 
	{
		int i = lo, j = hi+1;

		Comparable v = a[lo];

		while(true)
		{
			while(less(a[++i], v))
				if(i == hi) break;

			while(less(v, a[--j]))
				if(j == lo) break;

			if(j < i) break;
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
		return (v.compareTo(w) < 0);
	}
}
