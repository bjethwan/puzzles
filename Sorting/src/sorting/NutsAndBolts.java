package sorting;

import java.util.Arrays;

class Nut{
	public char t;
	public Nut(char c){this.t = c;}
	public String toString(){return ""+t;}
}

class Bolt{
	public char t;
	public Bolt(char c){ this.t = c;}
	public String toString(){return ""+t;}
}

public class NutsAndBolts {

	
	public static void match(Nut[] nuts, Bolt[] bolts, int lo, int hi)
	{
		if(hi <= lo) return;
		
		int j = partition(nuts,  lo, hi, bolts[lo]);
		int k = partition(bolts, lo, hi, nuts[j] );
		
		assert j == k;
		
		match(nuts, bolts, lo, j-1);
		match(nuts, bolts, j+1, hi);
	}
	
	
	private static int partition(Nut[] nuts, int lo, int hi, Bolt bolt) 
	{
		int k = lo, p = lo;
		while(k < hi)
		{
			if		(nuts[k].t <  bolt.t)	exch(nuts, k++, p++);			// 2 conditions - both moving concurrently at start or p left behind pointing to a high right next to a low
			else if	(nuts[k].t == bolt.t)	exch(nuts, k, hi);				// park it at hi index	
			else								k++				 ;				// p (pivot) would be struck but k would keep moving
		}
		exch(nuts, hi, p);
		return p;
	}
	
	private static int partition(Bolt[] bolts, int lo, int hi, Nut nut) 
	{
		int i = lo;
		for(int k = lo; k < hi; k++)
		{
			if		(bolts[k].t <  nut.t)	{exch(bolts, k, i); i++;}				//if small ones are at the start both pointer would keep moving.
			else if	(bolts[k].t == nut.t)	{exch(bolts, k, hi); k--;}			//park it at hi index	
			else												 ;				//i would be struck but k would keep moving
		}
		exch(bolts, hi, i);
		return i;
	}
	
	private static void exch(Object[] a, int i, int j)
	{
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}





	public static void main(String[] args) {

		
		Nut[] nuts = 	{new Nut('!'),  new Nut('@'),  new Nut('#'),  new Nut('$'),  new Nut('%'),  new Nut('+'),  new Nut('-'),  new Nut('^')};
		Bolt[] bolts =  {new Bolt('^'), new Bolt('$'), new Bolt('!'), new Bolt('-'), new Bolt('%'), new Bolt('@'), new Bolt('+'), new Bolt('#')};
		
		System.out.println("At start");
		System.out.println("Nuts : "+ (Arrays.asList(nuts)));
		System.out.println("Bolts: "+ (Arrays.asList(bolts)));
		System.out.println();
		
		match(nuts, bolts, 0, nuts.length-1);
		
		System.out.println("At end");
		System.out.println("Nuts : "+ (Arrays.asList(nuts)));
		System.out.println("Bolts: "+ (Arrays.asList(bolts)));
		System.out.println();
	}
}
