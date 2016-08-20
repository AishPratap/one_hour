#include <stdio.h>
#include <ctype.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {
	while (true) {
		int cur;
		scanf("%d", &cur);
		if (cur == 42) {
			break;
		} else {
			printf("%d\n", cur);
		}
	}
	return 0;
}