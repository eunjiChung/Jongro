import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Administrator on 2017-02-24.
 */

public class Baek1003_Fibonacci {
    public static void main(String[] args) throws IOException {
        new Baek1003_Fibonacci();
    }
    Baek1003_Fibonacci() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.valueOf(br.readLine());
        arr[0] = new int[]{1,0};
        arr[1] = new int[]{0,1};
        for(int test=1; test<=testCase; test++) {
            int N = Integer.valueOf(br.readLine());
            int[] out = fibonacci(N);
            System.out.println(out[0]+" "+out[1]);
        }
    }

    int arr[][] = new int[41][];

    int[] fibonacci(int n) {
        if(n==0) return arr[0];
        else if(n==1) return arr[1];
        else if(arr[n]!=null) return arr[n];
        else {
            if(arr[n-1]==null) arr[n-1] = fibonacci(n-1);
            if(arr[n-2]==null) arr[n-2] = fibonacci(n-2);
            arr[n] = new int[]{
                    arr[n-1][0] + arr[n-2][0],
                    arr[n-1][1] + arr[n-2][1]
            };
            return arr[n];
        }
    }
}
