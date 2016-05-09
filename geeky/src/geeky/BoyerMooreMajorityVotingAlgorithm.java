package geeky;

public class BoyerMooreMajorityVotingAlgorithm {

	public static int findMajorityElement(int[] a)
	{
		int counter = 0;
		int candidate = a[0];

		for(int i=0;i<a.length;i++){
			if (counter == 0){
				candidate = a[i];
				counter = 1;
			}else if(a[i] == candidate)	{ counter++; }
			 else						{ counter--; }
		}
		
		counter = 0;
		for(int i = 0; i < a.length; i++){
			if(a[i] == candidate) 
				counter++;
		}
		
		if(counter > a.length/2) 
			return candidate;
		
		return -1;
	}
	
	
	public static void main(String[] args) {
		int[] input = {'A','A','A','C','C','B','B','C','C','C','B','C','C'};
		
		System.out.println((char)findMajorityElement(input));
		System.out.println(findMajorityElement(new int[]{1, 2, 3}));
		System.out.println(findMajorityElement(new int[]{2, 2, 3}));
	}

}
