import java.util.Scanner;

class LongDe{
	int max;
	int l=0;
	
	public LongDe(int max) {
		this.max=max;
	}
	
	public void DFunc(int[] arr,int point,int num,int count){
		
		for(int i=num;i<max;i++) {			//point 다음 지점부터 point보다 작은 값 있는지 확인
			if(arr[i]-point<0) {			
				DFunc(arr,arr[i],i+1,count+1);		//있으면 그지점을 point로 바꾸고 재귀반복
			} 
		}
		
		if(l<count) {							    //가장 큰 부분수열을 저장
			l=count;
		}
	}
}

public class dp_11722 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		int[] arr=new int[num];
		LongDe ld=new LongDe(num);
		for(int i=0;i<num;i++) {
			arr[i]=sc.nextInt();
		}
		
		for(int j=0;j<num;j++) {				//부분배열의 시작 설정
			ld.DFunc(arr,arr[j],j+1,1);
		}
		System.out.println(ld.l);
	}
}