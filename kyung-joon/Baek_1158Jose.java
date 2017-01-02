import java.io.IOException;
import java.util.Scanner;

class Node {
	int data;
	Node next;
}

class LinkedList {
	Node head;
	Node tail;
	int size;
	
	LinkedList() {	
	}
	
	LinkedList(int num) {
		while(num > 0) {
			addNode(num);
			num--;
		}
	}
	
	public void addNode(int data) {
		Node newNode = new Node();
		newNode.data = data;
		if(head==null) {
			newNode.next = newNode;
			head = tail = newNode;
		} else {
			newNode.next = head;	
			head = tail.next = newNode;
		}
		size++;
	}

	public void letsKill(int N, int M) {
		Node temp= new Node();
		temp.next=head;
		StringBuilder sb = new StringBuilder("<");
		for(int i=1; i<=N; i++) {
			for(int j=1; j<M; j++) { // Á×ÀÏ³ð ¾Õ³ëµå·Î ÀÌµ¿
				temp = temp.next;
			}
			sb.append(temp.next.data); // Á×Àº³ð Ãâ·Â
			if(i!=N) sb.append(", ");
			else sb.append(">");
			temp.next = temp.next.next; // Á×ÀÌ±â(¿¬°á²÷±â)
		}
		System.out.println(sb);
	}
}

class Jose {
	Jose () throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		LinkedList list = new LinkedList(N);
		list.letsKill(N,M);
	}
	
}

public class Baek_1158Jose {
	public static void main(String[] argc) throws IOException {
		try {
			Jose jose = new Jose();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}