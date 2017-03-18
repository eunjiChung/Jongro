import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by N on 2017-03-18.
 */
public class Baek2294_Coin2 {
    public static void main(String[] args) throws IOException {
        new Baek2294_Coin2();
    }

    int N,K;
    int arr[];
    int arrInput[];
    Baek2294_Coin2() throws IOException {
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
        for(int i=1; i<=K; i++) {
            for(int j=1; j<=N; j++) {
                if(i-arrInput[j] < 0) continue;
                if(i-arrInput[j] == 0) {
                    arr[i] = 1;
                    continue;
                }
                if(arr[i]==0) {
                    arr[i] = arr[i-arrInput[j]]+1;
                } else {
                    arr[i] = Math.min(arr[i], arr[i-arrInput[j]]+1);
                }
            }
        }
        return arr[K]!=0 ? arr[K] : -1;
    }
}