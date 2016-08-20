#include <stdio.h>
#include <ctype.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {
	int t, n;
	scanf("%d", &t);
	while (t--) {
		scanf("%d", &n);
		int count = 0;
		while (n) {
			count += 1;
			n &= (n - 1);
		}
		printf("%d\n", count);
	}
	return 0;
}