package binary.search;

import java.util.Arrays;

import algs4.cs.princeton.edu.In;
import algs4.cs.princeton.edu.StdIn;
import algs4.cs.princeton.edu.StdOut;

/**
 * Reads in a sequence of integers from the whitelist file, specified as
 * a command-line argument; reads in integers from standard input;
 * prints to standard output those integers that do <em>not</em> appear in the file.
 */
public class Main {
	public static void main(String[] args) {

		// read the integers from a file
		In in = new In(args[0]);
		int[] whitelist = in.readAllInts();
		

		// sort the array
		Arrays.sort(whitelist);
		
		int[] whitelistRotated = Arrays.copyOfRange(whitelist, 0, whitelist.length);
		rotate(whitelistRotated, 9);

		System.out.println("Count: "+whitelist.length);
		System.out.println("Array: "+Arrays.toString(whitelist));
		System.out.println("Rotated Array: "+Arrays.toString(whitelistRotated));

		// read integer key from standard input; print if not in whitelist
		while (!StdIn.isEmpty()) {
			int key = StdIn.readInt();
			System.out.println("key: "+key);

			System.out.println("MY Algo firstIndexOf: " + BinarySearches.firstIndexOf(whitelist, key));
			System.out.println("MY Algo lastIndexOf: " + BinarySearches.lastIndexOf(whitelist, key));

			System.out.println("JDK Algo Insertion point: " + Arrays.binarySearch(whitelist, key));
			int index = BinarySearches.indexOf(whitelist, key);
			if ( index == -1)
				StdOut.println("MY Algo Not found: "+ key);
			else
				StdOut.println("MY Algo Found "+key+" at: "+ index);
			
			System.out.println("MY Roated Algo Found "+key+" at: " + BinarySearches.indexOfInRotated(whitelistRotated, key));
		}
	}
	
	public static void rotate(int[] arr, int order) 
	{
		order = order % arr.length;
	 
		if (arr == null || order < 0) {
			throw new IllegalArgumentException("Illegal argument!");
		}
	 
		//length of first part
		int a = arr.length - order; 
	 
		reverse(arr, 0, a-1);
		reverse(arr, a, arr.length-1);
		reverse(arr, 0, arr.length-1);
	 
	}
	 
	public static void reverse(int[] arr, int left, int right){
		if(arr == null || arr.length == 1) 
			return;
	 
		while(left < right){
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}	
	}
}
