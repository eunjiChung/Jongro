#include <iostream>
#include <set>
using namespace std;

int arr[5+1][5+1];
set<int> result_set;

void dfs(int m, int n, int depth, int result) {
	if(depth>5) {
		result_set.insert(result);
		return;
	}
	result = result*10 + arr[m][n];
	if(m<5) dfs(m+1,n,depth+1, result);
	if(m>1) dfs(m-1,n,depth+1, result);
	if(n<5) dfs(m,n+1,depth+1, result);
	if(n>1) dfs(m,n-1,depth+1, result);
}

int main() {
	for(int i=1; i<=5; i++) {
		for(int j=1; j<=5; j++) {
			cin >> arr[i][j];
		}
	}
	for(int i=1; i<=5; i++) {
		for(int j=1; j<=5; j++) {
			dfs(i,j,0,0);
		}
	}
	
	cout << result_set.size();
}

/*
#include <iostream>
using namespace std;

class Node {
	public:
	int data;
	Node *left;
	Node *right;
	Node(int data) {
		this->data = data;
		left=NULL;
		right=NULL;
	}
};

class BST {
	public:
	Node *root;
	int nodeCount;
	BST() {
		root=NULL;
		nodeCount=0;
	}
	void Insert(int data) {
		Node *newNode = new Node(data);
		Node *tmpNode = root;
		if(root==NULL) {
			root=newNode;
			nodeCount++;
		} else {
			while(true) {
				if(newNode->data < tmpNode->data) {
					if(tmpNode->left!=NULL) tmpNode=tmpNode->left;
					else {
						tmpNode->left=newNode;
						nodeCount++;
						break;
					}
				} else if(tmpNode->data < newNode->data) {
					if(tmpNode->right!=NULL) tmpNode=tmpNode->right;
					else {
						tmpNode->right=newNode;
						nodeCount++;
						break;
					}
				} else {
					delete newNode;
					break;
				}
			}
		}
	}
	void printInorder(Node *node) {
		if(node!=NULL) {
			printInorder(node->left);
			cout << node->data << "\n";
			printInorder(node->right);
		}
	}
};

int arr[5+1][5+1];
BST *bst;

void dfs(int m, int n, int depth, int result) {
	if(depth>5) {
		bst->Insert(result);
		return;
	}
	result = result*10 + arr[m][n];
	if(m<5) dfs(m+1,n,depth+1, result);
	if(m>1) dfs(m-1,n,depth+1, result);
	if(n<5) dfs(m,n+1,depth+1, result);
	if(n>1) dfs(m,n-1,depth+1, result);
}

int main() {
	bst = new BST();
	for(int i=1; i<=5; i++) {
		for(int j=1; j<=5; j++) {
			cin >> arr[i][j];
		}
	}
	for(int i=1; i<=5; i++) {
		for(int j=1; j<=5; j++) {
			dfs(i,j,0,0);
		}
	}
	
	cout << bst->nodeCount;
	//bst->printInorder(bst->root);
}
*/
