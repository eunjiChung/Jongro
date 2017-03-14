import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by N on 2017-03-15.
 */
public class Baek2156_Wine {
    public static void main(String[] args) throws IOException {
        new Baek2156_Wine();
    }

    int N;
    int arr[], dp[];

    Baek2156_Wine() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());
        arr = new int[N+1];
        for(int i=1; i<=N; i++) {
            arr[i] = Integer.valueOf(br.readLine());
        }
        System.out.println(dp());
    }

    int dp() {
        dp = new int[N+1];
        dp[1] = arr[1];
        if(N>=2) dp[2] = arr[1]+arr[2];
        for(int i=3; i<=N; i++) {
            dp[i] = Math.max(Math.max(dp[i-2]+arr[i], dp[i-3]+arr[i-1]+arr[i]), dp[i-1]);
        }
        return dp[N];
    }
}
