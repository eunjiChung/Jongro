import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Created by N on 2017-03-19.
 */
public class Baek1939_WeightLimit_BinarySearch {
    public static void main(String[] args) throws IOException {
        new Baek1939_WeightLimit_BinarySearch();
    }

    private int N, M, startV, destV;
    private ArrayList<FactoryPath> list[];
    private int visited[];
    private boolean isFinished;

    Baek1939_WeightLimit_BinarySearch() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());
        list = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.valueOf(st.nextToken());
            int n = Integer.valueOf(st.nextToken());
            int w = Integer.valueOf(st.nextToken());
            list[m].add(new FactoryPath(n,w));
            list[n].add(new FactoryPath(m,w));
        }
        st = new StringTokenizer(br.readLine());
        startV = Integer.valueOf(st.nextToken());
        destV = Integer.valueOf(st.nextToken());

        int left=0, right=Integer.MAX_VALUE, mid, result=0;
        while(left<=right) {
            mid = (left+right)/2;
            visited = new int[N+1];
            isFinished = false;
            if(dfs(startV, mid)) {
                result=mid;
                left=mid+1;
            } else {
                right=mid-1;
            }
        }
        System.out.println(result);
    }

    boolean dfs(int vertex, int weight) {
        if(vertex==destV || isFinished) { // 성공경로 있으면 true
            isFinished = true;
            return true;
        }
        if(visited[vertex]==1) return false;
        visited[vertex]=1;
        for(int i=1; i<=list[vertex].size(); i++) {
            FactoryPath cur = list[vertex].get(i-1);
            if(visited[cur.v]==1) continue; // 방문한 적 있으면 통과
            if(weight <= cur.limit) { // weight가 간선의 limit 이하이면 진행
                if(dfs(cur.v, weight)) return true; // 성공경로 찾았으면 true
            }
        }
        return false; // 성공경로 없으면 false
    }

    class FactoryPath {
        int v;
        int limit;
        FactoryPath(int v, int limit) {
            this.v = v; this.limit = limit;
        }
    }
}