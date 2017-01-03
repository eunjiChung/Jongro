#include <iostream>
using namespace std;
int arr[30+1][4+1];
int N;

int dp() {
	arr[1][1] = 2;
	arr[1][2] = 1;
	arr[2][0] = 3;
	arr[2][3] = 2;
	for(int i=3; i<=N; i++) {
		arr[i][0] = arr[i-1][1] + arr[i-1][2] + arr[i-1][4];
		arr[i][1] = 2*arr[i-1][0];
		arr[i][2] = arr[i-1][0];
		arr[i][3] = arr[i-1][1] + arr[i-1][4];
		arr[i][4] = arr[i-1][3];
	}
	return arr[N][0];
}

int main() {
	cin >> N;
	cout << dp();
}