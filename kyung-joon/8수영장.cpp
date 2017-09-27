#include <stdio.h>
#define COIN 4
#define MON 12
int coin[COIN];
int sch[MON+1];
int dp[MON+1];

int min(int a, int b) {
	return a<b ?a :b;
}
int min(int a, int b, int c) {
	return min(a,min(b,c));
}
int main() {
	int T;
	scanf("%d",&T);
	for(int TS=1; TS<=T; TS++) {
		for(int i=0; i<COIN; i++) {
			scanf("%d", &coin[i]);
		}
		for(int i=1; i<=MON; i++) {
			scanf("%d", &sch[i]);
		}
		for(int i=1; i<=MON; i++) {
			sch[i] = min(coin[1], sch[i]*coin[0]);
		}
		dp[0]=0;
		dp[1]=sch[1];
		dp[2]=sch[1] + sch[2];
		for(int i=3; i<=MON; i++) {
			dp[i] = min(dp[i-1]+sch[i], dp[i-3]+coin[2]);
		}
		dp[MON] = min(dp[MON], dp[MON-2]+coin[2], coin[3]);
		
		printf("#%d %d\n", TS, dp[MON]);
	}
}
