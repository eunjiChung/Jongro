import java.util.Scanner;

public class stack {
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		
		for(int i=0; i<test_case; i++){
			
			String a = sc.next();
			
			if(result(a)) System.out.println("YES");
			else System.out.println("NO");
			
			
		}
	}
	public static boolean result(String a){
		MyStack myStack = new MyStack(a.length());
		for(int j=0; j<a.length(); ++j){
			if(a.charAt(j)=='('){
				myStack.push(a.charAt(j));
			}else{
				if(myStack.isEmpty()){
					return false;
				}else
					myStack.pop();
			}
		}
		return myStack.isEmpty();
		}
}



class MyStack{
	Object[] stack;
	int stackSize;
	int top;
	
	public MyStack(int size) { 

		  stack = new Object[size];
		  stackSize = size;
		  top = 0;
	}
	
	public void push(Object x){

		if(top < stackSize){
			stack[top++] = x;
		} else {
			System.out.println("Stack is full");
		}
	}
	
	public Object pop(){

		if(top>0){

			return stack[--top];

		}else

		  return null;
	}
	
	public boolean isEmpty(){

		  return top == 0;

	}
}