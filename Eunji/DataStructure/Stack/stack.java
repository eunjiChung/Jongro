import java.util.*;


public class stack {

	public static class Node{
		public int data;
		public Node next;
	}
	
	public void Push(int data, Node S){
		Node TmpCell = new Node();
		
		if(TmpCell.equals(null))
			System.out.println("Out of space!!!");
		else{
			TmpCell.data = data;
			TmpCell.next = S.next;
			S.next = TmpCell;
		}
	}
	
	public void Pop(Node S){
		
		if(IsEmpty(S))
			System.out.println("No Data!!");
		else{
			S.next = S.next.next;
			MakeEmpty(S.next);
		}
		
	}
	
	public static Node CreateStack(){
		Node S = new Node();
		
		if(S.equals(null))
			System.out.println("Out of space!!!");
		S.next = null;
		return S;
	}
	
	public boolean IsEmpty(Node S){
		return S.next.equals(null);
	}
	
	public void MakeEmpty(Node S){
		if(IsEmpty(S))
			System.out.println("Must use CreateStack First!!");
		else
			while(!IsEmpty(S))
				Pop(S);
	}
	
	public int Top(Node S){
		if(!IsEmpty(S))
			return S.next.data;
		System.out.println("Empty Stack");
		return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node stack = new Node();
		stack = CreateStack();
		
	}

}
