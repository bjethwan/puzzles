package interpolation.search;

public class InterpolationSearch {

	public static int indexOf(int[] a, int k){
		
		int lo = 0;
		int hi = a.length-1;
		
		while(lo <= hi && k>=a[lo] && k<=a[hi]){
			int distance = k - a[lo];
			int valueRange = a[hi] - a[lo];
			float fraction = (float)distance/(float)valueRange;
			System.out.println("fraction: "+fraction);
			
			int indexRange = hi - lo;
			int indexEstimate = lo + Math.round(fraction * indexRange);
			System.out.println("indexEstimate: "+indexEstimate);
			System.out.println("value: "+a[indexEstimate]);
			
			if(k < a[indexEstimate])
				hi = indexEstimate - 1;
			else if(k > a[indexEstimate])
				lo = indexEstimate + 1;
			else{
				return indexEstimate;
			}
			System.out.println("Not found yet");
		}	
		return -1;
	}
	
	
	public static void main(String[] args) {
		int a[] = {0, 7, 12, 17, 21, 26, 31, 33, 40, 43, 49, 51, 64, 66, 72, 73, 81, 87, 96, 99};
		
		System.out.println(indexOf(a, 95));
		
	}
}
