import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by N on 2017-03-22.
 */
public class Baek12100_Samsung2048 {
    public static void main(String[] args) throws IOException {
        new Baek12100_Samsung2048();
    }

    int N, outValue;
    final int RIGHT = 1;
    final int DOWN = 2;
    final int LEFT = 3;
    final int UP = 4;

    Baek12100_Samsung2048() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());
        outValue=0;
        int arr[][] = new int[N+1][N+1];
        for(int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                arr[i][j] = Integer.valueOf(st.nextToken());
                if(outValue < arr[i][j]) outValue = arr[i][j];
            }
        }
        // 백트래킹 수행
        dfs(arr, 0, 0);
        System.out.println(outValue);
    }

    void dfs(int arr[][], int depth, int order) throws IOException {
        if(depth>5) return;

        switch(order) {
            case RIGHT:
                for(int i=1; i<=N; i++) {
                    //빈칸채우기
                    for (int j=N; j>=2; j--) {
                        if (arr[i][j] == 0) {
                            int k=j-1;
                            while (k>=2 && arr[i][k] == 0) k--;
                            arr[i][j] = arr[i][k];
                            arr[i][k] = 0;
                        }
                    }
                    //합치기
                    for(int j=N; j>=2; j--) {
                        if(arr[i][j] != 0 && arr[i][j] == arr[i][j-1]) {
                            arr[i][j] *= 2;
                            arr[i][j-1] = 0;
                            if(outValue < arr[i][j]) outValue = arr[i][j];
                            j--;
                        }
                    }
                    //빈칸채우기
                    for (int j=N; j>=2; j--) {
                        if (arr[i][j] == 0) {
                            int k=j-1;
                            while (k>=2 && arr[i][k] == 0) k--;
                            arr[i][j] = arr[i][k];
                            arr[i][k] = 0;
                        }
                    }
                }
                break;

            case LEFT:
                for(int i=1; i<=N; i++) {
                    //빈칸채우기
                    for (int j=1; j<=N-1; j++) {
                        if (arr[i][j] == 0) {
                            int k=j+1;
                            while (k<=N-1 && arr[i][k]==0) k++;
                            arr[i][j] = arr[i][k];
                            arr[i][k] = 0;
                        }
                    }
                    //합치기
                    for(int j=1; j<=N-1; j++) {
                        if(arr[i][j] != 0 && arr[i][j] == arr[i][j+1]) {
                            arr[i][j] *= 2;
                            arr[i][j+1] = 0;
                            if(outValue < arr[i][j]) outValue = arr[i][j];
                            j++;
                        }
                    }
                    //빈칸채우기
                    for (int j=1; j<=N-1; j++) {
                        if (arr[i][j] == 0) {
                            int k=j+1;
                            while (k<=N-1 && arr[i][k]==0) k++;
                            arr[i][j] = arr[i][k];
                            arr[i][k] = 0;
                        }
                    }
                }
                break;

            case DOWN:
                for(int j=1; j<=N; j++) {
                    //빈칸채우기
                    for (int i=N; i>=2; i--) {
                        if (arr[i][j] == 0) {
                            int k = i-1;
                            while (k >= 2 && arr[k][j] == 0) k--;
                            arr[i][j] = arr[k][j];
                            arr[k][j] = 0;
                        }
                    }
                    //합치기
                    for(int i=N; i>=2; i--) {
                        if(arr[i][j] != 0 && arr[i][j] == arr[i-1][j]) {
                            arr[i][j] *= 2;
                            arr[i-1][j] = 0;
                            if(outValue < arr[i][j]) outValue = arr[i][j];
                            i--;
                        }
                    }
                    //빈칸채우기
                    for (int i=N; i>=2; i--) {
                        if (arr[i][j] == 0) {
                            int k = i-1;
                            while (k >= 2 && arr[k][j] == 0) k--;
                            arr[i][j] = arr[k][j];
                            arr[k][j] = 0;
                        }
                    }
                }
                break;

            case UP:
                for(int j=1; j<=N; j++) {
                    //빈칸채우기
                    for (int i=1; i<=N-1; i++) {
                        if (arr[i][j] == 0) {
                            int k = i+1;
                            while (k<=N-1 && arr[k][j]==0) k++;
                            arr[i][j] = arr[k][j];
                            arr[k][j] = 0;
                        }
                    }
                    //합치기
                    for(int i=1; i<=N-1; i++) {
                        if(arr[i][j] != 0 && arr[i][j] == arr[i+1][j]) {
                            arr[i][j] *= 2;
                            arr[i+1][j] = 0;
                            if(outValue < arr[i][j]) outValue = arr[i][j];
                            i++;
                        }
                    }
                    //빈칸채우기
                    for (int i=1; i<=N-1; i++) {
                        if (arr[i][j] == 0) {
                            int k = i+1;
                            while (k<=N-1 && arr[k][j]==0) k++;
                            arr[i][j] = arr[k][j];
                            arr[k][j] = 0;
                        }
                    }
                }
                break;
        }
        /*
        printArr(arr, depth, order);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dfs(arr, depth + 1, Integer.valueOf(br.readLine()));
        */
        boolean doWidth=false, doHeight=false;
        int a[][] = new int[N+1][N+1];
        int b[][] = new int[N+1][N+1];
        int c[][] = new int[N+1][N+1];
        int d[][] = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                a[i][j] = b[i][j] = c[i][j] = d[i][j] = arr[i][j];
            }
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N-1; j++) {
                if(arr[i][j]!=0 && arr[i][j]==arr[i][j+1]) {
                    doWidth = true;
                    break;
                }
            }
        }
        for (int j = 1; j <= N; j++) {
            for (int i = 1; i <= N-1; i++) {
                if(arr[i][j]!=0 && arr[i][j]==arr[i+1][j]) {
                    doHeight = true;
                    break;
                }
            }
        }
        if(doWidth || order!=RIGHT) dfs(a, depth + 1, RIGHT);
        if(doWidth || order!=LEFT) dfs(b, depth + 1, LEFT);
        if(doHeight || order!=UP) dfs(c, depth + 1, UP);
        if(doHeight || order!=DOWN) dfs(d, depth + 1, DOWN);
        /**/
    }

    void printArr(int arr[][], int depth, int order) {
        String orderString="";
        switch(order) {
            case RIGHT: orderString = "RIGHT"; break;
            case LEFT: orderString = "LEFT"; break;
            case UP: orderString = "UP"; break;
            case DOWN: orderString = "DOWN"; break;
        }
        System.out.println(depth+", "+orderString);
        for (int i=1; i<=N; i++, System.out.println()) {
            for (int j=1; j<=N; j++) {
                System.out.print(arr[i][j]+" ");
            }
        }
        System.out.println();
    }
}
