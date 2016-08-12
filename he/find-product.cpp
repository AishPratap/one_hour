#include <stdio.h>
#include <ctype.h>
#include <string.h>

int main() {
	int n;
	long pro = 1;
	int mod = 1000000007;
	scanf("%d", &n);
	while(n--) {
		long cur;
		scanf("%ld", &cur);
		pro = (pro * cur) % mod;
	}

	printf("%ld\n", pro);
	return 0;
}