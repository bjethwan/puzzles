package geeky;

import java.util.Arrays;

public class StringMask 
{

	/**
	 * Remove characters from the first string which are present in the second string
	 * @param maskStr
	 * @param inputStr
	 * @return
	 */
	public static String maskString(String maskStr, String inputStr){

		int ipIndex,opIndex;

		char[] mask = maskStr.toCharArray();

		boolean[] maskArr = new boolean[256];

		for(int i = 0; i < mask.length; i++){
			maskArr[mask[i]]=true;
		}


		char[] input = inputStr.toCharArray();

		for(opIndex=0, ipIndex=0; ipIndex<input.length;ipIndex++){
			if(!maskArr[input[ipIndex]]){
				input[opIndex++]=input[ipIndex];
			}
		}

		return new String(Arrays.copyOfRange(input, 0, opIndex));
	}

	
	public static void main(String[] args) {
		System.out.println(maskString("mask","geeksforgeek")); //Output geeforgee
	}
}
