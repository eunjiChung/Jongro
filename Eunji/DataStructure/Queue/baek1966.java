package baek;

import java.util.*;

public class baek1966 {

	static int n, m, index;
	static Scanner scan = new Scanner(System.in);
	static PriorityQueue<Integer> prq = new PriorityQueue<Integer>();
	static PriorityQueue<Integer> reversePrq = new PriorityQueue<Integer>(100, Collections.reverseOrder());
	static Queue<Integer> queue = new LinkedList<Integer>();
	
	public static void getQueue(){
		int num;
		for(int i = 0; i < n; i++){
			num = scan.nextInt();
			if(i == m) index = num;
			queue.add(num);
			prq.add(num);
		}
		reversePrq.addAll(prq);
	}
	
	public static int FindDoc(){
		int count = 0;
		int rPeek, qPeek;
		
		while(!queue.isEmpty()){
			rPeek = reversePrq.peek();
			qPeek = queue.peek();
			if(rPeek == qPeek){
				reversePrq.poll();
				queue.poll();
				count++;
				if((rPeek == index) && (m == 0)) break;
				m--;
			}else{
				queue.add(queue.poll());
				if((m == 0) && (qPeek == index)) { m = queue.size()-1; }
				else { m--; }
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int T = scan.nextInt();
		
		for(int i = 0; i < T; i++){
			n = scan.nextInt(); 
			m = scan.nextInt();
			
			getQueue();
			System.out.println(FindDoc());
			
			prq.clear();
			reversePrq.clear();
			queue.clear();
		}
	}

}
