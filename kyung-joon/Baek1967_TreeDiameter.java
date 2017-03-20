import java.util.*;
import java.io.*;

public class Baek1967_TreeDiameter {
	public static void main(String[] args) throws IOException {
		new Baek1967_TreeDiameter();
	}
	
	int N, diameter;
	int visited[];
	LinkedList<Node> list[];
	Baek1967_TreeDiameter() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.valueOf(br.readLine());
		list = new LinkedList[N+1];
		for(int i=1; i<=N; i++) {
			list[i] = new LinkedList<>();
		}
		
		for(int i=1; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.valueOf(st.nextToken());
			int v = Integer.valueOf(st.nextToken());
			int w = Integer.valueOf(st.nextToken());
			list[u].add(new Node(v,w));
			list[v].add(new Node(u,w));
		}
	
		
		diameter=bfs(bfs(1).v).w;
		System.out.println(diameter);
	}
	
	Node bfs(int v) {
		LinkedList<Node> q = new LinkedList<>();
		Node outNode = new Node(v,0);
		visited = new int[N+1];
		visited[outNode.v]=1;
		q.add(outNode);
		while(!q.isEmpty()) {
			Node cur = q.poll();
			if(outNode.w < cur.w) {
				outNode = cur;
			}
			visited[cur.v]=1;
			for(int i=1; i<=list[cur.v].size(); i++) {
				Node adj = list[cur.v].get(i-1);
				if(visited[adj.v]==0) {
					q.add(new Node(adj.v, cur.w+adj.w));
				}
			}
		}
		return outNode;
	}
	
	class Node {
		int v;
		int w;
		Node(int v, int w) {
			this.v = v; this.w = w;
		}
	}
}
