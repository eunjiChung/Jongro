#include <iostream>
using namespace std;
int arr[1000+1]={1,1};
int N;

int dp() {
	for(int i=2; i<=N; i++) {
		arr[i] = (arr[i-1] + arr[i-2]*2)%10007;
	}
	return arr[N];
}

int main() {
	cin >> N;
	cout << dp();
}