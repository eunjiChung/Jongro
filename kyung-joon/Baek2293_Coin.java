import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by N on 2017-03-18.
 */
public class Baek2293_Coin {
    public static void main(String[] args) throws IOException {
        new Baek2293_Coin();
    }

    int N,K;
    int arr[];
    int arrInput[];
    Baek2293_Coin() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        K = Integer.valueOf(st.nextToken());
        arrInput = new int[N+1];
        arr = new int[K+1];
        for(int i=1; i<=N; i++) {
            arrInput[i]=Integer.valueOf(br.readLine());
        }
        System.out.println(dp());
    }

    int dp() {
        arr[0]=1;
        for(int j=1; j<=N; j++) {
            for(int i=1; i<=K; i++) {
                if(i-arrInput[j] < 0) continue;
                arr[i] += arr[i-arrInput[j]];
            }
        }
        return arr[K];
    }
}
