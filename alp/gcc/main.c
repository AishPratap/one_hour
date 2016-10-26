#include <stdio.h>
#include <assert.h>
#include <stdlib.h>

#include "include/math.h"

int main(int argc, char** argv) {
	assert(argc == 3);
	int n0 = atoi(argv[1]);
	int n1 = atoi(argv[2]);

	printf("Sum of %d and %d is %d\n", n0, n1, sum(n0, n1));
	printf("Dif of %d and %d is %d\n", n0, n1, dif(n0, n1));
}
