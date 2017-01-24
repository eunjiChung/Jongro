import java.io.*;
import java.util.*;

class Baek1987_Alphabet {
    public static void main(String[] s) throws IOException {
        new Baek1987_Alphabet();
    }
    
    int R, C, result=1;
    char[][] arr;
    Set<Character> set = new HashSet<>();
    
    Baek1987_Alphabet() throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        arr = new char[R+1][C+1];
        for(int i=1; i<=R; i++) {
        	String temp = br.readLine();
            for(int j=1; j<=C; j++) {
                arr[i][j] = temp.charAt(j-1);
            }
        }
        set.add(arr[1][1]);
        dfs(1,1);
        System.out.println(result);
    }
    
    void dfs(int m, int n) {
        result = Math.max(set.size(), result);
        if(m-1>=1 && !set.contains(arr[m-1][n])) {
            set.add(arr[m-1][n]);
            dfs(m-1,n);
            set.remove(arr[m-1][n]);
        }
        if(m+1<=R && !set.contains(arr[m+1][n])) {
            set.add(arr[m+1][n]);
            dfs(m+1,n);
            set.remove(arr[m+1][n]);
        }
        if(n-1>=1 && !set.contains(arr[m][n-1])) {
            set.add(arr[m][n-1]);
            dfs(m,n-1);
            set.remove(arr[m][n-1]);
        }
        if(n+1<=C && !set.contains(arr[m][n+1])) {
            set.add(arr[m][n+1]);
            dfs(m,n+1);
            set.remove(arr[m][n+1]);
        }
    }
}

