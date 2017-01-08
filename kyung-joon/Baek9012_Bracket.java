import java.util.Scanner;
import java.util.Stack;

class BracketStack {
	private char[] data;
	private int top;
	
	BracketStack(int size) {
		data = new char[size];
		top = -1;
	}
	boolean isEmpty() {
		return (top==-1);
	}
	boolean isFull() {
		return (top==data.length-1);
	}
	boolean push(char data) {
		if(isFull()) return false;
		this.data[++top] = data;
		return true;
	}
	boolean pop() {
		if(isEmpty()) return false;
		top--;
		return true;
		
	}
}

class Bracket {
	boolean run(String str) {
		BracketStack stack = new BracketStack(str.length());
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == '(') {
				if(!stack.push(str.charAt(i))) return false;
			} else if(str.charAt(i) == ')') {
				if(!stack.pop()) return false;
			}
		}
		if(stack.isEmpty()) return true;
		else return false;
	}
	
	boolean runThroughAPI(String str) {
		Stack<Character> stack = new Stack<>();		
		try {
			for(int i=0; i<str.length(); i++) {
				if(str.charAt(i) == '(') {
						stack.push(str.charAt(i));
				} else if(str.charAt(i) == ')') {
					stack.pop();
				}
			}
		} catch(Exception e) {
			return false;
		}
		if(stack.isEmpty()) return true;
		else return false;
	}
}

public class Baek9012_Bracket {
	public static void main(String[] argc) {
		Scanner sc = new Scanner(System.in);
		int C = Integer.parseInt(sc.nextLine());
		while(C-->0) {
			Bracket b = new Bracket();
			if(b.run(sc.nextLine())) System.out.println("YES");
			else System.out.println("NO");
		}
		sc.close();
	}
}