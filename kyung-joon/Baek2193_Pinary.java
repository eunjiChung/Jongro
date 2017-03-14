import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by N on 2017-03-15.
 */
public class Baek2193_Pinary {
    public static void main(String[] args) throws IOException {
        new Baek2193_Pinary();
    }

    int N;
    long arr[][];

    Baek2193_Pinary() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());
        arr = new long[N+1][2];
        System.out.println(dp());
    }

    long dp() {
        arr[1][1]=1;
        for(int i=2; i<=N; i++) {
            arr[i][0] = arr[i-1][0] + arr[i-1][1];
            arr[i][1] = arr[i-1][0];
        }
        return arr[N][0]+arr[N][1];
    }
}
