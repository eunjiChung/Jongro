#include <iostream>
using namespace std;
int arr[10];

int dp(int num) {
	if(num==1) return 1;
	else if(num==2) return 2;
	else if(num==3) return 4;
	else if(!arr[num]) {
		arr[num] = dp(num-1) + dp(num-2) + dp(num-3);
	}
	return arr[num];
}

int main() {
	ios_base::sync_with_stdio(false);
	int T, input;
	cin >> T;
	while(T--) {
		cin >> input;
		cout << dp(input) <<"\n";
	}
}
