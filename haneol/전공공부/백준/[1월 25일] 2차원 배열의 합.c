#include <stdio.h>

int main(void) {

	int i, j, l, N, M = 0;
	int x, y, a, b, k, sum = 0;
	int arr[300][300] = { 0 };

	scanf_s("%d%d", &N, &M);

	for (i = 0; i < N; i++) {
		for (j = 0; j < M; j++) {
			scanf_s("%d", &arr[i][j]);
		}
	}

	scanf_s("%d", &k);

	for (i = 0; i < k; i++) {

		scanf_s("%d%d%d%d", &x, &a, &y, &b);
		sum = 0;

		for (j = 0; j <= y - x; j++) {
			for (l = 0; l <= b - a; l++) {
				sum += arr[j+(x-1)][l+(a-1)];
			}
		}
		printf("값은 %d입니다.\n", sum);

	}
	




	scanf_s("%d");
	return 0;
}