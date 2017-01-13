#include <iostream>
#define MAX 9
using namespace std;
int arr[MAX+1][MAX+1];
int arr2[MAX+1][MAX+1];

int dfs(int m, int n) {
	if(n > MAX) { // 오른쪽 끝 넘어가면 다음줄로 
		m++;
		n=1;
	}
	if(m > MAX) { // 마지막 줄 넘어가면 끝까지 잘 왔다는 뜻 
		for(int i=1; i<=9; i++) {
			for(int j=1; j<=9; j++) {
				arr2[i][j] = arr[i][j];
			}
		}
		return 0;
	}
	if(arr[m][n]==0) {
		int decision[MAX+1];
		for(int j=1; j<=9; j++) {
			decision[j]=0;
		}
		for(int j=1; j<=9; j++) {
			decision[arr[m][j]]=1;
			decision[arr[j][n]]=1;
			decision[arr[((m-1)/3)*3 + (j-1)/3 + 1][((n-1)/3)*3 + (j-1)%3 + 1]]=1;
		}
		for(int i=1; i<=9; i++) {
			if(decision[i]==1) continue;
			arr[m][n] = i;
			dfs(m, n+1);
			arr[m][n] = 0;
		}
	} else {
		dfs(m, n+1);
	}
}

int main() {
	for(int i=1; i<=MAX; i++) {
		for(int j=1; j<=MAX; j++) {
			scanf("%1d",&arr[i][j]);
		}
	}
	dfs(1,1);
	for(int i=1; i<=MAX; i++) {
		for(int j=1; j<=MAX; j++) {
			printf("%1d ",arr2[i][j]);
		}
		printf("\n");
	}
}
