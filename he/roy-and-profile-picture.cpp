#include <stdio.h>
#include <ctype.h>
#include <string.h>
#include <math.h>

int main() {
	int l,w,h,n;
	scanf("%d\n%d", &l, &n);
	while (n--) {
		scanf("%d %d", &w, &h);
		if (w < l || h < l) {
			printf("UPLOAD ANOTHER\n");
		} else if (w == h) {
			printf("ACCEPTED\n");
		} else {
			printf("CROP IT\n");
		}
	}
	return 0;
}