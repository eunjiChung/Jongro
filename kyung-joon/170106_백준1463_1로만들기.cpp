#include <iostream>
using namespace std;
int arr[1000000+1];
int N;

int dp() {
	arr[1]=0;
	arr[2]=1;
	arr[3]=1;
	for(int i=4; i<=N; i++) {
		arr[i] = 1 + arr[i-1];
		if(i%3==0) arr[i] = min(arr[i], 1 + arr[i/3]);
		if(i%2==0) arr[i] = min(arr[i], 1 + arr[i/2]);
	}
	return arr[N];
}

int main() {
	cin >> N;
	cout << dp();
}
