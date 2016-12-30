import java.util.*;

public class back2167 {

	static int arr[][];
	static int n, m;
	
	public static int addArr(int i, int j, int x, int y){
		int total = 0;		
		for(int u = (i-1); u < x; u++){	
			for(int v = (j-1); v < y; v++){
				total += arr[u][v];
			}
		}
		return total;
	};
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		n = s.nextInt(); m = s.nextInt();
		arr = new int[n][m];
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				arr[i][j] = s.nextInt();
			}
		}
	
		int k = s.nextInt();
		int i, j, x, y;
		
		for(int u = 0; u < k; u++){
			i = s.nextInt(); j = s.nextInt();
			x = s.nextInt(); y = s.nextInt();
			System.out.println(addArr(i, j, x, y));
		}
	}
}
