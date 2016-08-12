#include <stdio.h>
#include <ctype.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {
	int n;
	scanf("%d", &n);
	int pro = 1;
	while(n) {
		pro *= n--;
	}

	printf("%d\n", pro);
	return 0;
}