package com.bjethwan;

public class Main {
	public static void main(String[] args) {
		int[][] board = {
				{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0}
		};
		print(board);
		if(Find8QueeensSolution(board, 0))
			print(board);
	}

	public static boolean Find8QueeensSolution(int[][] board, int num_positioned){
		if(!isBoardLegal(board)) return false;
		if(num_positioned == 8) return true;

		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				if(board[i][j] == 0){ 	//empty slot
					board[i][j] = 1;		//Fill the slot
					if(Find8QueeensSolution(board, num_positioned+1)) return true;
					board[i][j] = 0;		//Backtrack
				}
			}
		}
		return false;
	}

	

	private static boolean isBoardLegal(int[][] board){
		return false;

	}
	private static void print(int[][] board) {
		int rows = board.length;
		int cols = board[0].length;
		for(int i=0; i<rows; i++){
			for(int j=0; j<cols; j++)
				System.out.print(board[i][j] + "  ");
			System.out.println();
		}
	}
}
