#include <stdio.h>

typedef struct _NODE {
	int key;
	struct _NODE *left, *right;
} NODE;

void printPostOrder(NODE *pRoot);
NODE *makeNode(int key);

void printPostOrder(NODE *pRoot) {

	if (pRoot != NULL) {
		printPostOrder(pRoot->left);
		printPostOrder(pRoot->right);
		printf(" %d ", pRoot->key);
	}
}

NODE *makeNode(int key) {

	NODE *node = malloc(sizeof(NODE));

	node->key = key;
	node->left = node->right = NULL;

	return node;
}

int insertNode(NODE **ppRoot, int key) {

	while (*ppRoot != NULL) {
		if (key == (*ppRoot)->key)
			return 0;

		if (key < (*ppRoot)->key)
			ppRoot = &(*ppRoot)->left;
		else
			ppRoot = &(*ppRoot)->right;
	}

	*ppRoot = makeNode(key);
	return 1;
}

int main(void) {
	NODE *pRoot = NULL;			//루트 노드 선언
	int arr[10000], check, i = 0;
	
	for (i = 0;; i++) {
		scanf_s("%d", &arr[i]);
		if (arr[i] < 1)
			break;
		insertNode(&pRoot, arr[i]);
	}
	printPostOrder(pRoot);

	scanf_s("%d");
	
	return 0;
}