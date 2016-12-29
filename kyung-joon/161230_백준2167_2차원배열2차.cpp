#include <iostream>
using namespace std;
int arr[300+1][300+1]; 
int M,N;

int main() {
	ios_base::sync_with_stdio(false);
	cin >> M >> N;
	for(int i=1; i<=M; i++) {
		for(int j=1; j<=N; j++) {
			cin >> arr[i][j];
			arr[i][j] += arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1];
		}
	}
	
	int w,z,x,y;
	int answer_cnt, output;
	cin >> answer_cnt;
	while(answer_cnt--) {
		cin >> w >> z >> x >> y;
		output = arr[x][y] - arr[x][z-1] - arr[w-1][y] + arr[w-1][z-1];
		cout << output << "\n";
	}
}

/*
#include <iostream>
using namespace std;
int arr[300+1][300+1]; 

int main() {
	int M,N;
	scanf("%d %d", &M, &N);
	for(int i=1; i<=M; i++) {
		for(int j=1; j<=N; j++) {
			scanf("%d", &arr[i][j]);
			arr[i][j] += arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1];
		}
	}
	
	int w,z,x,y;
	int answer_cnt, output;
	scanf("%d", &answer_cnt);
	while(answer_cnt--) {
		scanf("%d %d %d %d", &w, &z, &x, &y);
		output = arr[x][y] - arr[x][z-1] - arr[w-1][y] + arr[w-1][z-1];
		printf("%d\n", output);
	}
}
*/
