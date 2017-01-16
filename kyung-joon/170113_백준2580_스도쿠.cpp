#include <stdio.h>
#define MAX 9
int arr[MAX+1][MAX+1];
bool isFinished = false;

int dfs(int m, int n) {
	if(isFinished) return 0;
	if(n > MAX) { // 오른쪽 끝 넘어가면 다음줄로 
		m++;
		n=1;
	}
	if(m > MAX) { // 마지막 줄 넘어가면 끝까지 잘 왔다는 뜻 
		for(int i=1; i<=MAX; i++, printf("\n")) {
			for(int j=1; j<=MAX; j++) {
				printf("%1d ", arr[i][j]);
			}
		}
		isFinished=true;
		return 0;
	}
	if(arr[m][n]==0) {
		bool decision[MAX+1]={};
		for(int j=1; j<=9; j++) {
			decision[arr[m][j]]=true;
			decision[arr[j][n]]=true;
			decision[arr[((m-1)/3)*3 + (j-1)/3 + 1][((n-1)/3)*3 + (j-1)%3 + 1]]=true;
		}
		for(int i=1; i<=9; i++) {
			if(decision[i]==true) continue;
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
}
