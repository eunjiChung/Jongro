#include <stdio.h>

int Fact(int var) {

	int sum = 1;

	int i = 0;
	for (i = var; i >0; i--) {
		sum *= i;
	}
	
	return sum;
}

int Cal(int n) {
	int i, j, k, temp, sum = 0;
	int key = 0;
	key += 1;			// 1로만 더하는 경우

	if ((n % 2) == 0)	// 2로만 ~
		key += 1;

	if ((n % 3) == 0)	// 3으로만 ~
		key += 1;

	temp = n;
	///////////////////////////////////////////
	if (n >= 3) {		// 1, 2
		
		for (i = 0; i <= n-(1+2); i++) {		// 1
			
			for (j = 0; ; j++) {	// 2
				temp = n - (1+2);		// 1, 2 한번씩
				temp -= i + (2 * j);
				if (temp == 0) {
					key += Fact((i + 1) + (j + 1)) / (Fact(i + 1) * Fact(j + 1));
				}
				else if (temp < 0)
					break;
			}

		}


	}////////////////////////////////////////

	if (n >= 4) {		// 1, 3

		for (i = 0; i <= n - (1+3); i++) {		// 1

			for (j = 0; ; j++) {	// 2
				temp = n - (1 + 3);		// 1, 3 한번씩
				temp -= i + (3 * j);
				if (temp == 0) {
					key += Fact((i + 1) + (j + 1)) / (Fact(i + 1) * Fact(j + 1));
				}
				else if (temp < 0)
					break;
			}

		}

	}

	if (n >= 5) {							// 2, 3

		for (i = 0; i <= (n - (2+3))/2; i++) {		// 1

			for (j = 0; ; j++) {	// 2
				temp = n - (2 + 3);		// 2, 3 한번씩
				temp -= 2*i + (3 * j);
				if (temp == 0) {
					key += Fact((i + 1) + (j + 1)) / (Fact(i + 1) * Fact(j + 1));
				}
				else if (temp < 0)
					break;
			}

		}

	}
	
	if (n >= 6) {		// 1, 2, 3 조합

		for (i = 0; i <= n - (1+2+3); i++) {		// 1

			for (j = 0; j <= (n-(1+2+3))/2; j++) {			// 2
				
				for (k = 0; ; k++) {
					temp = n - (1 + 2 + 3);			// 2, 3 한번씩
					temp -= i + (2 * j) + (3 * k);
					if (temp == 0) {
						key += Fact((i + 1) + (j + 1) + (k + 1)) / (Fact(i + 1) * Fact(j + 1) * Fact(k + 1) );
					}
					else if (temp < 0)
						break;
				}

			}

		}

	}
	
	return key;
}


int main(void) {

	int i, j, k, testcase, n, key, temp = 0;

	scanf_s("%d", &testcase);

	for (i = 0; i < testcase; i++) {
				
		scanf_s("%d", &n);
		printf("%d\n",Cal(n));

	}

	scanf_s("%d");
	return 0;
}