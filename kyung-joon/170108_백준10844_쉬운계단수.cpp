#include <iostream>
using namespace std;
int arr[100+1][10];
int N;

int dp() {
	for(int i=1; i<=9; i++) arr[1][i] = 1;
	for(int i=2; i<=N; i++) {
		arr[i][0] = arr[i-1][1];
		arr[i][1] = (arr[i-1][0] + arr[i-1][2])%1000000000;
		arr[i][2] = (arr[i-1][1] + arr[i-1][3])%1000000000;
		arr[i][3] = (arr[i-1][2] + arr[i-1][4])%1000000000;
		arr[i][4] = (arr[i-1][3] + arr[i-1][5])%1000000000;
		arr[i][5] = (arr[i-1][4] + arr[i-1][6])%1000000000;
		arr[i][6] = (arr[i-1][5] + arr[i-1][7])%1000000000;
		arr[i][7] = (arr[i-1][6] + arr[i-1][8])%1000000000;
		arr[i][8] = (arr[i-1][7] + arr[i-1][9])%1000000000;
		arr[i][9] = arr[i-1][8];
	}
	int val_out=0;
	for(int i=0; i<=9; i++) val_out = (val_out + arr[N][i])%1000000000;
	return val_out;
}

int main() {
	cin >> N;
	cout << dp();
}
