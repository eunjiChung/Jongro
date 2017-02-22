import java.util.*;

/* 사용하는 클래스명이 Solution 이어야 하며, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해 볼 수 있습니다. */

class CodegroundSubarray {
    public static void main(String args[]) throws Exception	{
        Scanner sc = new Scanner(System.in);
        int T;
        int test_case;

        T = sc.nextInt();
        for(test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int S = sc.nextInt();
            int arr[] = new int[N+1];
            for(int i=1; i<=N; i++) {
                arr[i] = sc.nextInt();
            }

            int minLength=N+1;
            int index=1, sum=0;
            LinkedList<Integer> list = new LinkedList<>();
            while(index <= N || list.size()>0) {
                while(index <= N && sum < S) { //end부분 늘리기
                    list.add(arr[index++]);
                    sum+=list.peekLast();
                }
                if(sum >= S) minLength = Math.min(minLength, list.size());
                sum -= list.pollFirst();
            }

            if(minLength==N+1) minLength=0;
            System.out.println("#testcase" + test_case);
            System.out.println(minLength);

        }
    }
}