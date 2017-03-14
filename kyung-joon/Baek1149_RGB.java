import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by N on 2017-03-15.
 */
public class Baek1149_RGB {
    public static void main(String[] args) throws IOException {
        new Baek1149_RGB();
    }

    int N;
    int arr[][];

    Baek1149_RGB() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());
        arr = new int[N+1][3+1];
        for(int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][1] = Integer.valueOf(st.nextToken());
            arr[i][2] = Integer.valueOf(st.nextToken());
            arr[i][3] = Integer.valueOf(st.nextToken());
        }
        System.out.println(dp());
    }

    int dp() {
        for(int i=2; i<=N; i++) {
            arr[i][1] += Math.min(arr[i-1][2], arr[i-1][3]);
            arr[i][2] += Math.min(arr[i-1][1], arr[i-1][3]);
            arr[i][3] += Math.min(arr[i-1][1], arr[i-1][2]);
        }
        return Math.min(Math.min(arr[N][1], arr[N][2]), arr[N][3]);
    }

}