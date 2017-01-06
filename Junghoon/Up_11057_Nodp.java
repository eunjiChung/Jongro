/*
 * dp로 말고 그냥 푼거
 */

import java.util.Scanner;

class Up {
	public int upFunc(int num) {
		int count=0;
		int one_Count=10;						//1의자리수 결과는 그냥 변수로 저장
		for(Integer i=1;i<Math.pow(10,num);i++) {  // num이 지수인수 전까지
			String temp=i.toString();			   // String값으로 변경해서
			for(int j=0;j<temp.length()-1;j++) {   // 다음 자리숫자랑 비교	
				if(temp.charAt(j)>temp.charAt(j+1)) {	//앞자리가 크면 break;
					break;
				} else if(j==temp.length()-2) {         //제일 끝자리까지 비교가 끝났으면 카운트
					count++;
				}
			}
		}
		return count+one_Count;
	}
}


public class Up_11057_Nodp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Up u=new Up();
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		int result=u.upFunc(num);
		System.out.println(result);
	}
}
