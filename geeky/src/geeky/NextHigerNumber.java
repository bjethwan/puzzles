package geeky;

import java.util.Arrays;

public class NextHigerNumber {
	public static void main(String[] args) {
		//System.out.println(getNextHigherNumber(12543));
		System.out.println(getNextHigherNumber(125432));		
	}
	
	public static int getNextHigherNumber(int num){
		
		StringBuilder strNum = new StringBuilder(Integer.toString(num));

		for(int i = strNum.length()-2; i >= 0; i--){
			if(strNum.charAt(i) < strNum.charAt(i+1)){
				System.out.println(i);
				StringBuilder resultNumStr = swapAndSort(strNum, i+1, strNum.charAt(i));
				return Integer.valueOf(resultNumStr.toString());
			}
		}
		
		return -1;
	}
	
	private static StringBuilder swapAndSort(StringBuilder strNum, int s, char c){
		char[] chars = strNum.toString().toCharArray();
		System.out.println(chars);
		char[] baseChars = Arrays.copyOfRange(chars, 0, s);
		System.out.println(baseChars);
		char[] subChars = Arrays.copyOfRange(chars, s, strNum.length());
		System.out.println(subChars);
		Arrays.sort(subChars);
		System.out.println(subChars);
		int idx = Math.abs(Arrays.binarySearch(subChars, c))-1 + s;
		System.out.println(idx);
		StringBuilder sb = new StringBuilder();
		sb.append(baseChars);
		sb.append(subChars);
		if(idx<strNum.length()){
			swap(sb, s-1, idx);
		}
		return sb;
	}
	
	private static void  swap(StringBuilder strNum, int s, int f){
		char cs = strNum.charAt(s); //2
		char cf = strNum.charAt(f); //3
		
		strNum.insert(s, cf);	
		strNum.deleteCharAt(s+1);
		
		strNum.insert(f, cs);
		strNum.deleteCharAt(f+1);
	}
}
