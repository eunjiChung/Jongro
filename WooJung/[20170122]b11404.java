import java.util.Scanner;

public class b11404 {

	static int route[][] = new int[101][101];
	static int N, M = 0;
	static int A, B, C =0;
	static final int INF = 100001;
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		N = sc.nextInt();
		M = sc.nextInt();
		for(int i= 0; i<101; i++){
			for(int j=0; j<101; j++){
				if(i==j){
					route[i][j] = 0;
				}else
					route[i][j] = INF;
			}
		}
		plo(N,M);
		int res = 0;
		for(int i=1; i<=N; i++){
			for(int j=1; j<=N; j++){
				if(route[1][i] == INF){
				System.out.print("0"+"");}
				else{
				System.out.print(route[i][j]+" ");}
			}
			System.out.println();
		}

	}

	static void plo(int a, int b){
		for(int i=0; i<b; i++){
			A = sc.nextInt();
			B = sc.nextInt();
			C = sc.nextInt();
			
			if(route[A][B] > C){
				route[A][B] = C;
			}
		}
		for(int j=1; j<= a;j++){
			for(int k=1; k<= a; k++){
				for(int o=1; o<=a;o++){
					route[k][o]=result(route[k][j]+route[j][o],route[k][o]);
				}
			}
		}		
	}
	static int result(int a, int b){
		return a > b ? b : a;
	}
}
