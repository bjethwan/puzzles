package print.interleaving.of.two.strings;

public class Main {

	private static int count = 1;

	public static void main(String[] args) {

	}

	public static void interleave(String str1, int start1, String str2, int start2, String result)
	{
		if(result.length() >= str1.length() + str2.length()){
			System.out.println((count++) + ": " + result);
			return;
		}

		if(start1 < str1.length()){

		}

		if(start2 < str2.length()){
			
		}

	}


}
