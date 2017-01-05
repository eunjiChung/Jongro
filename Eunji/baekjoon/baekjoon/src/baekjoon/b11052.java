package baekjoon;

import java.util.*;

public class b11052 {

	public static int maxPrice(int[] p){
		
		return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stu
		Scanner s = new Scanner(System.in);
		System.out.print("붕어빵 갯수를 입력하시오: ");
		int n = s.nextInt();
		
		int p[] = new int[n];
		for(int i = 0; i < n; i++){
			p[i] = s.nextInt();
		}
		
		System.out.println("최대 이익: " + maxPrice(p));
	}

}
