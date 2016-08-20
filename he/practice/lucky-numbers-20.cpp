#include <stdio.h>
#include <ctype.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>
#include <stdbool.h>

bool is_lucky(int num) {
	int count = 2;
	while (num) {
		count -= 1;
		num &= (num - 1);
		if (count < 0) {
			return false;
		}
	}
	return count == 0;
}

int main() {

	freopen("_in","r",stdin);
    freopen("_out","w",stdout);

	int t, n, mod = 1000000007;
	scanf("%d", &t);
	while (t--) {
		scanf("%d", &n);
		int sum = 0;
		for (int i = 0; i <= n; ++i) {
			if (is_lucky(i)) {
				sum = (sum + i) % mod;
			}
		}

		printf("%d\n", sum);
	}

	return 0;
}