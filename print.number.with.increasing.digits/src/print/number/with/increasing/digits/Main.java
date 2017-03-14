package print.number.with.increasing.digits;


/**
 * Advisory Board Interview.
 * 
 * Problem: Print all n-digit strictly increasing numbers
 * 
 * Description:
 * Given number of digits n in a number,
 * Print all n-digit numbers whose digits are strictly increasing from left to right.
 * 
 * 

Examples: 

Input:  n = 1
Output: 0 1 2 3 4 5 6 7 8 9


Input:  n = 2
Output:  
01 02 03 04 05 06 07 08 09 12 13 14 15 16 17 18 19 23 24 25 26 27 28 
29 34 35 36 37 38 39 45 46 47 48 49 56 57 58 59 67 68 69 78 79 89


Input:  n = 3
Output:  
012 013 014 015 016 017 018 019 023 024 025 026 027 028 029 034 
035 036 037 038 039 045 046 047 048 049 056 057 058 059 067 068 
069 078 079 089 123 124 125 126 127 128 129 134 135 136 137 138 
139 145 146 147 148 149 156 157 158 159 167 168 169 178 179 189 
234 235 236 237 238 239 245 246 247 248 249 256 257 258 259 267 
268 269 278 279 289 345 346 347 348 349 356 357 358 359 367 368 
369 378 379 389 456 457 458 459 467 468 469 478 479 489 567 568 
569 578 579 589 678 679 689 789

 */

public class Main {

	private static int count=1;

	public static void main(String[] args) 
	{
		findStrictlyIncreasingNum(1, 0, "");
		findStrictlyIncreasingNum(2, 0, "");
		findStrictlyIncreasingNum(3, 0, "");
	}

	public static void findStrictlyIncreasingNum(int n, int s, String in)
	{

		if(n <= 0){
			System.out.println((count++) + ": " + in);
			return;
		}

		int maxPlaceValueDigit = 10 -n + 1;

		for(int i = s; i < maxPlaceValueDigit; i++)
		{
			String out = in + Integer.toString(i);
			
			findStrictlyIncreasingNum(n-1, i+1, out);
		}

	}
}












