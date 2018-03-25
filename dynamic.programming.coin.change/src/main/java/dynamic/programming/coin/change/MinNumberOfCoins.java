package dynamic.programming.coin.change;

import java.util.HashMap;
import java.util.Map;

public class MinNumberOfCoins {

	
	Map<Integer, Integer> cache = new HashMap<>();
	
	//int V[] = {1, 2, 3};
	int V[] = {2, 3, 5, 6};

	public int C(int P){
		if(P < 0)  return -1;
		if(P == 0) return 0;
		if(cache.containsKey(P)){
			return cache.get(P);
		}

		int min = Integer.MAX_VALUE;
		for(int v: V){
			int result = C(P - v);
			if(result>=0 && result<min){
				min = result;
			}
		}
		System.out.printf("C(%d) = %d\n", P, min+1 );
		cache.put(P, min+1);
		return min+1;
	}




	public static void main(String[] args) {
		//System.out.println(new MinNumberOfCoins().C(5));
		System.out.println(new MinNumberOfCoins().C(10));
	}

}
