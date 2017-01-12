package baek;

import java.util.*;

public class baek11727 {
	static Scanner scan = new Scanner(System.in);
	static int n;
	static long tile[];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stu
		n = scan.nextInt();
		tile = new long[1001];
		tile[1] = 1;
		tile[2] = 3;
		for(int i = 3; i < tile.length; i++)
			tile[i] = (tile[i-1] + 2*tile[i-2]) % 10007;
		System.out.println(tile[n]);
	}
}
