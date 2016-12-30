#include <iostream>
using namespace std;
int N;
int arr[1000+1];
int arr2[1000+1]; //memoization

int dp(int num) {
	for(int i=1; i<=num; i++) {
		for(int j=1; j<=i; j++) {
			arr2[i] = max(arr2[i], arr[j] + arr2[i-j]);
		}
	}
	return arr2[num];
}

int main() {
	cin >> N;
	for(int i=1; i<=N; i++) cin >> arr[i];
	cout << dp(N);
}
