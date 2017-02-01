import java.util.*;

class Baek1753_Shortest {
    public static void main(String[] args) {
        new Baek1753_Shortest();
    }
    
    class Node implements Comparable<Node> {
    	int vertex;
    	int weight;
    	Node(int vertex, int weight) {
    		this.vertex = vertex;
    		this.weight = weight;
    	}
		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight; //ASC
		}
    }

    static final int INF = 200001; // static final int INF = 0xfffffff;
    int V, E, curVertex;
    ArrayList<Node>[] adj;
    int[] path;
    
    Baek1753_Shortest() {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();
        curVertex = sc.nextInt();
        sc.nextLine();
        
        adj = new ArrayList[V+1];
        path = new int[V+1];
        for(int i=1; i<=V; i++) {
        	adj[i] = new ArrayList<Node>();
        	path[i] = INF; 
        }
        
        for(int i=0; i<E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            adj[u].add(new Node(v,w));
        }
        sc.close();
        dijkstra();
        
        for(int i=1; i<=V; i++) {
        	System.out.println(path[i]!=INF ? path[i] : "INF");
    	}
    }
    
    void dijkstra() {
    	PriorityQueue<Integer> taskQueue = new PriorityQueue<>();
    	path[curVertex]=0;
    	taskQueue.add(curVertex);
    	
    	while(!taskQueue.isEmpty()) {
    		curVertex = taskQueue.poll();
    		for(Node adjNode : adj[curVertex]) {
    			int adjVertex = adjNode.vertex;
    			int adjWeight = adjNode.weight;
    			//if(path[K]==INF || adjWeight==INF) continue;
    			if(path[adjVertex] > path[curVertex]+adjWeight) {
    				path[adjVertex] = path[curVertex]+adjWeight;
    				taskQueue.add(adjVertex);
    			}
    		}
    	}
    }
}