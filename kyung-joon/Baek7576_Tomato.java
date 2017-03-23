import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Created by N on 2017-03-23.
 */
public class Baek7576_Tomato {
    public static void main(String[] args) throws IOException {
        new Baek7576_Tomato();
    }

    int M, N, maxDepth;
    int arr[][];
    Baek7576_Tomato() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.valueOf(st.nextToken());
        N = Integer.valueOf(st.nextToken());
        arr = new int[N+1][M+1];
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++) {
                arr[i][j] = Integer.valueOf(st.nextToken());
            }
        }
        bfs();
        for(int i=1; i<=N; i++) {
            for (int j = 1; j <= M; j++) {
                if(arr[i][j]==0) {
                    maxDepth=-1;
                    break;
                }
            }
        }
        System.out.println(maxDepth);
    }

    void bfs() {
        LinkedList<Point> list = new LinkedList<>();
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                if(arr[i][j]==1) list.offer(new Point(i,j,0));
            }
        }
        maxDepth=0;
        while(!list.isEmpty()) {
            Point point = list.poll();
            int m = point.m;
            int n = point.n;
            int depth = point.depth;
            //printArr();
            if(maxDepth<depth) maxDepth=depth;
            if(m+1<=N && arr[m+1][n]==0) {
                arr[m+1][n]=1;
                list.offer(new Point(m+1,n,depth+1));
            }
            if(n+1<=M && arr[m][n+1]==0) {
                arr[m][n+1]=1;
                list.offer(new Point(m,n+1,depth+1));
            }
            if(m-1>=1 && arr[m-1][n]==0) {
                arr[m-1][n]=1;
                list.offer(new Point(m-1,n,depth+1));
            }
            if(n-1>=1 && arr[m][n-1]==0) {
                arr[m][n-1]=1;
                list.offer(new Point(m,n-1,depth+1));
            }
        }
    }

    void printArr() {
        for (int i = 1; i <= N; i++, System.out.println()) {
            for (int j = 1; j <= M; j++) {
                System.out.print(arr[i][j]+" ");
            }
        }
        System.out.println();
    }

    class Point {
        int m, n, depth;
        Point(int m, int n, int depth) { this.m = m; this.n = n; this.depth = depth; }
    }
}