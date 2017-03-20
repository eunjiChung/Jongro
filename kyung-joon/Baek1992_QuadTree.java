package examples;
import java.util.*;

public class Baek1992_QuadTree {
	public static void main(String[] args) {
		new Baek1992_QuadTree();
	}
	
	int N;
	char[][] arr;
	
	Baek1992_QuadTree() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sc.nextLine();
		arr = new char[N+1][N+1];
		for(int i=1; i<=N; i++) {
			String str = sc.nextLine();
			for(int j=1; j<=N; j++) {
				arr[i][j] = str.charAt(j-1);
			}
		}
		sc.close();
		System.out.println(divide(1,1,N));
	}	
	
	String divide(int m, int n, int amount) {
		if(amount==1) return arr[m][n]+"";
		amount/=2;
		String str = divide(m, n, amount) + divide(m, n+amount, amount)
				+ divide(m+amount, n, amount) + divide(m+amount, n+amount, amount);
		int sum=0;
		for(int i=0; i<str.length(); i++) {
			sum+=str.charAt(i)-'0';
		}
		if(sum==0) {
			return "0";
		} else if(sum==str.length()) {
			return "1";
		}
		return "("+str+")";
	}
}
