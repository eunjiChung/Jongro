import java.util.*;

class BaekBSTNode {
	int data;
	BaekBSTNode left;
	BaekBSTNode right;
	BaekBSTNode(int data) {
		this.data=data;
	}
}

class BaekBST {
	BaekBSTNode root;
	
	void Insert(int data) {
		BaekBSTNode newNode = new BaekBSTNode(data);
		if(root==null) root = newNode;
		else {
			BaekBSTNode temp = root;
			while(temp!=null) {
				if(newNode.data < temp.data) {
					if(temp.left==null) {
						temp.left = newNode;
						break;
					}
					temp = temp.left;
				} else {
					if(temp.right==null) {
						temp.right = newNode;
						break;
					}
					temp = temp.right;
				}
			}
		}
	}
	
	void printPostOrder(BaekBSTNode node) {
		if(node.left!=null) printPostOrder(node.left);
		if(node.right!=null) printPostOrder(node.right);
		System.out.println(node.data);
	}
	
}


public class Baek5639_BST {
	
	Baek5639_BST() {
		Scanner sc = new Scanner(System.in);
		BaekBST bst = new BaekBST();
		
		while(sc.hasNextLine()) {
			bst.Insert(Integer.parseInt(sc.nextLine()));
		}
		bst.printPostOrder(bst.root);	
		sc.close();
	}
	
	public static void main(String[] args) {
		new Baek5639_BST();
	}
}


