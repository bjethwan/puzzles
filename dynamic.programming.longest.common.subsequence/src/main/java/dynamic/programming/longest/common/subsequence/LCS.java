package dynamic.programming.longest.common.subsequence;

public class LCS {

	public static void main(String[] args) {
		System.out.println(lcs("ABCDGH", "AEDFHR"));
		System.out.println(lcs("AGGTAB", "GXTXAYB"));
	}

	public static int lcs(String st1, String st2)
	{		
		int st1Len = st1.length();
		int st2Len = st2.length();

		if(st1Len==0 || st2Len==0)
			return 0;
		
		if(st1.charAt(st1Len-1) == st2.charAt(st2Len-1)){
			return 1 + lcs(st1.substring(0, st1Len-1), st2.substring(0, st2Len-1));
		}else{
			return Math.max(
					lcs(st1.substring(0, st1Len-1), st2.substring(0, st2Len)),
					lcs(st1.substring(0, st1Len), st2.substring(0, st2Len-1)));
		}
	}

}
