#include <stdio.h>
#include <queue>
#define MAX 50
int M,N;
int arr[MAX][MAX];
bool visited[MAX][MAX];
typedef struct {
	int y,x,t;
}Point;
int dir[][2] = {{0,1},{1,0},{0,-1},{-1,0}};
bool isOnBoard(int m, int n) {
	return m>=0 && n>=0 && m<M && n<N;
}

int main() {
	int T,TC=1;
	scanf("%d",&T);
	while(T-->0) {
		int m,n,t;
		scanf("%d %d %d %d %d", &M, &N, &m, &n, &t);
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				scanf("%d", &arr[i][j]);
			}
		}
		std::queue<Point> q;
		visited[m][n]=true;
		q.push({m,n,t});
		while(!q.empty()) {
			Point cur = q.front();
			q.pop();
			for(int r=0; r<4; r++) {
				if(arr[cur.y][cur.x]==2) {
					if(r==0||r==2) continue;
				}
				else if(arr[cur.y][cur.x]==3) {
					if(r==1||r==3) continue;
				}
				else if(arr[cur.y][cur.x]==4) {
					if(r==1||r==2) continue;
				}
				else if(arr[cur.y][cur.x]==5) {
					if(r==2||r==3) continue;
				}
				else if(arr[cur.y][cur.x]==6) {
					if(r==0||r==3) continue;
				}
				else if(arr[cur.y][cur.x]==7) {
					if(r==0||r==1) continue;
				}
				int dy = cur.y + dir[r][0];
				int dx = cur.x + dir[r][1];
				int dt = cur.t - 1;
				if(isOnBoard(dy,dx) && !visited[dy][dx]
						&& arr[dy][dx]>0 && dt>0) {
					if(r==0) {
						if(arr[dy][dx]==2 || arr[dy][dx]==4 || arr[dy][dx]==5) continue;
					}
					else if(r==1) {
						if(arr[dy][dx]==3 || arr[dy][dx]==5 || arr[dy][dx]==6) continue;
					}
					else if(r==2) {
						if(arr[dy][dx]==2 || arr[dy][dx]==6 || arr[dy][dx]==7) continue;
					}
					else {
						if(arr[dy][dx]==3 || arr[dy][dx]==4 || arr[dy][dx]==7) continue;
					}
					visited[dy][dx]=true;
					q.push({dy,dx,dt});
				}
			}
		}
		
		/*
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(visited[i][j]) printf("1 ");
				else printf("0 ");
			}
			printf("\n");
		}printf("\n");
		*/
		int res=0;
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(visited[i][j]) {
					res++;
					visited[i][j]=false;
				}
			}
		}
		
		printf("#%d %d\n", TC++, res);
	}
}
