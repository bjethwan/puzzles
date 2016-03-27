package binary.search;

/**
 * The static method rank() takes an integer key and a sorted array of int values as arguments 
 * and returns the index of the key if it is present in the array, -1 otherwise. 
 */
public class BinarySearches {

	public static int indexOf(int[] a, int key){
		int lo = 0;
		int hi = a.length-1;

		while(lo <= hi){
			int mid = lo + (hi - lo)/2;
			
			if(key < a[mid]) 
				hi = mid - 1;
			else if(key > a[mid])
				lo = mid + 1;
			else
				return mid;
		}
		return -1;
	}

	public static int firstIndexOf(int[] a, int key)
	{
		int lo = 0;
		int hi = a.length - 1;
		int result = -1;
		
		while( lo <= hi)
		{			
			int mid = lo + (hi - lo)/2;
			
			if(key < a[mid])
				hi = mid - 1;
			else if(key > a[mid])
				lo = mid + 1;
			else{
				result = mid; hi = mid - 1;
			}
		}
		return result;
	}
	
	
	public static int lastIndexOf(int[] a, int key)
	{
		int lo = 0;
		int hi = a.length - 1;
		int result = -1;
		
		while( lo <= hi)
		{			
			int mid = lo + (hi - lo)/2;
			
			if(key < a[mid])
				hi = mid - 1;
			else if(key > a[mid])
				lo = mid + 1;
			else{
				result = mid; lo = mid + 1;
			}
		}
		return result;
	}
	
	
	public static int indexOfInRotated(int[] a, int key)
	{
		int lo = 0;
		int hi = a.length - 1;
		
		while(lo <= hi)
		{
			int mid = lo + (hi-lo)/2;
			
			if(key == a[mid])
				return mid;
			
			if(a[lo] <= a[mid]) 							// The first half is sorted
			{
				if( a[lo] <= key && key < a[mid])			
					hi = mid -1;
				else
					lo = mid + 1;
			}
			else if(a[mid] <= a[hi])						// The second half is sorted
			{
				if(a[mid] < key && key <= a[hi])
					lo = mid + 1;
				else
					hi = mid - 1;
						
			}
		}
		
		return -1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	/**
	 * Checks that {@code fromIndex} and {@code toIndex} are in
	 * the range and throws an exception if they aren't.
	 */
	private static void rangeCheck(int arrayLength, int fromIndex, int toIndex) {
		if (fromIndex > toIndex) {
			throw new IllegalArgumentException(
					"fromIndex(" + fromIndex + ") > toIndex(" + toIndex + ")");
		}
		if (fromIndex < 0) {
			throw new ArrayIndexOutOfBoundsException(fromIndex);
		}
		if (toIndex > arrayLength) {
			throw new ArrayIndexOutOfBoundsException(toIndex);
		}
	}

	
	

}

