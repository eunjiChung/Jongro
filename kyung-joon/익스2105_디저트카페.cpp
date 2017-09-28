#include <stdio.h>
#define RD 0
#define LD 1
#define LU 2
#define RU 3
bool visited[100+1];
int arr[20+1][20+1];
int N;
int res;

int max(int a, int b) {
	return a>b?a:b;
}
int dir[][2] = {{1,1},{1,-1},{-1,-1},{-1,1}};
bool isOnBoard(int m, int n) {
	return m>=1 && n>=1 && m<=N && n<=N;
}
void dfs(int m, int n, int r) {
	int dy,dx;
	for(int i=r; i<=r+1 && i<=RU; i++) {
		dy=m+dir[r][0];
		dx=n+dir[r][1];
		if(isOnBoard(dy,dx) && !visited[arr[dy][dx]]) {
			visited[arr[dy][dx]]=true;
			dfs(dy,dx,i);
			visited[arr[dy][dx]]=false;
		}
	}
	if(arr[dy][dx]==-1 && r==RU) {
		int ret=0;
		for(int i=1; i<=100; i++) {
			if(visited[i]) ret++;
		}
		res = max(res, ret);
		return;
	}
}

int main() {
	int T,TC=1;
	scanf("%d", &T);
	while(T-->0) {		
		res=0;
		scanf("%d", &N);
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				scanf("%d", &arr[i][j]);
			}
		}
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				int temp=arr[i][j];
				visited[arr[i][j]]=true;
				arr[i][j]=-1;
				dfs(i,j,RD);
				arr[i][j]=temp;
				visited[arr[i][j]]=false;
			}
		}
		printf("#%d %d\n",TC++, res>0?res:-1);
	} 
}
