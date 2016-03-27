
public class Main {
	public static void main(String[] args) {

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
