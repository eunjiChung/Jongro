#include <stdio.h>
#include <string.h>

int main(void) {
	
	int testcase, n, i, j, k, count = 0;
	int str[100] = { 0 };  // 0ÀÌ¸é ´İÈù, 1ÀÌ¸é ¿­¸²
	scanf_s("%d", &testcase);

	for (i = 0; i<testcase; i++) {
		count = 0;
		scanf_s("%d", &n);		
		memset(str, 0, sizeof(str));

		for (j = 0; j < n; j++) {
			str[j] = 1;
			if ((j % 2) != 0) {
				str[j] = 0;
			}
		}

		for (j = 3; j <= n; j++) {
			for (k=j-1; k < n  ; k += j) {
				if (str[k] == 0) {
					str[k] = 1;
				}
				else {
					str[k] = 0;
				}
			}
			
		}


		for (j = 0; j < n; j++)
			if (str[j] == 1)
				count += 1;

		printf("\n count = %d\n", count);
		
		
	}

	scanf_s("%d");

	return 0;
}
