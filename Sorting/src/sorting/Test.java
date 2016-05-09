package sorting;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		
		Integer[] a = {23, 18, 16, 12, 11, 10, 98, 84, 77, 68, 57, 54, 48, 33, 29};
		
		Integer[] b = Arrays.copyOf(a, a.length);
		
		//MergeSort.mergesort(a);
		QuickSort.sort(a);
		System.out.println(Arrays.asList(a));
		
		Arrays.sort(b);
		System.out.println(Arrays.asList(b));
		
		assert Arrays.equals(a, b);

	}
}
