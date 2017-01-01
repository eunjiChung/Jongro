#include <iostream>
using namespace std;
int M, N;
int arr[10000+1]={1}, arr2[20+1];

int dp(){
	for(int i=1; i<=N; i++) {
		for(int j=1; j<=M; j++) {
			if(j-arr2[i]<0) continue;
			arr[j] += arr[j-arr2[i]];
		}
	}
	return arr[M];
}

int main() {
	int T;
	cin >> T;
	while(T--) {
		cin >> N;
		for(int i=1; i<=N; i++) cin >> arr2[i];
		cin >> M;

		cout << dp() << "\n";
		for(int i=1; i<=M; i++) arr[i]=0;
	}
}
