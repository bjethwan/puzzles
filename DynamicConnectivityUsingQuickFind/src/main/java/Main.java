import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.bjethwan.UF;

public class Main {
	
	
	
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner input = new Scanner(new File("tinyUF.txt"));
		
		int N = input.nextInt();
		System.out.println("N = "+N);
		
		UF uf = new UF(N);
		
		while(input.hasNextLine()){
			int p = input.nextInt();
			int q = input.nextInt();
			if(!uf.connected(p, q)){
				uf.union(p, q);
				System.out.println(p +" "+ q + "(connecting...)");
			}else{
				System.out.println(p +" "+ q + "(Already Connected!!!)");
			}
			
		}
		
	}
}
