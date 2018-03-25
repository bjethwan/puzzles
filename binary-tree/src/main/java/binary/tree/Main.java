package binary.tree;

public class Main {
	public static void main(String[] args) {

		testLCA();
		testFindPath();
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
	
	public static void testFindPath(){
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.buildTreeForFindPathInBinaryTree();
		
		System.out.println(binaryTree.findPath(90));
		System.out.println(binaryTree.findPath(7));
		System.out.println(binaryTree.findPath(5));
		System.out.println(binaryTree.findPath(9));
	}
	
	public static void testLCA(){
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.buildTreeForFindPathInBinaryTree();
		
		System.out.println(binaryTree.lca(4, 9)); //2
		System.out.println(binaryTree.lca(5, 6)); //1
		System.out.println(binaryTree.lca(4, 5)); //2
		System.out.println(binaryTree.lca(2, 4)); //2
		System.out.println(binaryTree.lca(1, 5)); //1
		System.out.println(binaryTree.lca(0, 7)); //Exception
	}
	
	public static void testTopView(){
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.buildTree2ForPrintTopView();
		binaryTree.printTopView();
		binaryTree.buildTreeForFindPath();
		
		System.out.println(binaryTree.findPath(6));
		System.out.println(binaryTree.findPath(7));
		
		System.out.println(binaryTree.lca(6, 7));
		
		
		System.out.println(binaryTree.findPath(5));
		System.out.println(binaryTree.findPath(6));
		
		System.out.println(binaryTree.lca(6, 5));
		
		
		System.out.println(binaryTree.findPath(1));
		System.out.println(binaryTree.findPath(6));
		
		System.out.println(binaryTree.lca(6, 1));
	}
}
