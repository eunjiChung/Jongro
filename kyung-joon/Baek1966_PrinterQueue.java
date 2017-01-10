import java.util.*;

class PrinterNode {
	int priority;
	int tag;
	PrinterNode(int priority, int tag) {
		this.priority = priority;
		this.tag = tag;
	}
}

class PrinterQueue {
	private PrinterNode[] arr;
	private int front, rear;
	
	PrinterQueue(int length) {
		arr = new PrinterNode[length+1]; //원형큐는 공백한개가 들어간다.
		for(int i=0; i<=length; i++) arr[i] = new PrinterNode(0,0);
		front = rear = 0;
	}
	boolean isEmpty() {
		return (front == rear);
	}
	boolean isFull() {
		return (front == (rear+1)%arr.length);
	}
	boolean enqueue(PrinterNode node) {
		if(isFull()) return false;
		arr[rear] = node;
		rear = (rear+1)%arr.length;
		return true;
	}
	PrinterNode dequeue() {
		if(isEmpty()) return null;
		PrinterNode val_out = arr[front];
		front = (front+1)%arr.length;
		return val_out;
	}
	PrinterNode peekFront() {
		if(isEmpty()) return null;
		return arr[front];
	}
}


class Printer {
	public final static int TAGGED = 1;
	public final static int NOT_TAGGED = 0;
	
	Printer() {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-- > 0) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			PrinterQueue printQ = new PrinterQueue(N);
			PriorityQueue<Integer> priorQ = new PriorityQueue<>(new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2 - o1;
				}
			}); 
			
			for(int i=0; i<N; i++) {
				int input = sc.nextInt();
				priorQ.add(input);
				if(i==M) printQ.enqueue(new PrinterNode(input,TAGGED));
				else printQ.enqueue(new PrinterNode(input,NOT_TAGGED));
			}
			
			int count=0;
			while(!printQ.isEmpty()) {
				if(printQ.peekFront().priority == priorQ.peek()) {
					count++;
					priorQ.poll();
					if(printQ.dequeue().tag == TAGGED) break;
				} else {
					printQ.enqueue(printQ.dequeue());
				}
			}
			System.out.println(count);
		}
		sc.close();
	}
}

public class Baek1966_PrinterQueue {
	public static void main(String[] argc) {
		new Printer();
	}
}