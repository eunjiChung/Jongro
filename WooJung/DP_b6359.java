import java.util.Scanner;

public class b6359 {

	static int count = 1;
	static int result = 0;
	static int bt[] = new int[101];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for(int i=0; i<TC; i++){
			result=0;
			int N = sc.nextInt();
			yack(N);
			System.out.println(result);
		}
	}
	
	private static void yack(int a){
		
		for(int k=a; k>0; k--){
			if(bt[k]==0){
			for(int i=1; i<=k; i++){
		         if((k%i)==0){
			         bt[k] += count;
		         }
			}
			}
		}
		for(int i=1; i<=a; i++){
			if(bt[i]%2!=0){
				result++;
			}
		}
	}
}
