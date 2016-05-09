package binary.heap;

public class MaxPQ<Key extends Comparable<Key>> {

	private int N;
	private Key[] pq;


	public MaxPQ(int capacity)
	{
		pq = (Key[])new Comparable[capacity];
	}


	public void insert(Key x)
	{
		pq[++N] = x;
		swim(N);
	}

	private void swim(int k) 
	{
		while(k > 1 && less(k/2, k))
		{
			exch(k, k/2);
			k = k/2;
		}
	}

	public Key delMax()
	{
		Key max = pq[1];
		exch(1, N--);
		sink(1);
		pq[N+1] = null;
		return max;
	}
	
	private void sink(int k)
	{

		while(2*k <= N)
		{
			int j = 2*k;
			if (j < N && less(j, j+1)) j++;
			if (!less(k, j)) break;
			exch(k, j);
			k = j;
		}
	}

	private boolean less(int i, int j)
	{
		return pq[i].compareTo(pq[j]) < 0;
	}

	private void exch(int i, int j)
	{
		Key swap = pq[i];
		pq[i] = pq[j];
		pq[j] = swap;
	}
}