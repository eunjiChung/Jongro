package baek;

import java.util.Scanner;

public class baek11726 {
	
	static Scanner scan = new Scanner(System.in);
	static int n;
	static long tile[];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stu
		
		n = scan.nextInt();
		tile = new long[1001]; //왜 1001?
		tile[1] = 1;
		tile[2] = 2;
		
		for(int i = 3; i < tile.length; i++){
			tile[i] = tile[i-1] + tile[i-2];  // 이전 경우에서 | 막대 하나를 더 추가하는 경우
											  // + 이전,이전 경우에서 = 막대를 추가하는 경
			tile[i] = tile[i] % 10007;
		}
		
		System.out.println(tile[n]);
	}


}
