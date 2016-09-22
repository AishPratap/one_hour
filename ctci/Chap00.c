#include <stdio.h>

/*Reverse a string with C*/
/*Complexity O(n)*/
void reverse(char* str) {
	int left = 0, right = 0;
	while (str[right]) {
		right += 1;
	}
	right -= 1;
	while(left < right) {
		char temp = str[left];
		str[left] = str[right];
		str[right] = temp;
		left += 1;
		right -= 1;
	}
}

int main() {
	char str[] = "this is sparta";
	reverse(str);
	printf("%s\n", str);
	return 0;
}
