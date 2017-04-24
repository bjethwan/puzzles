package running.median;

import java.util.NoSuchElementException;

import algs4.cs.princeton.edu.MaxPQ;
import algs4.cs.princeton.edu.MinPQ;

/**
 * This implementation is good only when 
 * the number of incoming elements can fit on the available memory.
 * https://www.youtube.com/watch?v=VmogG01IjYc
 * 
 */
public class RunningMedian {

	private MaxPQ<Integer> leftMaxPq;
	private MinPQ<Integer> rightMinPq;

	private enum Balance {EQUAL, LEFT_HEAVY, RIGHT_HEAVY};
	
	public RunningMedian(int capaity){
		leftMaxPq = new MaxPQ<>(capaity/2);
		rightMinPq = new MinPQ<>(capaity/2);
	}

	//This method allows insertion of a key into running median data structure
	public void  insert(Integer key)
	{
		Balance balance = check();

		switch(balance){
			case EQUAL:
				if(leftMaxPq.isEmpty() || less(key, leftMaxPq.max()))
				{
					leftMaxPq.insert(key);
				}	
				else
				{
					rightMinPq.insert(key);
				}
				break;
			case LEFT_HEAVY:
				if(less(key, leftMaxPq.max()))
				{
					leftMaxPq.insert(key);
					rightMinPq.insert(leftMaxPq.delMax());
					System.out.print("Balance ");
				}
				else
				{
					rightMinPq.insert(key);
				}
				break;
			case RIGHT_HEAVY:
				if(less(key, leftMaxPq.max()))
				{
					leftMaxPq.insert(key);
				}
				else
				{
					rightMinPq.insert(key);
					leftMaxPq.insert(rightMinPq.delMin());
					System.out.print("Balance ");
				}
				break;
		}
	}

	public double getMedian()
	{
		Balance balance = check();

		switch(balance){
			case EQUAL:
				if(leftMaxPq.isEmpty())
					throw new NoSuchElementException("underflow error");
				return (double)(leftMaxPq.max() + rightMinPq.min())/(double)2;
			case LEFT_HEAVY:
				return leftMaxPq.max();
			case RIGHT_HEAVY:
				return rightMinPq.min();

		}
		
		return -1;
	}

	private Balance check()
	{
		if(leftMaxPq.size() == rightMinPq.size()) 
			return Balance.EQUAL;
		else if(leftMaxPq.size()>rightMinPq.size())
			return Balance.LEFT_HEAVY;
		else
			return Balance.RIGHT_HEAVY;
	}

	private boolean less(Integer k1, Integer k2){
		return (k1.compareTo(k2) < 0);
	}

	public static void main(String[] args) {
		Integer a[] = {7,1,1,2,1,1,9,0,0,0,2,7};
		RunningMedian rm = new RunningMedian(a.length);
		
		for(int num:a){
			rm.insert(num);
			System.out.println(rm.getMedian());
		}
	}
	
	/*
	 * 						Input													Median
	 * 					  (sorting)
	 * 						  7														  7
	 * 						1, 7													  4
	 * 					   1, 1, 7													  1
	 * 					 1, 1, 2, 7													  1.5
	 * 				   1, 1, 1, 2, 7												  1
	 * 				  1, 1, 1, 1, 2, 7												  1
	 * 				1, 1, 1, 1, 2, 7, 9												  1
	 *             0, 1, 1, 1, 1, 2, 7, 9											  1
	 *           0, 0, 1, 1, 1, 1, 2, 7, 9											  1
	 *         0, 0, 0, 1, 1, 1, 1, 2, 7, 9											  1
	 *        0, 0, 0, 1, 1, 1, 1, 2, 2, 7, 9	 									  1
	 *       0, 0, 0, 1, 1, 1, 1, 2, 2, 7, 7, 9										  1
	 *        
	 */


}
