import java.util.*;

class PrinterNode {
	int priority;
	int tag;
	PrinterNode(int priority, int tag) {
		this.priority = priority;
		this.tag = tag;
	}
}

class Printer {
	public static final int TAGGED = 1;
	public static final int NOT_TAGGED = 0;
	
	Printer() {
		runThroughList();
		//run();
	}
	
	void runThroughList() {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-- > 0) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			LinkedList<PrinterNode> printQ = new LinkedList<>(); 
			PriorityQueue<Integer> priorQ = new PriorityQueue<>(new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2 - o1;
				}
			}); 
			
			for(int i=0; i<N; i++) {
				int input = sc.nextInt();
				priorQ.add(input);
				if(i==M) printQ.add(new PrinterNode(input,TAGGED));
				else printQ.add(new PrinterNode(input,NOT_TAGGED));
			}
			
			int count=0;
			while(!printQ.isEmpty()) {
				if(printQ.peek().priority == priorQ.peek()) {
					count++;
					priorQ.poll();
					if(printQ.poll().tag == TAGGED) break;
				} else {
					printQ.add(printQ.poll());
				}
			}
			System.out.println(count);
		}
		sc.close();
	}
	
	void run() {
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


class PrinterQueue {
	private PrinterNode[] arr;
	private int front, rear;
	
	PrinterQueue(int length) {
		arr = new PrinterNode[length+1]; //원형큐는 공백한개가 추가로 들어간다.
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