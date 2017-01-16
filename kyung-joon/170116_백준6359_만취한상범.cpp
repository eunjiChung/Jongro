#include <iostream>
using namespace std;
bool isOpened[100+1];
int N;

int dp() {
	for(int i=1; i<=N; i++) {
		for(int j=1; i*j<=N; j++) {
			if(isOpened[i*j]) {
				isOpened[i*j] = false;
			} else isOpened[i*j] = true;
		}
	}
	int cnt=0;
	for(int i=1; i<=N; i++) {
		if(isOpened[i]) cnt++;
	}
	return cnt;
}

int main() {
	int T;
	cin >> T;
	while(T--) {
		cin >> N;
		for(int i=1; i<=N; i++) isOpened[i]=false;
		cout << dp() << "\n";
	}
}
