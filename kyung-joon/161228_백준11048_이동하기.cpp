#include <iostream>
using namespace std;
int M,N;
int arr[1000][1000];
int arr2[1000][1000];

int dp(int m, int n) {
	for(int i=0; i<=m; i++) {
		for(int j=0; j<=n; j++) {
			if(i==0 && j==0) arr2[i][j] = arr[i][j];
			else if(i==0) arr2[i][j] = arr[i][j] + arr2[i][j-1];
			else if(j==0) arr2[i][j] = arr[i][j] + arr2[i-1][j];
			else {
				if(arr2[i][j-1] > arr2[i-1][j]) {
					arr2[i][j] = arr[i][j] + arr2[i][j-1];
				} else {
					arr2[i][j] = arr[i][j] + arr2[i-1][j];
				}
			}
		}
	}
	return arr2[m][n];
}

int main() {
	cin >> M >> N;
	for(int i=0; i<M; i++) {
		for(int j=0; j<N; j++) {
			cin >> arr[i][j];
		}
	}
	cout << dp(M-1,N-1);
}
