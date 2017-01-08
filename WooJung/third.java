import java.util.Scanner;

public class third {

	static int N;
	static int max;
	static int[] put = new int[200];
	static int[] dp = new int[200];
	
	static int f(int a, int b){
		
		int t = put[a];
		if(N==0){
			return 0;
		}
		if(N==1){
			return 0;
		}
		if(dp[a]<=b){
			dp[a]=b;
		}
		max = max<b ? b:max;
		
		for(int i=0; i<N; i++){
			if(t<put[i]){
				f(i,b+1);
			}
		}
		
		return max;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		
		for(int i=0; i<N; i++){
			put[i] = sc.nextInt();
		}
		
		for(int i=0; i<N; i++){
			f(i,0);
		}
		
		System.out.println(N-max);
	}
	
}

