package baek;

import java.util.*;

public class baek10844 {
	static int[][] stairs = new int[100][10];
	
	public static void stairNum(int n){
		for(int i = 1; i <= 9; i++){
			stairs[1][i] = 1;
		}
		
		for(int i = 2; i <= n; i++){
			for(int j = 0; j <= 9; j++){
				stairs[i][j] = 0;
				if(j - 1 >= 0) stairs[i][j] += stairs[i-1][j-1];
				if(j + 1 <= 9) stairs[i][j] += stairs[i-1][j+1];
				stairs[i][j] %= 1000000000;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		try{
			int n = scan.nextInt();
			int answer = 0;
			
			stairNum(n);
			for(int i = 0; i <= 9; i++){
				answer += stairs[n][i];
				answer %= 1000000000;
			}
			System.out.print(answer);
		}finally{
			scan.close();
		}
	}
}
