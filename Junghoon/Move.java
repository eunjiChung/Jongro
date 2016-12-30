import java.util.Scanner;

class MoveC {
	int max=0;   //먹은 캔디 최대값
	int candy=0; //먹은 사탕 누적갯수
	
	public int moveFunc(int[][] index,int i,int j) {
		candy+=index[i][j]; //자기자리 캔디먹기
		
		if(i+1<index.length) {  //재귀적으로 이동하면서 캔디를 먹는다.
			candy=moveFunc(index,i+1,j);
		} else if(j+1<index[0].length) {
			candy=moveFunc(index,i,j+1);
		} else if(i+1<index.length && j+1<index[0].length) {
			candy=moveFunc(index,i+1,j+1);
		}
		if(candy>max) {   // 현재 먹은 캔디가 max보다 크면
			max=candy;
			return max;   //max값에 저장하고 return;	  
		}
		return candy;
	}
}

public class Move {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MoveC movec=new MoveC();
		Scanner sc=new Scanner(System.in);
		int s=sc.nextInt();
		int c=sc.nextInt();
		
		int[][] index=new int[s][c];
		for(int i=0;i<s;i++) {
			for(int j=0;j<c;j++) {
				index[i][j]=sc.nextInt();
			}
		}
		int result=movec.moveFunc(index,0,0);
		System.out.println(result);
	}
}
