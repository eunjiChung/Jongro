#include <stdio.h>
#include <string.h>

int location = 0;

typedef struct _NODE {

	int data;
	struct _NODE *next;

}NODE;

void addHead(NODE *pHead, int data) {

	NODE *pNode = malloc(sizeof(NODE));
	pNode->data = data;

	pNode->next = pHead->next;
	pHead->next = pNode;
}

void addTail(NODE *pHead, int data) {

	NODE *cur = pHead;
	while (cur->next != NULL) {
		cur = cur->next;
	}
	addHead(cur, data);
}

int getHead(NODE * pHead) {

	return pHead->next->data;

}

void removeHead(NODE * pHead) {

	NODE * pNode = pHead->next;
	pHead->next = pNode->next;
	free(pNode);
}

int isEmpty(NODE * pHead) {

	return pHead->next == NULL;

}

int countNode(NODE * pHead) {

	int count;
	NODE * cur = pHead->next;

	for (count = 0; cur != NULL; count++)
		cur = cur->next;

	return count;
}

int compare(NODE * pHead) {

	int first = 0;
	int key = 0;

	NODE * cur = pHead->next;

	first = cur->data;			// 처음 값 저장

	while (cur != NULL) {
		if (first < cur->data) {
			key += 1;
			break;
		}
		cur = cur->next;
	}

	return key;				// 처음 값이 제일 크면 0을 같거나 작으면 1을 반환한다.
}

void clear(NODE * pHead) {

	while (isEmpty(pHead) == 0)
		removeHead(pHead);
}

int main(void) {
	NODE head = { 0 };
	int goal = 0;						// 출력하고자 하는 값. 작업 처리시마다 1씩 증가
	int i, j, k, l, testcase, length = 0;
	int priority[100];
	scanf_s("%d", &testcase);

	for (i = 0; i < testcase; i++) {
		location = 0;								// testcase가 바뀔때마다 이 값은 초기화
		goal = 0;									// testcase가 바뀔때마다 이 값은 초기화
		scanf_s("%d", &length);
		scanf_s("%d", &location);
		
		for (j = 0; j < length; j++) {
			scanf_s("%d", &priority[j]);
		}

		for (k = 0; k < length; k++) {
			addTail(&head, priority[k]);			// 연결리스트에 꼬리에 삽입하는 형식 (큐와 동작원리 유사)
		}
		/////////////////////////////////////////////////////////////////////////////////////
		while( !isEmpty(&head) ){					// 비어있으면 1을 들어있으면 0을 리턴한다.
			if (compare(&head) == 0) {				// 현재작업이 제일 크면 0을 아니면 1을 반환
				goal += 1;							// 현재 작업을 처리할때마다 1씩 증가
				if (location == 0) {				// location index가 맨 앞이면 
					printf("%d\n", goal);			//  같으면 결과값 출력후 종료
					break;
				}else {								// 아니면 계속 진행
				}								
				removeHead(&head);					// 헤드 삭제
				location -= 1;						// 삭제 후 로케이션 1 차감
			}else {									// 꼬리추가 후 헤드 삭제
				addTail(&head, getHead(&head));		// 꼬리 추가
				removeHead(&head);					// 헤드 삭제

				if (location == 0) {					// 해당 인덱스가 맨 앞일때
					location += countNode(&head) - 1;	// 인덱스를 맨 뒤로 설정
				}
				else {
					location -= 1;						// 해당 인덱스가 맨 앞이 아닌 경우 인덱스를 1 감소
				}
			}
		}
		////////////////////////////////////////////////////////////////////////////////////////
		clear(&head);							// 다 지운다
	}
	return 0;
}