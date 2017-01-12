import java.util.Scanner;

public class b11057 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			
		int N = sc.nextInt();
		int[][] dp = new int[N+1][10];
			
		for(int i=0; i<=9; i++){
			dp[1][i] = 1;
		}
			
		for(int i=2; i<=N; i++){
			for(int j=0; j<=9; j++){
				for(int k=j; k<=9; k++){
					dp[i][j] += dp[i-1][k];
				}
				dp[i][j] %= 10007;
			}
		}
			
		int max = 0;
		for(int i=0; i<=9; i++){
			max += dp[N][i];
		}
			
		System.out.println(max);
	}
}
