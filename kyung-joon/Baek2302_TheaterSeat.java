import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by N on 2017-03-23.
 */
public class Baek2302_TheaterSeat {
    public static void main(String[] args) throws IOException {
        new Baek2302_TheaterSeat();
    }
    int N, M;
    int arr[], vip[];
    Baek2302_TheaterSeat() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());
        M = Integer.valueOf(br.readLine());
        arr = new int[N+1];
        vip = new int[N+1];
        for(int i=1; i<=M; i++) {
            vip[Integer.valueOf(br.readLine())] = 1;
        }
        vip[0]=1;
        arr[0]=1;
        for(int i=1; i<=N; i++) {
            arr[i] = arr[i-1];
            if(vip[i]!=1 && vip[i-1]!=1) {
                arr[i] += arr[i-2];
            }
        }
        System.out.println(arr[N]);
    }
}
