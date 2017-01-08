#include <iostream>
using namespace std;
int N;
int arr[1000+1];

int dp() {
	for(int i=0; i<=9; i++) {
		for(int j=1; j<=N; j++) {
			if(j==1) arr[j] += 1;
			else {
				arr[j] = (arr[j] + arr[j-1])%10007;
			}
		}
	}
	return arr[N];
}

/*
int dp() {
	for(int i=0; i<=9; i++) arr[1][i]=1;
	for(int i=2; i<=N; i++) {
		for(int j=0; j<=9; j++) {
			if() arr[i][j] 
		}
		
		
		arr[i][0] = arr[i-1][0];
		arr[i][1] = (arr[i-1][0] + arr[i-1][1])%10007;
		arr[i][2] = (arr[i-1][1] + arr[i-1][2])%10007;
		arr[i][3] = (arr[i-1][2] + arr[i-1][3])%10007;
		arr[i][4] = (arr[i-1][3] + arr[i-1][4])%10007;
		arr[i][5] = (arr[i-1][4] + arr[i-1][5])%10007;
		arr[i][6] = (arr[i-1][5] + arr[i-1][6])%10007;
		arr[i][7] = (arr[i-1][6] + arr[i-1][7])%10007;
		arr[i][8] = (arr[i-1][7] + arr[i-1][8])%10007;
		arr[i][9] = (arr[i-1][8] + arr[i-1][9])%10007;
	}
	int val_out=0;
	for(int i=1; i<=9; i++) val_out = (val_out + arr[N][i])%10007;
	return val_out;
}*/

int main() {
	cin >> N;
	cout << dp();
}
