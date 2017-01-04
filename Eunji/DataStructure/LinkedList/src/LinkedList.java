import java.util.*;

/*
 * Just LinkedList
 */

public class LinkedList{
	
	public static class Node{
		public int data;
		public Node next;
	}
	
	public static Node MakeEmpty(){
		Node header = new Node();
		header.data = 0;
		header.next = null;
		return header;
	}
	
	public static boolean IsEmpty(Node L){
		if(L.next.equals(null)){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean IsLast(Node p, Node L){
		return p.next.equals(null);
	}
	
	public static Node FindPrev(int data, Node L){
		Node p;
		p = L;
		
		System.out.print(p.data);
		while(!p.next.equals(null) && (p.next.data != data)){
			p = p.next;
		}
		return p;
	}
	
	public static void Delete(int data, Node L){
		Node p, TmpCell;
		p = FindPrev(data, L);
		
		if(!IsLast(p, L)){
			TmpCell = p.next;
			p.next = TmpCell.next;
		}
	}
	
	public static void Insert(int data, Node p, Node L){
		Node TmpCell = new Node();
		
		if(TmpCell.equals(null)){
			System.out.println("Out of space!!!");
		}else{
			TmpCell.data = data;
			TmpCell.next = p.next;
			p.next = TmpCell;
		}
	}
	
	public void DeleteList(Node L){
		Node p, Tmp;
		p = L.next;
		L.next = null;
		
		while(p.equals(null)){
			Tmp = p.next;
			p = null; //????
			p = p.next;
		}
	}
	

	public static int Joshep(Node L, int m){
		int data;
		for(int i = 0; i < m; i++){
			L = L.next;
		}
		data = L.data;
		Delete(L.data, L);
		return data;
	}
	
	public static void PrintList(Node L){
		while(!IsEmpty(L) && !L.next.equals(null)){
			System.out.print(L.data + " ");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		Node L = MakeEmpty();
		Node Joshep_L = MakeEmpty();
		 

		System.out.print("N과 M을 입력하세:");
		int n = s.nextInt();
		int m = s.nextInt();
		int data;
		
		int num = 1;
		for(int i = 0; i < n; i++){
			Insert(num++, FindPrev(num, L), L);
		}
		System.out.println("<print List>");
		PrintList(L);
		
		int num2;
		while(!IsEmpty(L)){
			num2 = Joshep(L, m);
			Insert(num2, FindPrev(num, Joshep_L), Joshep_L);
		}		
		System.out.println("<print 수>");
		PrintList(Joshep_L);
	}

}
