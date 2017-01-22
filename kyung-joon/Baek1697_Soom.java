import java.util.*;

class Baek1697_Soom {
    public static void main(String[] args) {
        new Baek1697_Soom();
    }
    
    static final int MAX = 100000;
    boolean[] visited = new boolean[100000+1];
    int N, K, result;
    
    class TaskNode {
        int num;
        int depth;
        TaskNode(int num, int depth) {
            this.num = num;
            this.depth = depth;
        }
    }
    
    Baek1697_Soom() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        
        bfs();
        //if(K>N) result = K-N; else result = N-K;
        //dfs(N,0);
        System.out.println(result);
    }

    void bfs() {
        Queue<TaskNode> q = new LinkedList<>();
        q.add(new TaskNode(N, 0));

        while(!q.isEmpty()) {
            TaskNode temp = q.poll();
            if(temp.depth >= result || visited[temp.num]) {
                continue;
            }
            if(temp.num == K) {
                result = temp.depth;
                return;
            }
            
            visited[temp.num] = true;
            if(temp.num < K && temp.num*2<=MAX && !visited[temp.num*2]) {
                q.add(new TaskNode(temp.num*2, temp.depth+1));
            }
            if(temp.num < K && !visited[temp.num+1]) {
                q.add(new TaskNode(temp.num+1, temp.depth+1));
            }
            if(temp.num > 0 && !visited[temp.num-1]) {
                q.add(new TaskNode(temp.num-1, temp.depth+1));
            }       
        }
    }
    
    //시간초과
    void dfs(int num, int depth) {
        if(depth >= result) return;
        if(num == K) {
            result = depth;
            return;
        }
        
        visited[num]=true;
        if(num < K && 2*num<=MAX && visited[2*num]!=true) {
            dfs(2*num,depth+1);
        }
        if(num < K && visited[num+1]!=true) {
            dfs(num+1,depth+1);
        }
        if(visited[num-1]!=true) {
            dfs(num-1,depth+1);
        }
        visited[num]=false;
    }
}