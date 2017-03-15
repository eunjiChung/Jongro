import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by N on 2017-03-15.
 */
public class Codeground_KimsWorld {
    public static void main(String[] args) throws IOException {
        new Codeground_KimsWorld();
    }

    int N,L;
    int adj[][], color[];
    boolean isFinished;
    int isColorMatched;

    static final int UNCOLORED = 0;
    static final int RED = 1;
    static final int BLACK = 2;

    Codeground_KimsWorld() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.valueOf(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            //값 입력 및 초기화
            isColorMatched = 1;
            isFinished = false;
            N = Integer.valueOf(br.readLine());
            L = Integer.valueOf(br.readLine());
            adj = new int[N+1][N+1];
            color = new int[N+1];
            for(int i=1; i<=L; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.valueOf(st.nextToken());
                int v = Integer.valueOf(st.nextToken());
                adj[u][v] = adj[v][u] = 1;
            }

            //알고리즘 수행부
            for(int i=1; i<=N; i++) {
                dfs(i);
            }

            //출력부
            System.out.println("Case #" + tc + "\n" + isColorMatched);
        }
    }

    void dfs(int m) {
        if(isFinished) return; //알고리즘종료 선언되어있으면 함수종료
        for(int i=1; i<=N; i++) {
            if (adj[m][i] != 0) {
                if (color[m] == UNCOLORED) color[m] = RED;
                switch (color[i]) {
                    case RED:
                        if (color[m] == RED) { // 다음노드가 이전노드와 같은색이면 알고리즘종료
                            isColorMatched = 0;
                            isFinished = true;
                            return;
                        }
                        break;
                    case BLACK:
                        if (color[m] == BLACK) {
                            isColorMatched = 0;
                            isFinished = true;
                            return;
                        }
                        break;
                    case UNCOLORED:
                        if (color[m] == RED) color[i] = BLACK;
                        else if (color[m] == BLACK) color[i] = RED;
                        dfs(i);
                        break;
                }
            }
        }
    }
}
