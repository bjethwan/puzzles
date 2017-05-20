package search.with.unknown.end;

/*
 * 
 * Search Unknown Length Array
 * 
 * Given a sorted array of unknown length and a number to search for, return the index of the number in the array. 
 * Accessing an element out of bounds throws exception. 
 * If the number occurs multiple times, return the index of any occurrence. 
 * If it isn’t present, return -1.
 * 
 * Standard binary search wouldn’t work because we don’t know the size of the array to provide an upper limit index. 
 * So, we perform one-sided binary search for both the size of the array and the element itself simultaneously. 
 * Let’s say we’re searching for the value k.
 * We check array indexes 0, 1, 2, 4, 8, 16, …, 2^N 
 * in a loop until either we get an exception or we see an element larger than k.
 * 
 * If at index 2^m we see an element larger than k, 
 * it means the value k (if it exists) must be between indexes 2^(m-1)+1 and 2^m-1 (inclusive), 
 * since the array is sorted. The same is true even if we get an exception.
 *  
 */
public class Main {

	public static int indexOf(int a[], int key){

		// Search over indexes 0, 2^0, 2^1, 2^2, ...
		int index = 0, exponent=0;
		while(true){
			try{
				if( key == a[index] )
					return index;
				else if( key > a[index] ) 
					index = (int)Math.pow(2, exponent++);
				else
					break;
			} catch (ArrayIndexOutOfBoundsException e) {
				break;
			}
		}

		// Binary Search
		int lo = index/2 + 1, hi = index - 1, mid = 0;
		while(lo <= hi){
			try{
				mid = lo + (hi-lo)/2;
				if( key > a[mid])
					lo = mid + 1;
				else if(key < a[mid])
					hi = mid - 1;
				else
					return mid;
			}catch(ArrayIndexOutOfBoundsException e){
				hi = mid - 1;
			}
		}
		return -1;
	}


	public static void main(String[] args) {
		//			 0	1  2  3	 4	5  6  7	  8   9   10  11  12  13  14   15   16	
		int[] a = 	{1, 2, 3, 4, 5, 6, 7, 32, 43, 56, 64, 71, 80, 97, 101, 117, 121};

		System.out.println(indexOf(a, 71)); 	// 11
		System.out.println(indexOf(a, 81)); 	// -1
		System.out.println(indexOf(a, 117));	// 15
		System.out.println(indexOf(a, 0));		// -1
		System.out.println(indexOf(a, 2017));   // -1
	}
}
