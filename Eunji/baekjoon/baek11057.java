package baek;

import java.util.*;

public class baek11057 {

	static int ascent[][];
	
	public static int countAscent(int n, int m){
		
		if(n == 1) return 1;
		if(ascent[n][m] != 0) return ascent[n][m];
		
		int sum = 0;
		for(int i = m; i >= 0; i--)
			sum += countAscent(n-1, i);
		ascent[n][m] = sum % 10007;
		return ascent[n][m];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		ascent = new int[10][n];
		
		System.out.print(countAscent(n, 9) % 10007);
	}

}
