package baek;

import java.util.*;

public class baek6359 {

	static Scanner scan = new Scanner(System.in);
	static int room[];
	
	public static int escapeRoom(){
		room[0] = 1;
		
		if(room.length > 1){
			for(int i = 1; i < room.length-1; i++){
				room[i] = room[i-1] + isPrime(i+1);
			}
		}
		return room[room.length-2];
	}
	
	public static int isPrime(int num){
		for(int i = 2; i < num; i++){
			if(i*i == num) return 1;
		}
		return 0;
	}
	
	public static int escapeRoom2(int num){
		
		return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int T = scan.nextInt();
		
		for(int i = 0; i < T; i++){
			room = new int[scan.nextInt()+1];
			System.out.println(escapeRoom());
		}
	}

}
