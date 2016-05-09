package geeky;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseString {
	public static void main(String[] args) {

		String a = "Bipin Jethwani";
		System.out.println(a);
		a = reverse(a, 0, a.length()-1);
		System.out.println(a);

	}

	private static String reverse(String input, int lo, int hi)
	{
		char[] a = input.toCharArray();

		while(lo<hi)
		{
			System.out.println("lo = "+lo +"\t"+ "hi ="+hi);
			char swap = a[lo];
			a[lo] = a[hi];
			a[hi]=swap;
			lo++;hi--;
			System.out.println(list(a));
		}

		return String.valueOf(a);
	}
	
	private static List<Character> list(char[] a)
	{
		List<Character> listC = new ArrayList<Character>();
	    for (char c : a) {
	        listC.add(c);
	    }
	    return listC;
	}
}
