import com.bjethwan.LRUCache;

public class Main {
	public static void main(String[] args) {

		LRUCache<Integer, Integer> cache = new LRUCache<>(2);
		
		cache.set(1, 1);														// {1}
		cache.set(2, 2);														// {2, 1}
		System.out.println(cache.get(1));		// Prints 1					// {1, 2}
		cache.set(3, 3);    						// evicts key 2				// {3, 1}
		System.out.println(cache.get(2));       	// Prints null (not found)	// {3, 1}
		cache.set(4, 4);    						// evicts key 1				// {3, 4}
		System.out.println(cache.get(1));       	// Prints null (not found)	// {3, 4}
		System.out.println(cache.get(3));       	// Prints 3					// {3, 4}
		System.out.println(cache.get(4));      	// Prints 4					// {4, 3}
	
	}
}
