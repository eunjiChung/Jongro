
class ListNode {
	private Object data;
	private ListNode next;
	
	ListNode() {
	}
	
	ListNode(Object data) {
		this.setData(data);
		this.setNext(null);
	}

	public ListNode getNext() {
		return next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}

class LinkedList {
	ListNode headNode;
	
	public LinkedList() {
		this.headNode = null;
	}
	
	public void addNodeToLast(Object data) {
		ListNode nodeToAdd = new ListNode(data);
		if(headNode==null) {
			this.headNode = nodeToAdd;
		} else {
			ListNode tempNode = new ListNode();
			tempNode = headNode;
			while(tempNode.getNext()!=null) tempNode = tempNode.getNext();
			tempNode.setNext(nodeToAdd);
		}	
	}
	
	public String printList() {
		ListNode tempNode = new ListNode();
		StringBuilder sb = new StringBuilder();
		tempNode = headNode;
		//while(tempNode.getNext()!=null)
		{
			sb.append(tempNode.getData());
		}
		return sb.toString();
	}
}

public class DataStructure_LinkedList {
	public static void main(String[] argc) {
		LinkedList list = new LinkedList();
		list.addNodeToLast(1);
		list.addNodeToLast(2);
		list.addNodeToLast(4);
		list.addNodeToLast(3);
		System.out.println(list.printList());
	}
}
