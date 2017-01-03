#include <iostream>
using namespace std;
int arr[300+1], dp[300+1];
int N;

int func() {
	dp[1] = arr[1];
	dp[2] = arr[1] + arr[2];
	for(int i=3; i<=N; i++) {
		dp[i] = arr[i] + max(dp[i-2], arr[i-1]+dp[i-3]);
	}
	return dp[N];
}

int main() {
	cin >> N;
	for(int i=1; i<=N; i++) {
		cin >>arr[i];
	}
	cout << func();
}