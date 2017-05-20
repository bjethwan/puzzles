package binary.tree;

/*
 * http://cslibrary.stanford.edu/110/BinaryTrees.html#java
 * 
 */

public class BinaryTree { 
	// Root node pointer. Will be null for an empty tree. 
	private Node root; 

	/* 
	   --Node-- 
	   The binary tree is built using this nested node class. 
	   Each node stores one data element, and has left and right 
	   sub-tree pointer which may be null. 
	   The node is a "dumb" nested class -- we just use it for 
	   storage; it does not have any methods. 
	 */ 
	private static class Node { 
		Node left; 
		Node right; 
		int data;

		Node(int newData) { 
			left = null; 
			right = null; 
			data = newData; 
		} 
	}

	/** 
	   Creates an empty binary tree -- a null root pointer. 
	 */ 
	public BinaryTree() { 
		root = null; 
	} 


	/** 
	   Returns true if the given target is in the binary tree. 
	   Uses a recursive helper. 
	 */ 
	public boolean lookup(int data) { 
		return lookup(root, data); 
	} 

	/** 
	   Recursive lookup  -- given a node, recur 
	   down searching for the given data. 
	 */ 
	private boolean lookup(Node node, int data) {

		if (node==null)  
			return false; 

		if (data==node.data) 
			return true; 
		else if (data < node.data)  
			return lookup(node.left, data); 
		else 
			return lookup(node.right, data); 
	} 


	/** 
	   Inserts the given data into the binary tree. 
	   Uses a recursive helper. 
	 */ 
	public void insert(int data) { 
		root = insert(root, data); 
	} 


	/** 
	   Recursive insert -- given a node pointer, recur down and 
	   insert the given data into the tree. Returns the new 
	   node pointer (the standard way to communicate 
	   a changed pointer back to the caller). 
	 */ 
	private Node insert(Node node, int data) {
		
		if (node==null){ 
			node = new Node(data);
		} else { 
			if (data <= node.data) { 
				node.left = insert(node.left, data); 
			} else { 
				node.right = insert(node.right, data); 
			} 
		}
		return node;
	} 


	public int maxDepth(){
		return maxDepth(root);
	}

	public int maxDepth(Node node){
		if(node == null) 
			return 0;
		int ldepth = maxDepth(node.left);
		int rdepth = maxDepth(node.right);
		return Math.max(ldepth, rdepth) + 1;
	}


	/** 
	 Given a tree and a sum, returns true if there is a path from the root 
	 down to a leaf, such that adding up all the values along the path 
	 equals the given sum.
	 Strategy: subtract the node value from the sum when recurring down, 
	 and check to see if the sum is 0 when you run out of tree. 

	 Sample: http://www.geeksforgeeks.org/find-the-maximum-sum-path-in-a-binary-tree/

	 */ 
	public boolean hasPathSum(int sum) { 
		return( hasPathSum(root, sum) ); 
	}

	boolean hasPathSum(Node node, int sum) { 
		// return true if we run out of tree and sum==0 
		if (node == null) { 
			return(sum == 0); 
		} 
		else { 
			// otherwise check both subtrees 
			int subSum = sum - node.data; 
			return(hasPathSum(node.left, subSum) || hasPathSum(node.right, subSum)); 
		} 
	} 


	/*
	 	Given a binary tree, find the maximum path sum. The path may start and end at any node in the tree.

		Example:

		Input: Root of below tree
		       1
		      / \
		     2   3
		Output: 6

		See below diagram for another example.
		1+2+3

	 	http://www.geeksforgeeks.org/find-maximum-path-sum-in-a-binary-tree/
	 * 
	 */
	public int findMaxSum(){

		int[] max = {Integer.MIN_VALUE};

		findMaxSum(root, max);

		return max[0];
	}

	private int findMaxSum(Node node, int[] currentMax){

		if(node == null)
			return 0;

		int left  = findMaxSum(node.left, currentMax);
		int right = findMaxSum(node.right, currentMax);

		int singlePathMax = Math.max(node.data, Math.max(left+node.data, right+node.data));

		currentMax[0]= Math.max(currentMax[0], Math.max(left+node.data+right, singlePathMax));

		return singlePathMax;
	}



	/** 
	  Prints the node values in the "inorder" order. 
	  Uses a recursive helper to do the traversal. 
	 */ 
	public void printTree() { 
		printTree(root); 
		System.out.println(); 
	}
	private void printTree(Node node) { 
		if (node == null) return;

		// left, node itself, right 
		printTree(node.left); 
		System.out.print(node.data + "  "); 
		printTree(node.right); 
	} 



	/** 
	  Build 123 using three pointer variables. 
	 */ 
	public void build123a() { 
		root = new Node(2); 
		Node lChild = new Node(1); 
		Node rChild = new Node(3);
		root.left = lChild; 
		root.right= rChild; 
	}

	/** 
	  Build 123 using only one pointer variable. 
	 */ 
	public void build123b() { 
		root = new Node(2); 
		root.left = new Node(1); 
		root.right = new Node(3); 
	} 


	/** 
	  Build 123 by calling insert() three times. 
	  Note that the '2' must be inserted first. 
	 */ 
	public void build123c() { 
		root = null; 
		root = insert(root, 2); 
		root = insert(root, 1); 
		root = insert(root, 3); 
	} 

	public void buildHasPathSumTree(){
		root = new Node(10);
		root.left = new Node(-2);
		root.right = new Node(7);
		root.left.left = new Node(8);
		root.left.right = new Node(-4);
	}

	public void buildTree1ForfindMaxSum(){
		root = new Node(10);
		root.left = new Node(2);
		root.right = new Node(10);
		root.left.left = new Node(20);
		root.left.right = new Node(1);
		root.right.right = new Node(-25);
		root.right.right.left = new Node(3);
		root.right.right.right = new Node(4);
	}

	public void buildTree2ForfindMaxSum(){
		root = new Node(10);
		root.right = new Node(-25);
		root.right.left = new Node(3);
		root.right.right = new Node(4);

	}
}