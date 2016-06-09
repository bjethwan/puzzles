package sorting;

@SuppressWarnings("rawtypes")
public class MergeSort {

	
	public static void mergesort(Comparable[] a) 
	{
		Comparable[] aux = new Comparable[a.length];
		
		sort(a, aux, 0, a.length-1);
	}
	
	private static void sort(
			Comparable[] a, 
			Comparable[] aux, 
			int lo, int hi)
	{
		if( hi <= lo)
			return;
		
		int mid = lo + (hi - lo)/2;
		
		sort(a, aux, lo, mid);
		sort(a, aux, mid+1, hi);
		merge(a, aux, lo, mid, hi);
	}

	private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) 
	{
		for (int k = lo; k <= hi; k++)
			aux[k] = a[k];
		
		int i = lo, j = mid+1;
		
		for (int k = lo; k <= hi; k++)
		{
			if		( i > mid )				a[k] = aux[j++];
			else if	( j > hi  )				a[k] = aux[i++];
			else if	( less(aux[j], aux[i]))	a[k] = aux[j++];
			else								a[k] = aux[i++];
		}
	}

	
	private static boolean less(Comparable v, Comparable w) 
	{	
		return v.compareTo(w) < 0;
	}

	private static boolean isSorted(Comparable[] a, int lo, int hi) 
	{
		for(int i = lo + 1; i <= hi; i++)
			if(less(a[i], a[i-1])) return false;
		
		return true;
	}

}
