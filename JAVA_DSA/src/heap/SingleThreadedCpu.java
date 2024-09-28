package heap;

import java.util.*;

public class SingleThreadedCpu {

	public static void main(String[] args) {
		int arr[][] = {
//				{7,10},
//				{7,12},
//				{7,5},
//				{7,4},
//				{7,2}
				{1,2},
				{2,4},
				{3,2},
				{4,1},
				
		};
		int ans[] = util3(arr);
		for(int i:ans) {
			System.out.print(i+" ");
		}
	}
	
	
	//based on the shortest job first algorithm in operating systems
	
	
	public static int[] util3(int[][]tasks) {
		//make a copy of matrix with adding indices
		int matrix[][] = new int[tasks.length][];
		for(int i = 0;i<matrix.length;i++) {
			matrix[i] = new int[] {tasks[i][0],tasks[i][1],i};
		}
		//now sort on the basis of arrival time
		Arrays.sort(matrix,(a,b)->(a[0] == b[0])?a[1]-b[1]:a[0]-b[0]);
		//keep a priority queue on the basis of execution time
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[1] == b[1])?a[2]-b[2]:a[1]-b[1]);
		//now start the algorithm
		int ans[] = new int[tasks.length];
		int indexAns = 0;
		int time =0;
		int indexMat = 0;
		while(indexAns<ans.length) {
			//any task that was available during the execution of the previous process
			while(indexMat<matrix.length && matrix[indexMat][0]<= time) {
				pq.add(new int[] {matrix[indexMat][0],matrix[indexMat][1],matrix[indexMat][2]});
				indexMat++;
			}
			//if the queue is empty , new processes will be added
			if(pq.isEmpty() == true) {
				time = matrix[indexMat][0];
				continue;
			}
			ans[indexAns++] = pq.peek()[2];
			time+=pq.poll()[1];
		}
		return ans;
	}
	
	
	

	
	
	//YEH BHI GALAT
	public static int[] util2(int[][] tasks){
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[0] == b[0])?a[1]-b[1]:a[0]-b[0]);
		for(int i = 0;i<tasks.length;i++) {
			pq.add(new int[]{tasks[i][0]+tasks[i][1],i});
		}
		int k=0;
		int ans[] = new int[tasks.length];
		while(pq.isEmpty() == false) {
			ans[k++] = pq.poll()[1];
		}
		return ans;
	}
	
	
	
	
	
	//failed
	public static int[] util1(int[][] tasks){
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[1] == b[1])?a[0]-b[0]:a[1]-b[1]);
		for(int i = 0;i<tasks.length;i++) {
			pq.add(new int[]{i,tasks[i][1]});
		}
		
		int[] ans = new int[tasks.length];
		int k = 0;
		while(pq.isEmpty() == false){
			ans[k++] = pq.poll()[0];
		}
		return ans;
	}
	
	

}
