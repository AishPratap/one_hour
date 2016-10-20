#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Person {
	char name[128];
	int age;
} Person;

typedef struct Student {
	Person* base;
	int studentId;
} Student;

typedef struct Teacher {
	Person* base;
	char supervisor[128];
} Teacher;



int main() {
	Student* person = malloc(sizeof(Student));

	person->base = malloc(sizeof(Person));
	strcpy(person->base->name, "Hoang Khoi");
	person->base->age = 21;

	free(person->base);
	free(person);
}
