#include <stdio.h>
#include <ctype.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int count_one(int n) {
	int count = 0;
	while (n) {
		count += 1;
		n &= (n - 1);
	}
	return count;
}

int comp(const void* a, const void* b) {
	int vala = count_one(*(int*) a);
	int valb = count_one(*(int*) b);

	if (vala == valb) {
		return *(int*) a - *(int*) b;
	}

	return vala - valb;

}

int main() {
	int t, n;
	scanf("%d", &t);
	while (t--) {
		scanf("%d", &n);
		int arr[n];
		for (int i = 0; i < n; ++i) {
			int tmp;
			scanf("%d", &tmp);
			arr[i] = tmp;
		}
		qsort(arr, n, sizeof(arr[0]), comp);
		for (int i = 0; i < n; ++i) {
			printf("%d ", arr[i]);
		}
		printf("\n");
	}
}