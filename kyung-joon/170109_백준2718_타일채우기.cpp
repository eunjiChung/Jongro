#include <iostream>
using namespace std;
int N;
int arr[1000+1][8+1];

int dp() {
	arr[1][0]=arr[1][1]=arr[1][3]=1;
	arr[1][2]=2;
	for(int i=2; i<=N; i++) {
		arr[i][0] = arr[i][1] = arr[i][3] = arr[i-1][1] + arr[i-1][4] + arr[i-1][7] + arr[i-2][0];
		arr[i][2] = arr[i][0]*2;
		arr[i][4] = arr[i][5] = arr[i-1][2] + arr[i-1][5];
		arr[i][6] = arr[i][7] = arr[i-1][3] + arr[i-1][8];
		arr[i][8] = arr[i-1][6];
	}
	return arr[N][1] + arr[N][4] + arr[N][7] + arr[N-1][0];
}

int main() {
	int T;
	cin >> T;
	while(T--) {
		cin >> N;
		cout << dp() << "\n";
	}
}
