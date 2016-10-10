#include <stdio.h>

/**
 * Reverse a null-terminal string
 * Time: O(n); Space: O(1)
 */
void rev(char* str) {
	if (!str || !str[1]) {
		return;
	}
	int left = 0, right = 0;
	while (str[right]) {
		right += 1;
	}
	right -= 1;
	while (left < right) {
		char temp = str[left];
		str[left] = str[right];
		str[right] = temp;
		left += 1;
		right -= 1;
	}
}

int main() {
	char str[32] = "kibo";
	rev(str);

	printf("%s\n", str);
}
