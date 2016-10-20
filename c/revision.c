#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
	int val;
	struct Node* next;
} Node;

Node* nodeCreate(int val) {
	Node* result	= malloc(sizeof(Node));
	result->val		= val;
	result->next	= NULL;
	return result;
}

typedef struct LinkedList {
	Node* head;
	Node* tail;
} LinkedList;

LinkedList* linkedListCreate() {
	LinkedList* result = malloc(sizeof(LinkedList));
	return result;
}

void linkedListAdd(LinkedList* list, int val) {
	if (!list->head) {
		list->head = nodeCreate(val);
	} else if (!list->tail) {
		list->tail = nodeCreate(val);
		list->head->next = list->tail;
	} else {
		list->tail->next = nodeCreate(val);
		list->tail= list->tail->next;
	}
}

void linkedListRelease(LinkedList* list) {
	Node* iterator = list->head;
	Node* target;
	while (iterator) {
		target = iterator;
		iterator = iterator->next;
		free(target);
	}
	free(list);
}

void linkedListDump(LinkedList* list) {
	Node* iterator = list->head;
	while(iterator) {
		printf("%d ", iterator->val);
		iterator = iterator->next;
	}
}

int main() {
	LinkedList* list = linkedListCreate();
	linkedListAdd(list, 1);
}
