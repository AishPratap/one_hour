#include <stdio.h>
#include <ctype.h>
#include <string.h>

int main() {
	int n;
	scanf("%d", &n);
	while (n--) {
		int cur;
		scanf("%d", &cur);
		printf("%d\n", cur - 1);
	}

	return 0;
}