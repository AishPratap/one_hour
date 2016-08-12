#include <stdio.h>
#include <ctype.h>
#include <string.h>
#include <math.h>

int main() {
	int a, b, c;
	int d = 0;
	scanf("%d %d %d", &a, &b, &c);
	for (int i = a; i <= b; ++i) {
		if (i % c == 0) {
			d += 1;
		}
	}

	printf("%d\n", d);
	return 0;
}