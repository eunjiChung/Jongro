package baekjoon;

import java.util.*;

public class b11052 {
	static int n;
	static int[] p;
	
	public static int maxPrice(){
		int max = 0;
		int price[] = new int[n];
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < i; j++){
				System.out.println("b : " + i + " " + j + " " + price[i] + " " + (i-j) + " " +  p[j] + price[i - j]);
				price[i] = Math.max(price[i], p[j] + price[i - j]);
				System.out.println("a : " + i + " " + j + " " + price[i] + " " +  (i-j) + " " + p[j] + price[i - j] + "\n");
			}
		}
		return price[n-1];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stu
		Scanner s = new Scanner(System.in);
		System.out.print("붕어빵 갯수를 입력하시오: ");
		n = s.nextInt();
		p = new int[n];
		for(int i = 0; i < n; i++){
			p[i] = s.nextInt();
		}
		System.out.println("최대 이익: " + maxPrice());
	}

}
