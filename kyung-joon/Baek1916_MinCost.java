import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baek1916_MinCost {
	public static void main(String[] args) throws Exception {
		new Baek1916_MinCost();
	}
	
	class Edge implements Comparable<Edge> {
		int v;
		int w;
		Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			return this.w > o.w ? 1 : -1; // ASC
		}
	}
	static final int INF = 0xfffffff; 
	int N,M;
	int[] path;
	int curVertex, destVertex;
	ArrayList<Edge>[] adjList;
	
	Baek1916_MinCost() throws Exception {
		//Scanner sc = new Scanner(System.in);
		FastScanner sc = new FastScanner();
		N = sc.nextInt();
		M = sc.nextInt();
		path = new int[N+1];
		adjList = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			path[i] = INF;
			adjList[i] = new ArrayList<>();
		}
		for(int i=1; i<=M; i++) {
			adjList[sc.nextInt()].add(new Edge(sc.nextInt(),sc.nextInt()));
		}
		curVertex = sc.nextInt();
		destVertex = sc.nextInt();
		//sc.close();
		dijkstra();
		System.out.println(path[destVertex]);
	}
	
	void dijkstra() {
		PriorityQueue<Edge> taskQ = new PriorityQueue<>();
		path[curVertex]=0;
		taskQ.add(new Edge(curVertex,path[curVertex]));
		
		while(!taskQ.isEmpty()) {
			curVertex = taskQ.poll().v;
			if(curVertex == destVertex) return;
			for(Edge curEdge : adjList[curVertex]) {
				int v = curEdge.v;
				int w = curEdge.w;
				if(path[curVertex]==INF || w==INF) continue;
				if(path[v] > path[curVertex]+w) {
					path[v] = path[curVertex]+w;
					taskQ.add(new Edge(v,path[v]));
				}
			}
		}
	}
	
	class FastScanner {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int nextInt() throws Exception {
            if (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(in.readLine());
            }
            return Integer.parseInt(st.nextToken());
        }
    }
}