class LinkedList {
	ListNode headNode;
	
	private class ListNode {
		private Object data;
		private ListNode next;
		
		ListNode(Object data) {
			this.setData(data);
		}
	
		ListNode(Object data, ListNode next) {
			this.setData(data);
			this.setNext(next);
		}
	
		public Object getData() {
			return data;
		}
	
		public void setData(Object data) {
			this.data = data;
		}
		
		public ListNode getNext() {
			return next;
		}
	
		public void setNext(ListNode next) {
			this.next = next;
		}
	}
	
	private boolean isNodeEmpty(ListNode node) {
		if(node==null) return true;
		else return false;
	}

	private ListNode getNode(int index) {
		if(isNodeEmpty(headNode)) return null;
		ListNode nodeToGet = headNode;
		while(index-->0) {
			if(nodeToGet==null) return null;
			nodeToGet = nodeToGet.next;
		}
		return nodeToGet;
	}
	
	
	
	public void addNodeToFirst(Object data) {
		ListNode nodeToAdd = new ListNode(data,headNode);
		headNode = nodeToAdd;
	}
	
	public void addNodeToPosition(Object data, int index) throws NullPointerException {
		ListNode nodeToAdd = new ListNode(data);
		ListNode tempNode = headNode; 
		while(--index>0) {
			tempNode = tempNode.getNext();
		}
		nodeToAdd.setNext(tempNode.getNext());
		tempNode.setNext(nodeToAdd);
	}
	
	public void addNodeToLast(Object data) {
		ListNode nodeToAdd = new ListNode(data);
		if(headNode==null) {
			this.headNode = nodeToAdd;
		} else {
			ListNode tempNode = headNode;
			while(tempNode.getNext()!=null) {
				tempNode = tempNode.getNext();
			}
			tempNode.setNext(nodeToAdd);
		}	
	}
	

	public void deleteFirstNode() {
		if(isNodeEmpty(headNode)) return;
		headNode = headNode.next;
	}
	
	public void deleteNodePosition(int index) throws NullPointerException {
		if(isNodeEmpty(headNode)) return;
		ListNode tempNode = headNode; 
		while(--index>0) {
			tempNode = tempNode.getNext();
		}
		tempNode.setNext(tempNode.getNext().getNext());
	}
	
	
	public Object getDataIndex(int index) {
		return getNode(index).getData();
	}
	
	public String printList() {
		StringBuilder sb = new StringBuilder();
		ListNode tempNode = headNode;
		while(tempNode!=null) {
			sb.append(tempNode.getData());
			tempNode = tempNode.getNext();
		}
		return sb.toString();
	}
}

public class DataStructure_LinkedList {
	public static void main(String[] argc) {
		LinkedList list = new LinkedList();
		list.addNodeToLast(1);
		list.addNodeToLast("b");
		list.addNodeToFirst(3);
		list.addNodeToLast(4);
		list.addNodeToPosition("¸¶",3);
		System.out.println(list.printList());
		list.deleteNodePosition(3);
		list.deleteFirstNode();
		System.out.println(list.printList());
		System.out.println(list.getDataIndex(0));
		System.out.println(list.getDataIndex(2));
	}
}
