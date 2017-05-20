package com.bjethwan;

public class UF {

	private int[] parent;			// parent[i] = parent of i
	private int[] size;				// size[i] = number of sites in subtree rooted at i
	private int count;				// number of components

	public UF(int N){
		count = N;
		parent = new int[N];
		size   = new int[N];
		for(int i=0; i<N; i++){	
			parent[i] = i;
			size[i] = 1;
		}
	}

	public boolean connected(int p, int q){
		return find(p) == find(q);
	}

	public void union(int p, int q){
		
		int rootP = find(p);				// needed for correctness
		int rootQ = find(q);				// to reduce the number of array accesses

		if(rootP == rootQ)	return;		// p and q are already in the same component	
		
		if(size[rootP] < size[rootQ]){	// make smaller root point to larger one
			parent[rootP] = rootQ;
			size[rootQ] += size[rootP];
		}else{
			parent[rootQ] = rootP;
			size[rootP] += size[rootQ];
		}
		
		count--;
	}

	public int find (int p){			/* component identifier for p (0 - N-1) */
		while(p != parent[p]) 
			p = parent[p];
		return p;
	}

	public int count(){
		return count;
	}


}
