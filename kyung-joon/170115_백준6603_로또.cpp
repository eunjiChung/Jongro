#include <iostream>
using namespace std;
int K;
int arr[13+1];
bool isSelected[13+1];

void dfs(int num, int depth) {
	if(depth > 6) {
		for(int i=1; i<=K; i++) {
			if(isSelected[i]) cout << arr[i] << " ";
		}
		cout << "\n";
		return;
	}
	if(num > K) return;
	if(!isSelected[num]) {
		isSelected[num]=true;
		dfs(num+1,depth+1);
		isSelected[num]=false;
	}
	dfs(num+1, depth);
}

int main() {
	while(true) {
		cin >> K;
		if(K==0) break;
		else for(int i=1; i<=K; i++) {
			isSelected[i] = false;
			cin >> arr[i];
		}
		dfs(1,1);
		cout << "\n";
	}
	
}
