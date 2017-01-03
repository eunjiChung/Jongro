#include <iostream>
using namespace std;
int arr[300+1][3];
int N;

int dp() {
	arr[1][1]=arr[1][0];
	arr[2][1]=arr[2][0]+arr[1][1];
	arr[2][2]=arr[2][0];
	for(int i=3; i<=N; i++) {
		arr[i][1] = arr[i][0]+arr[i-1][2];
		arr[i][2] = arr[i][0]+max(arr[i-2][1],arr[i-2][2]);
	}
	return max(arr[N][1],arr[N][2]);
}

int main() {
	cin >> N;
	for(int i=1; i<=N; i++) {
		cin >>arr[i][0];
	}
	cout << dp();
}