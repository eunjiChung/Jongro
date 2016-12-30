#include <iostream>
using namespace std;
int arr[300+1][300+1];
int M,N;
int w,z,x,y;

int main() {
	cin >> M >> N;
	for(int i=1; i<=M; i++) {
		for(int j=1; j<=N; j++) {
			cin >> arr[i][j];
		}
	}
	int answer_cnt, output;
	cin >> answer_cnt;
	for(int cnt=1; cnt<=answer_cnt; cnt++) {
		cin >> w >> z >> x >> y;
		output=0;
		for(int i=w; i<=x; i++) {
			for(int j=z; j<=y; j++) {
				output+=arr[i][j];
			}
		}
		cout << output << endl;
	}
}
