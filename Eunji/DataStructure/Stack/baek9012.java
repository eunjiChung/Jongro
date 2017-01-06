package stack_1;

import java.util.*;

public class baek9012 {
	
	static Stack stack = new Stack();
	
	public static String validVPS(Stack s){
		Stack vps = new Stack();
		String string;
	
		while(!s.isEmpty()){
			string = (String)s.pop();
			if(!vps.isEmpty() && string.equals("(") && vps.peek().equals(")")){ vps.pop(); }
			else{ vps.push(string); }
		}
		
		if(!vps.isEmpty()) return "NO";
		return "YES";
	}

	public static Stack pushStack(Stack s, int num, String str){
		for(int i = 0; i < str.length(); i++)
			s.push(str.substring(i, i+1));
		return s;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);	
		int t = scan.nextInt();
		for(int i = 0; i < t; i++){
			System.out.println(validVPS(pushStack(stack, t, scan.next())));
		}
	}

}
