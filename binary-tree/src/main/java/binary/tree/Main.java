package binary.tree;

public class Main {
	public static void main(String[] args) {
		testFindMaxSum();
	}
	
	public static void testFindMaxSum(){
		BinaryTree binaryTree = new BinaryTree();
		
		binaryTree.buildTree1ForfindMaxSum();
		System.out.println("binaryTree.buildTree1ForfindMaxSum(): " + binaryTree.findMaxSum());
		
		binaryTree.buildTree2ForfindMaxSum();
		System.out.println("binaryTree.buildTree2ForfindMaxSum(): " + binaryTree.findMaxSum());
	}
	
	public static void testHasPathSum(){
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.buildHasPathSumTree();
		System.out.println(binaryTree.hasPathSum(17));
		System.out.println(binaryTree.hasPathSum(4));
		System.out.println(binaryTree.hasPathSum(16));
		System.out.println(binaryTree.hasPathSum(19));
		System.out.println(binaryTree.hasPathSum(10));
	}
}
