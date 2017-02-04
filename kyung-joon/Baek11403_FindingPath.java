import java.util.*;
public class Baek11403_FindingPath {
	public static void main(String[] args) {
		new Baek11403_FindingPath();
	}
	
	static final int INF = 1000001; 
	int N;
	int[][] path;
	Baek11403_FindingPath() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		path = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				path[i][j] = sc.nextInt();
				path[i][j] = path[i][j]!=0 ? path[i][j] : INF;
			}
		}
		sc.close();
		
		floyd();
		for(int i=1; i<=N; i++, System.out.println()) {
			for(int j=1; j<=N; j++) {
				System.out.print((path[i][j]!=INF ? 1 : 0)+" ");
			}
		}
	}
	
	void floyd() {
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					path[i][j] = Math.min(path[i][j], path[i][k]+path[k][j]);
				}
			}
		}
	}
}
