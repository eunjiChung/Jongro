import java.util.*;

public class Baek11404_Floyd {
	public static void main(String[] args) {
		new Baek11404_Floyd();
	}
	
	int N, M;
	int[][] arr;
	
	Baek11404_Floyd() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N+1][N+1];
		
		// i==j 인 경우를 제외, 모든 경로를 무한으로 만들어 줌
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i!=j) arr[i][j] = Integer.MAX_VALUE;
			}
		}
		
		// 가능한 경로의 수를 인접행렬에 채워넣음
		for(int cnt=1; cnt<=M; cnt++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			arr[a][b] = Math.min(arr[a][b],c);
		}
		sc.close();
		
		// 플로이드와샬 알고리즘 수행 및 출력
		floyd();
		for(int i=1; i<=N; i++, System.out.println()) {
			for(int j=1; j<=N; j++) {
				System.out.print(arr[i][j] + " "); 
			}
		}
	}
	
	void floyd() {
		for(int k=1; k<=N; k++) { // k는 경유정점을 의미
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) { //i->j 와 i->k->j 중 더 빠른 경로를 선택
					if(arr[i][k]==Integer.MAX_VALUE || arr[k][j]==Integer.MAX_VALUE) continue;
					arr[i][j] = Math.min(arr[i][j], arr[i][k]+arr[k][j]);
				}
			}
		}
	}
}

/*
import java.util.*;

public class Baek11404_Floyd {
	public static void main(String[] args) {
		new Baek11404_Floyd();
	}
	
	int N, M;
	int[][] arr;
	
	Baek11404_Floyd() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N+1][N+1];
		
		for(int cnt=1; cnt<=M; cnt++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			arr[a][b] = selectShorterPath(arr[a][b],c);
		}
		
		floyd();
		for(int i=1; i<=N; i++, System.out.println()) {
			for(int j=1; j<=N; j++) {
				System.out.print(arr[i][j] + " "); 
			}
		}
		sc.close();
	}
	
	void floyd() {
		for(int k=1; k<=N; k++) { // k는 경유정점을 의미
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(i==j || arr[i][k]==0 || arr[k][j]==0) continue; //i->i 경로이거나, i->k 혹은 k->j가 막힌 길이면 비교 불가함 
					arr[i][j] = selectShorterPath(arr[i][j], arr[i][k]+arr[k][j]); // 바로 i->j가 빠른지, 아니면 i->k->j가 빠른지 비교함
				}
			}
		}
	}
	
	int selectShorterPath(int a, int b) {
		if(a==0) return b;
		else if(b==0) return a;
		else if(a>b) return b;
		return a;
	}
}
*/