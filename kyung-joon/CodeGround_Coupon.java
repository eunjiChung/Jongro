import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by N on 2017-03-15.
 */
public class CodeGround_Coupon {
    public static void main(String args[]) throws Exception	{
        new CodeGround_Coupon();
    }

    int N, M, K, P, outCount;
    int arr[][];
    int cost[];
    PriorityQueue<Cost> pq;

    CodeGround_Coupon() throws IOException {
        //Scanner sc = new Scanner(new FileInputStream("sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.valueOf(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.valueOf(st.nextToken());
            M = Integer.valueOf(st.nextToken());
            K = Integer.valueOf(st.nextToken());
            arr = new int[N+1][N+1];
            outCount = 0;

            for(int i=1; i<=M; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.valueOf(st.nextToken());
                int v = Integer.valueOf(st.nextToken());
                int w = Integer.valueOf(st.nextToken());
                arr[u][v] = arr[v][u] = w;
            }

            P = Integer.valueOf(br.readLine());
            for(int i=1; i<=P; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.valueOf(st.nextToken());
                int v = Integer.valueOf(st.nextToken());
                dijkstra(u);
                if(cost[v] > K) outCount++;
            }
            System.out.println("Case #" + test_case);
            System.out.println(outCount);
        }
    }

    void dijkstra(int u) {
        cost = new int[N+1];
        pq = new PriorityQueue<>();
        for(int i=1; i<=N; i++) {
            cost[i] = Integer.MAX_VALUE;
        }

        cost[u]=0;
        pq.add(new Cost(u,cost[u]));
        while(!pq.isEmpty()) {
            int curIndex = pq.peek().index;
            int curCost = pq.peek().cost;
            pq.poll();
            if(curCost > cost[curIndex]) continue;
            for(int i=1; i<=N; i++) {
                if(arr[curIndex][i]!=0 && cost[curIndex]+arr[curIndex][i] <= cost[i]) {
                    cost[i] = cost[curIndex] + arr[curIndex][i];
                    pq.add(new Cost(i,cost[i]));
                }
            }
        }
    }

    class Cost implements Comparable<Cost> {
        int index;
        int cost;
        Cost(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
        @Override
        public int compareTo(Cost o) {
            return this.cost - o.cost;
        }
    }
}
