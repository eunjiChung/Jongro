import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek2250_TreeWidth {
	public static void main(String args[]) throws IOException {
		new Baek2250_TreeWidth();
	}
	
	int N;
	int x, maxLevel, root=1;
	int width[][];
	Node adj[];
	Baek2250_TreeWidth() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.valueOf(br.readLine().trim());
		adj = new Node[N+1];
		for(int i=1; i<=N; i++) { adj[i] = new Node(); }
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.valueOf(st.nextToken());
			int left = Integer.valueOf(st.nextToken());
			int right = Integer.valueOf(st.nextToken());
			adj[u].left = left;
			adj[u].right = right;
			if(left!=-1) adj[left].parent = u;
			if(right!=-1) adj[right].parent = u;
		}
		x=maxLevel=1;
		
		while(adj[root].parent!=-1) {
			root = adj[root].parent;
		}
		inOrder(root,1);
		
		int outLevel=0, outWidth=0;
		width = new int[maxLevel+1][2];
		for(int i=1; i<=maxLevel; i++) { width[i][0] = Integer.MAX_VALUE; }
		for(int i=1; i<=N; i++) {
			int x = adj[i].x;
			int y = adj[i].y;
			width[y][0] = Math.min(width[y][0], x);
			width[y][1] = Math.max(width[y][1], x);
		}
		for(int i=1; i<=maxLevel; i++) {
			int curWidth = width[i][1]-width[i][0]+1;
			if(outWidth < curWidth) {
				outWidth = curWidth;
				outLevel = i;
			}
		}
		System.out.println(outLevel+" "+outWidth);
	}
	
	void inOrder(int v, int y) {
		if(adj[v].left!=-1) inOrder(adj[v].left, y+1);
		adj[v].x = x++;
		adj[v].y = y;
		maxLevel = Math.max(maxLevel, y);
		if(adj[v].right!=-1) inOrder(adj[v].right, y+1);
	}
	
	class Node {
		int parent, left, right;
		int x,y;
		Node() {
			this.parent=-1;
		}
	}
}
