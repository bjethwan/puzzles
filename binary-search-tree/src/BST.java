import java.util.Iterator;
import java.util.NoSuchElementException;

import algs4.cs.princeton.edu.Queue;
import algs4.cs.princeton.edu.Stack;



public class BST<Key extends Comparable<Key>> 
{
	private Node root;

	private class Node
	{
		private Key key;
		private Node left;
		private Node right;
		private int N;             // # of nodes in subtree

		public Node(Key key, int size)
		{
			this.key = key;
			this.N = size;
		}
	}

	public BST(Key...keys)
	{
		for(Key key : keys)
			root = put(root, key);

	}
	public void put(Key key)
	{
		if (key == null) 
			throw new NullPointerException("first argument to put() is null");

		root = put(root, key);
	}
	private Node put(Node x, Key key)
	{
		if(x == null)
			return new Node(key, 1);

		int cmp = key.compareTo(x.key);

		if(cmp < 0)
			x.left = put(x.left, key);
		else if(cmp > 0)
			x.right = put(x.right, key);
		else
			;

		x.N = 1 + size(x.left) + size(x.right);

		return x;
	}



	/*
	 * Trim Binary Search Tree
	 * ---------------------------
	 * 
	 * Given the root of a binary search tree and 2 numbers min and max, 
	 * trim the tree such that all the numbers in the new tree,
	 * are between min and max (inclusive). 
	 * 
	 * The resulting tree should still be a valid binary search tree.
	 * 
	 */
	public void trimBST(Key min, Key max){
		root = trimBST(root, min, max);
	}

	private Node trimBST(Node node, Key min, Key max){
		
		if(node == null)
			return null;

		node.left = trimBST(node.left, min, max);
		node.right = trimBST(node.right, min, max);

		if(node.key.compareTo(min) < 0)
			return node.right;
		if(node.key.compareTo(max) > 0)
			return node.left;

		return node;
	}













	public void print()
	{
		print(root);
		System.out.println();
	}
	private void print(Node x) 
	{
		if (x == null) return;
		print(x.left);
		System.out.print(x.key + " ");
		print(x.right);

	}

	/**
	 * Returns the number of key-value pairs in this symbol table.
	 * @return the number of key-value pairs in this symbol table
	 */
	public int size() {
		return size(root);
	}
	// return number of key-value pairs in BST rooted at x
	private int size(Node x) {
		if (x == null) return 0;
		else return x.N;
	}

	public boolean isEmpty()
	{
		return size() == 0;
	}

	public Key min()
	{
		if(isEmpty())
			throw new NoSuchElementException("called min() with empty bst");

		return min(root).key;
	}

	private Node min(Node x)
	{
		if(x.left == null) 
			return x;
		else
			return min(x.left);
	}

	public Key max()
	{
		if(isEmpty())
			throw new NoSuchElementException("called max() with empty bst");

		return max(root).key;
	}

	private Node max(Node x)
	{
		if(x.right == null)
			return x;
		else 
			return max(x.right);
	}

	public int height()
	{
		return height(root);
	}

	private int height(Node x)
	{
		if(x == null) 
			return -1;

		return 1 + Math.max(height(x.left), height(x.right));
	}

	public void mirror()
	{
		mirror(root);
	}

	private void mirror(Node x)
	{
		if(x == null) 
			return;

		mirror(x.left);
		mirror(x.right);

		Node temp = x.left;
		x.left = x.right;
		x.right = temp;
	}

	public void swap(Key key1, Key key2)
	{
		Node p = get(key1);
		Node q = get(key2);
		Key temp = p.key;
		p.key = q.key;
		q.key = temp;
	}

	//	public  int[] findSwapPositions()
	//	{
	//		Arrays.
	//		for(int i=0;i<N-2;i++)
	//		{
	//			if()
	//		}
	//		
	//	}

	private Node get(Key key)
	{
		Node x = root;

		while(x != null)
		{
			int cmp = key.compareTo(x.key);

			if(cmp < 0)
				x = x.left;
			else if(cmp > 0)
				x = x.right;
			else
				return x;
		}
		return null;
	}




	public Iterable<Key> keys()
	{
		Queue<Key> queue = new Queue<Key>();
		keys(root, queue);
		return queue;

	}

	private void keys(Node x, Queue<Key> queue)
	{
		if(x == null)
			return;
		keys(x.left, queue);
		queue.enqueue(x.key);
		keys(x.right, queue);
	}

	private class BSTInOrderIterator implements Iterator<Key>
	{
		private Stack<Node> stack;

		public BSTInOrderIterator()
		{
			stack = new Stack<Node>();

			Node x = root;

			while(x != null)
			{
				stack.push(x);
				x = x.left;
			}
		}

		@Override
		public boolean hasNext() 
		{	
			return !stack.isEmpty();
		}

		@Override
		public Key next() 
		{
			Node x = stack.pop();
			Key key = x.key;

			x = x.right;
			while(x!=null)
			{
				stack.push(x);
				x = x.left;
			}
			return key;
		}

	}
}
