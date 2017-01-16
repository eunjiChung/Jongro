import java.util.*;

class TreeNode {
	int data;
	int level;
	TreeNode parent;
	ArrayList<TreeNode> childs;
	TreeNode(int data, int level, TreeNode parent) {
		this.data = data;
		this.level = level;
		this.parent = parent;
	}
}

class TreeLCA {
	TreeNode root;
	TreeLCA() {
		root = new TreeNode(1,1,null);
	}
	
	void setEdge(int a, int b) {
		TreeNode parent = preOrder(root, a);
		if(parent.childs==null) parent.childs = new ArrayList<>();
		parent.childs.add(new TreeNode(b,parent.level+1,parent));
	}
	
	TreeNode preOrder(TreeNode findNode, int dataToFind) {
		if(findNode.data == dataToFind) return findNode;
		else {
			if(findNode.childs==null) return null;
			for(TreeNode child : findNode.childs) {
				TreeNode temp = preOrder(child, dataToFind);
				if(temp != null) return temp;
			}
			return null;
		}
	}
	
	TreeNode findLCA(int a, int b) {
		TreeNode tempA = preOrder(root,a);
		TreeNode tempB = preOrder(root,b);
		while(tempA.level != tempB.level) {
			if(tempA.level > tempB.level) tempA = tempA.parent;
			else tempB = tempB.parent;
		}
		while(tempA.data != tempB.data) {
			tempA = tempA.parent;
			tempB = tempB.parent;
		}
		return tempA;
	}
}

public class Baek11437_LCA {
	
	Baek11437_LCA() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		TreeLCA tree = new TreeLCA();
		
		for(int i=1; i<=N-1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(tree.preOrder(tree.root, b) == null) {
				tree.setEdge(a,b);
			} else {
				tree.setEdge(b,a);
			}
		}
		
		int M = sc.nextInt();
		for(int i=1; i<=M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(tree.findLCA(a,b).data);
		}
		sc.close();		
	}
	
	
	public static void main(String[] argc) {
		new Baek11437_LCA();
	}
}

/*

import java.util.*;

class TreeLCA {
	private int arr[][];
	private int level[];
	
	TreeLCA(int size) {
		arr = new int[size+1][size+1];
		level = new int[size+1];
		level[1]=1;
	}
	
	void connect(int a, int b) {
		if(level[a]!=0) { // a가 부모노드
			level[b]=level[a]+1;
			arr[a][b]=1;
			arr[b][a]=-1;
		} else { // b가 부모노드
			level[a]=level[b]+1;
			arr[b][a]=1;
			arr[a][b]=-1;
		}
	}
	
	int findLCA(int a, int b) {
		while(level[a] != level[b]) {
			if(level[a] > level[b]) {
				for(int i=1; i<arr.length; i++) {
					if(arr[a][i] == -1) {
						a=i;
						break;
					}
				}
			} else {
				for(int i=1; i<arr.length; i++) {
					if(arr[b][i] == -1) {
						b=i;
						break;
					}
				}
			}
		}
		while(a!=b) {
			for(int i=1; i<arr.length; i++) {
				if(arr[a][i] == -1) {
					a=i;
					break;
				}
			}
			for(int i=1; i<arr.length; i++) {
				if(arr[b][i] == -1) {
					b=i;
					break;
				}
			}
		}
		return a;
	}
}

public class Baek11437_LCA {
	
	Baek11437_LCA() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		TreeLCA tree = new TreeLCA(N);
		
		for(int i=1; i<=N-1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			tree.connect(a,b);
		}
		
		int M = sc.nextInt();
		for(int i=1; i<=M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(tree.findLCA(a,b));
		}
		sc.close();		
	}
	
	
	public static void main(String[] argc) {
		new Baek11437_LCA();
	}
}
*/