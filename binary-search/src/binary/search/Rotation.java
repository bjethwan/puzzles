package binary.search;

import java.util.Arrays;

public class Rotation {

	public static void rotateUsingIntermediateArray(int[] nums, int k) 
	{
		if (nums == null || nums.length==0 || k < 0) 
			throw new IllegalArgumentException("Illegal argument!");
		
		if(k > nums.length) 
			k= k % nums.length;

		int[] result = new int[nums.length];

		for(int i=0; i < k; i++)
		{
			result[i] = nums[nums.length-k+i];
		}

		int j=0;
		for(int i=k; i<nums.length; i++)
		{
			result[i] = nums[j++];
		}

		System.arraycopy( result, 0, nums, 0, nums.length );
	}

	public static void rotateUsingBubble(int[] nums, int k) 
	{
		if (nums == null || nums.length==0 || k < 0) 
			throw new IllegalArgumentException("Illegal argument!");

		if(k > nums.length) 
			k= k % nums.length;

		for (int i = 0; i < k; i++) 
		{
			for (int j = nums.length - 1; j > 0; j--) 
			{
				int temp = nums[j];
				nums[j] = nums[j - 1];
				nums[j - 1] = temp;
			}
		}
	}
	
	public static void rotateUsingReversal(int[] nums, int k) 
	{	
		if (nums == null || nums.length==0 || k < 0) 
			throw new IllegalArgumentException("Illegal argument!");
		
		if(k > nums.length) 
			k= k % nums.length;
	 
		//length of first part
		int a = nums.length - k; 
	 
		reverse(nums, 0, a - 1);
		reverse(nums, a, nums.length - 1);
		reverse(nums, 0, nums.length - 1);
	}
	 
	public static void reverse(int[] nums, int left, int right)
	{
		if(nums == null || nums.length <= 1) 
			return;
	 
		while(left < right){
			int temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;
			left++;
			right--;
		}	
	}
	
	
	public static void main(String[] args) 
	{
		int[] a = {1,2,3,4,5,6,7};

		rotateUsingBubble(a, 3);

		System.out.print("Array after rotation: ");
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+", ");
		}



	}
}
