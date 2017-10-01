#include <stdio.h>
#define MAX 8
int N,ret;
int arr[MAX+1][MAX+1];
bool visited[MAX+1][MAX+1];
int max(int a, int b) {
	return a>b?a:b;
}
int dir[][2] = {{0,1},{1,0},{0,-1},{-1,0}};
bool isOnBoard(int m, int n) {
	return m>=1 && n>=1 && m<=N && n<=N;
}
void dfs(int m, int n, int k, int res) {
	ret = max(ret,res);
	for(int r=0; r<4; r++) {
		int dy=m+dir[r][0];
		int dx=n+dir[r][1];
		int dk=k;
		if(isOnBoard(dy,dx) && !visited[dy][dx]) {
			int temp=arr[dy][dx];
			if(arr[dy][dx]>=arr[m][n]) {
				dk-=arr[dy][dx]-arr[m][n]+1;
				arr[dy][dx]-=arr[dy][dx]-arr[m][n]+1;
				if(dk>0) dk=0;
			}
			if(dk>=0) {
				visited[dy][dx]=true;
				dfs(dy,dx,dk,res+1);
				visited[dy][dx]=false;
			}
			arr[dy][dx]=temp;
		}
	}
}
int main() {
	int T,TC=1;
	int str, k;
	scanf("%d",&T);
	while(T-->0) {
		scanf("%d %d",&N,&k);
		str=0;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				scanf("%d", &arr[i][j]);
				str = max(str, arr[i][j]);
			}
		}
		ret=0;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(arr[i][j]==str) {
					visited[i][j]=true;
					dfs(i,j,k,1);
					visited[i][j]=false;
				}
			}
		}
		printf("#%d %d\n", TC++,ret);
	}
}
