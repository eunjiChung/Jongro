package baek;

import java.util.*;

public class baek5639 {
	
	static Scanner scan = new Scanner(System.in);
	static LinkedList<Long> list = new LinkedList<Long>();
	
	public static void changePreToPost(int start, int end){
		long root = list.get(start);
		list.remove(start); list.add(end, root);
		//System.out.println(list.toString());
		
		for(int i = start; i < end; i++){
			long num = list.get(i);
			//System.out.println(i + " " + root + " " + num); 
			if(root < num){
				changePreToPost(start, i-1);
				changePreToPost(i, end-1);
				break;
			}else if(end-1 == i){
				changePreToPost(start, end-1);
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		String str = null; 
		
		while(scan.hasNextLine()){
			str = scan.nextLine();
			if(str.equals("")) break;
			list.add(Long.parseLong(str));
		}
		changePreToPost(0, list.size()-1);
		System.out.println(list.toString());
	}

}
