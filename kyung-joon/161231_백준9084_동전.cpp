#include <iostream>
using namespace std;
int M, N;
int arr[10000+1][20+1], arr_input[20+1];

int dp(
	for(int i=1; i<=M; i++) {
		for(int j=1; j<=N; j++) {
			if(arr[i][j]==0 && i>=arr_input[1]) {
				for(int k=j; k<=N; k++) {
					if(arr_input[k]>i) break;
					arr[i][j] += arr[i-arr_input[j]][k];
				}
			}
		}
	}
	
	int value_out=0;
	for(int i=1; i<=N; i++) {
		value_out+=arr[M][i];
	}
	return value_out;
}

int main() {
	int T;
	cin >> T;
	while(T--) {
		for(int i=1; i<=20; i++) arr_input[i]=0;
		for(int i=1; i<=10000; i++) {
			for(int j=1; j<=20; j++) {
				arr[i][j]=0;
			}
		}
		
		cin >> N;
		for(int i=1; i<=N; i++) {
			int temp;
			cin >> temp;
			arr_input[i]=temp;
			arr[temp][i]++;
		}
		cin >> M;
		
		cout << dp() << "\n";
	}
}
