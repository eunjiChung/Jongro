package baek;

import java.util.*;

public class baek11404 {

	static Scanner scan = new Scanner(System.in);
	static final int INF = 100001; //무한대
	static int N, M;
	static int[][] weight;
	
	public static void initMatrix(int begin, int end, int cost){
		if(weight[begin-1][end-1] > cost)
			weight[begin-1][end-1] = cost;
	}
	
	public static void shortestPath(int start){
		int distance[] = new int[N];
		boolean found[] = new boolean[N];  // Label visiting node
		int pred[] = new int[N];  // previous vertex
		int u;
		
		// Initialize
		for(int i = 0; i < N; i++){
			distance[i] = weight[start][i];
			found[i] = false;
			if(weight[start][i] != 0) pred[i] = start;
		}
		found[start] = true; // Label starting Vertex
		distance[start] = 0;  // Label starting Vertex Distance
		
		for(int i = 0; i < N; i++){
			u = choose(distance, found); // minimum distance vertex
			found[u] = true; // label minimum distance vertex
			for(int w= 0; w < N; w++){
				if(found[w] == false){  
					// except cyclic node, find minimum distance from u to other vertexes
					if((weight[u][w] != 0) && ((distance[w] == 0) || 
							((distance[u] + weight[u][w]) <= distance[w]))){
						distance[w] = distance[u] + weight[u][w];
						pred[w] = u;
					}
				}
			}
		}
		
		for(int i = 0; i < N; i++){
			System.out.print(distance[i] + " ");
		}
		System.out.println();
	}
	
	public static int choose(int d[], boolean f[]){
		int min, min_p = 0;
		min = INF;
		
		for(int i = 0; i < N; i++){
			// Find minimum distance
			// if vertex is not visited and not the start node
			if((d[i] < min) && (f[i] != true) && (d[i] != 0)){
				min = d[i];
				min_p = i;
			}
		}
		return min_p;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		N = scan.nextInt();
		weight = new int[N][N];
		
		// Initialize the Matrix
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				if(i == j) weight[i][j] = 0;
				else weight[i][j] = INF;
			}
		}
		
		M = scan.nextInt();
		// Input bus start, end, cost 
		for(int i = 0; i < M; i++){ initMatrix(scan.nextInt(), scan.nextInt(), scan.nextInt()); }
		// Find the Shortest path
		for(int i = 0; i < N; i++){ shortestPath(i); }
	}
}
