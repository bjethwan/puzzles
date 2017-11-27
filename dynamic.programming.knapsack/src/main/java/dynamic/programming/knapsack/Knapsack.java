package dynamic.programming.knapsack;

public class Knapsack {

//	public static void main(String[] args) {
//		int[] wt  = {4,  2, 3};
//		int[] val = {10, 4, 7};
//		
//		System.out.println(knapsack(5, wt, val));
//	}
	
	
	public static void main(String[] args) {
		int[] wt  = {2, 3, 4, 5};
		int[] val = {3, 4, 5, 6};
		
		System.out.println(knapsack(5, wt, val));
	}
	
	public static int knapsack(int S, int[] wt, int[] val){
		
		//Number of items.
		int n = wt.length;
		
		//DP table
		int[][] dp = new int[n+1][S+1];
		
		//Initial Condition
		for(int j=0; j<=S; j++)
			dp[n][j] = 0;
		
		//Topological Sort
		for(int i=n-1; i>=0; i--){
			for(int j=0; j<=S; j++){
				if(j>=wt[i]){
					dp[i][j] = Math.max(
							dp[i+1][j], 
							val[i] + dp[i+1][j-wt[i]]);
				}else
					dp[i][j] = dp[i+1][j];
			}
		}
			
		//Ans would be at dp[0][S]
		return dp[0][S];
	}
}
