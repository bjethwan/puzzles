package sorting;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		
		Integer[] a = {12, 12, 23, 18, 16, 12, 11, 10, 98, 84, 77, 12, 12, 12, 12, 12, 12, 12, 68, 57, 54, 48, 33, 10, 10, 10, 29};
		
		Integer[] b = Arrays.copyOf(a, a.length);
		
		Integer[] c = Arrays.copyOf(a, a.length);
		
		Integer[] d = Arrays.copyOf(a, a.length);
		
		//MergeSort.mergesort(a);
		QuickSort.sort(a);
		System.out.println(Arrays.asList(a));
		
		Quick3way.sort(b);
		System.out.println(Arrays.asList(b));
		
		Arrays.sort(c);
		System.out.println(Arrays.asList(c));
		
		System.out.println(QuickSelect.select(d, 4)); //11
		System.out.println(Arrays.asList(d));
		
		assert Arrays.equals(a, b);
		assert Arrays.equals(a, c);

	}

}
