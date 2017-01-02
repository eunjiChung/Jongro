/*
 * Just LinkedList
 */

public class LinkedList{
	
	private class Node{
		private Object data;
		private Node next;
	}
	
	public static Node MakeEmpty(){
		Node header = new Node();
		header.data = 0;
		header.next = null;
		return header;
	}
	public boolean IsEmpty(Node L){
		if(L.next.equals(null)){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean IsLast(Node L){
		if(!IsEmpty(L)){
			if(L.next.equals(null)){
				
			}
		}
		return true;
		
	}
	public Node FindPrev(){
		
	}
	public void Delete(){
		
	}
	public void Insert(){
		
	}
	public void DeleteList(){
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node header = MakeEmpty();
	}

}
