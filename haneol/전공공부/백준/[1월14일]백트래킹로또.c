#include <stdio.h>
int main(void) {
	int a, b, c, d, e, f, i, testcase, arr[50] = 0;	
	
	while (1) {
		scanf_s("%d", &testcase);				// testcase 입력
		if (testcase == 0)						// 0이면 종료
			break;
				
		for (i = 0; i < testcase; i++) {		// 숫자 배열에 삽입
			scanf_s("%d", &arr[i]);
		}
		
		for ( a = 0 ; a <= testcase - 6 ; a++) {					// 6중 반복문. 각각의 자리수를 순차적으로 증가
			for ( b = a + 1 ; b <= testcase - 5  ;  b++) {
				for ( c = b + 1  ; c <= testcase - 4  ;  c++) {
					for ( d = c + 1; d <= testcase - 3 ; d++) {
						for ( e = d + 1  ; e <= testcase - 2  ;  e++) {
							for ( f = e + 1 ; f <= testcase - 1  ;  f++) {
								printf("%d %d %d %d %d %d \n", arr[a], arr[b], arr[c], arr[d], arr[e], arr[f]);		// 출력
							}
						}
					}
				}
			}
		}
		printf("\n");
	}
	return 0;
}