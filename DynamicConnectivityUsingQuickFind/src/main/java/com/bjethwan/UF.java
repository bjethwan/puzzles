package com.bjethwan;

public class UF {
	
	private int[] id;				// id[i] = component identifier of i
	private int count;				// number of components
	
	public UF(int N){
		id = new int[N];
		count = N;
		for(int i=0; i<N; i++)
			id[i] = i;
	}
	
	public boolean connected(int p, int q){
		return id[p] == id[q];
	}
	
	public void union(int p, int q)
	{	
		int pid = id[p];				// needed for correctness
		int qid = id[q];				// to reduce the number of array accesses
		
		if(pid == qid)	return;		// p and q are already in the same component
		
		for(int i=0; i<id.length; i++)
			if(id[i] == pid) id[i] = qid;
		
		count--;
	}
	
	public int find (int p){			/* component identifier for p (0 - N-1) */
		return id[p];
	}
	
	public int count(){
		return count;
	}
	
	
}
