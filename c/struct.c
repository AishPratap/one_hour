#include<stdio.h>
#include<stdlib.h>

typedef struct
{
	int value;
} counter;

void inc(counter* c)
{
	c->value += 1;
}

int get_value(counter* c)
{
	return c->value;
}

void init(counter* c) 
{
	c->value = 0;
}

int main(void)
{
	counter* c = malloc(sizeof(counter));
	init(c);
	inc(c);
	printf("%d\n", get_value(c));
	free(c);
}
