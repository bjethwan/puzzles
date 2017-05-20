
public class Main {
	public static void main(String[] args) {

		testTrimBST();
		
		
	}
	
	public static void testTrimBST(){
		BST<Integer> bst = new BST<Integer>(8, 3, 1, 6, 4, 7, 10, 14, 13);
		System.out.println("Before");
		bst.print();
		System.out.println("\nAfter");
		bst.trimBST(10, 13);
		//bst.trimBST(5, 13);
		bst.print();
	}
	
	
	
	
	
	public static void test1(){
		BST<Integer> bst = new BST<Integer>(11, 22, 77, 99, 10, 2, 56, 33, 89, 7);
		System.out.println("Size: "+ bst.size());
		System.out.println("Height: "+ bst.height());
		bst.print();
		System.out.println("Min: "+ bst.min());
		System.out.println("Max: "+ bst.max());
		
//		bst.mirror();
//		bst.print();
		
		bst.swap(10, 99);
		bst.print();
		
		
	}
}
