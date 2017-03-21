import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by N on 2017-03-22.
 */
public class Baek13458_SamsungAdmin {
    public static void main(String[] args) throws IOException {
        new Baek13458_SamsungAdmin();
    }

    int N, B, C;
    int arr[];
    Baek13458_SamsungAdmin() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());
        arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        B = Integer.valueOf(st.nextToken());
        C = Integer.valueOf(st.nextToken());
        long outValue = 0;
        for (int i = 1; i <= N; i++) {
            outValue++;
            arr[i] -= B;
        }
        for (int i = 1; i <= N; i++) {
            if(arr[i]<=0) continue;
            if(arr[i]%C==0) outValue += arr[i]/C;
            else outValue += arr[i]/C + 1;
        }
        System.out.println(outValue);
    }
}
