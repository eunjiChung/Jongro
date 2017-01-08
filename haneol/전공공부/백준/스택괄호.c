#include <stdio.h>
#include <string.h>

enum { STACK_SIZE = 52 };

static char g_array[STACK_SIZE];
static int g_top = 0;

void reverseWord(char * word);

void push(char data) {

	g_array[g_top++] = data;
}

char pop(void) {

	return g_array[--g_top];
}

int isEmpty(void) {

	return g_top == 0;
}

int main(void) {

	int i, testcase = 0;
	char word[52];
	scanf("%d", &testcase);
	while (getchar() != '\n');

	for (i = 0; i < testcase; i++) {
		fgets(word, sizeof(word), stdin);
		word[strlen(word) - 1] = '\0';

		reverseWord(word);

	}

}

void reverseWord(char * word) {
	int check = 0;

	while (*word) {
		if (*word == '(') {
			push(*word++);
		}
		else {
			if (!isEmpty()) {
				pop();
			}
			else {
				printf("NO\n");
				return;
			}
			*word++;
		}
	}

	while (!isEmpty()) {
		pop();
		check++;
	}

	if (check == 0) {
		printf("YES\n");
	}
	else {
		printf("NO\n");
	}
}

void reverseWord(char * word) {
	int check = 0;

	while (*word) {
		if (*word == '(') {
			push(*word++);
		}
		else {
			if (!isEmpty()) {
				pop();
			}
			else {
				printf("NO\n");
				return;
			}
			*word++;
		}
	}

	while (!isEmpty()) {
		pop();
		check++;
	}

	if (check == 0) {
		printf("YES\n");
	}
	else {
		printf("NO\n");
	}
}