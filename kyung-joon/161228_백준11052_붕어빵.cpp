#include <iostream>
using namespace std;
int N;
int arr[1000+1];
int arr2[1000+1][1000+1]; //memoization

int dp(int num) {
	for(int i=1; i<=num; i++) {
		for(int j=1; j<=num; j++) {
			if(i==j) arr2[i][j] = arr[j];
			else if(j > i) continue;
			else arr2[i][j] = arr[j] + arr2[i-j][0];
			arr2[i][0] = max(arr2[i][0], arr2[i][j]);
		}
	}
	return arr2[num][0]; //arr2[i][0]을 output으로 함 
}

int main() {
	cin >> N;
	for(int i=1; i<=N; i++) cin >> arr[i];
	for(int i=1; i<=N; i++) {
		for(int j=1; j<=N; j++) {
			arr2[i][j]=0;
		}
	}
	cout << dp(N);
}
