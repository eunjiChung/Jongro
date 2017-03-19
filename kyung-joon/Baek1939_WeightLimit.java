import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Created by N on 2017-03-19.
 */
public class Baek1939_WeightLimit {
    public static void main(String[] args) throws IOException {
        new Baek1939_WeightLimit();
    }

    private int N, M, startV, destV, outW;
    private int arr[][], visited[];
    Baek1939_WeightLimit() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());
        arr = new int[N+1][N+1];
        visited = new int[N+1];
        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.valueOf(st.nextToken());
            int n = Integer.valueOf(st.nextToken());
            arr[m][n] = arr[n][m] = Integer.valueOf(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        startV = Integer.valueOf(st.nextToken());
        destV = Integer.valueOf(st.nextToken());
        outW = 0;
        bfs();
        System.out.println(outW);
    }

    void bfs() {
        LinkedList<FactoryPath> list = new LinkedList<>();
        list.add(new FactoryPath(startV, Integer.MAX_VALUE));
        while(!list.isEmpty()) {
            FactoryPath cur = list.poll();
            if(visited[cur.v] > cur.minW) continue;
            else visited[cur.v] = cur.minW;
            if(cur.v == destV) {
                outW = Math.max(outW,cur.minW);
                continue;
            }
            for(int i=1; i<=N; i++) {
                if(arr[cur.v][i]!=0) {
                    int minW = Math.min(cur.minW,arr[cur.v][i]);
                    if(minW > visited[i]) list.add(new FactoryPath(i, minW));
                }
            }
        }
    }

    class FactoryPath {
        int v;
        int minW;
        FactoryPath(int v, int minW) {
            this.v = v; this.minW = minW;
        }
    }
}
