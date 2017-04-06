#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main(void) {

	int i, j, k = 0;
	int testcase = 0;
	
	double std_number = 0;
	double count = 0;

	int sum = 0;

	scanf("%d", &testcase);

	for (i = 0; i < testcase; i++) {
		
		int arr[1005];
		double average;

		sum = 0;
		count = 0;
		average = 0;
		
		scanf("%lf", &std_number);

//////////////////////////////////////////////

		for (j = 0; j < std_number; j++) {
			
			scanf("%d", &arr[j]);
			sum += arr[j];

		}

		average = sum / std_number;

		for (k = 0; k < std_number; k++) {

			if (arr[k] > average) {
				count += 1;
			}

		}

		printf("%.3lf%%\n", 100*(count/std_number));
	}
	return;
}
