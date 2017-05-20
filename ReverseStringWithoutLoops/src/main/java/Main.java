
public class Main {
	public static void main(String[] args) {
		System.out.println(reverse("bipin"));
	}
	
	public static String reverse(String str)
	{	
		int N = str.length();
		if(N <= 1) return str;
		String a = str.substring(0, N/2);
		String b = str.substring(N/2, N);
		return reverse(b) + reverse(a);
	}
}

