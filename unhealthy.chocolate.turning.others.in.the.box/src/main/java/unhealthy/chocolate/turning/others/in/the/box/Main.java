package unhealthy.chocolate.turning.others.in.the.box;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Pablo has square chocolate Box of size n x n in which a variety of healthy chocolates 
 * are present denoted by ‘H’ initially but he finds out that some of the chocolates are 
 * rotten and are unhealthy denoted by ‘U’. 
 * 
 * In one day the rotten chocolates make all its neighboring chocolates as unhealthy. 
 * 
 * This goes on and on until all chocolates present in the chocolate box becomes Unhealthy to eat.
 * 
 * Find out the number of days in which the whole chocolate box becomes Unhealthy.
 * 
 */
public class Main {

	public static void main(String[] args) {
		char[][] box = { 
				{'H', 'H', 'H', 'U', 'H', 'H', 'H', 'H'},
				{'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H'},
				{'H', 'H', 'U', 'H', 'H', 'H', 'H', 'H'},
				{'H', 'H', 'H', 'H', 'H', 'H', 'H', 'H'} 
			};
		System.out.println(numberOfDays(box));
	}
	
	static boolean isValid(int i, int j, int n, int m){
		System.out.printf("isValid(%d, %d, %d, %d)\n", i, j, n, m);
		if(i<0 || j<0 || i>=n || j>=m)
			return false;
		return true;
	}

	static int numberOfDays(char[][] box){
		
		class Point{
			int x, y;
			Point(int x, int y){
				this.x=x;
				this.y=y;
			}
			@Override
			public String toString() {
				return String.format("Point(%d, %d)", x, y);
			}
		}
		
		Queue<Point> queue = new LinkedList<>();
		
		if(box==null)
			throw new IllegalArgumentException();

		int n = box.length;
		int m = box[0].length;
		
		System.out.printf("Box is of size %d x %d\n", n, m);
		
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				if(box[i][j] == 'U')
					queue.add(new Point(i, j));
		
		System.out.printf("Number of unhealthy chocolates in the box are %d\n", queue.size());
		
		queue.add(new Point(-1, -1));
		
		int flag=0;
		int numOfDays = 0;
		while(!queue.isEmpty()){
			Point p = queue.remove();
			int i = p.x;
			int j = p.y;
			
			if(i==-1 && j==-1){
				flag++;
				queue.add(new Point(-1, -1));
				if(flag==2)
					break;
				
				numOfDays++;
			}else{
				flag=0;
				if(isValid(i-1, j-1, n, m) && box[i-1][j-1]=='H'){
					queue.add(new Point(i-1, j-1));
					box[i-1][j-1]='U';
				}
				if(isValid(i-1, j, n, m) && box[i-1][j]=='H'){
					queue.add(new Point(i-1, j));
					box[i-1][j]='U';
				}	
				if(isValid(i-1, j+1, n, m) && box[i-1][j+1]=='H'){
					queue.add(new Point(i-1, j+1));
					box[i-1][j+1]='U';
				}

				
				if(isValid(i, j-1, n, m) && box[i][j-1]=='H'){
					queue.add(new Point(i, j-1));
					box[i][j-1]='U';
				}
				if(isValid(i, j+1, n, m) && box[i][j+1]=='H'){
					queue.add(new Point(i, j+1));
					box[i][j+1]='U';
				}
					
				
				if(isValid(i+1, j-1, n, m) && box[i+1][j-1]=='H'){
					queue.add(new Point(i+1, j-1));
					box[i+1][j-1]='U';
				}
				if(isValid(i+1, j, n, m) && box[i+1][j]=='H'){
					queue.add(new Point(i+1, j));
					box[i+1][j]='U';
				}
				if(isValid(i+1, j+1, n, m) && box[i+1][j+1]=='H'){
					queue.add(new Point(i+1, j+1));
					box[i+1][j+1]='U';
					
				}
					
			}
			
		}
		
		return numOfDays-1;
	}

}
