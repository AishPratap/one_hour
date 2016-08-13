#include <stdio.h>
#include <ctype.h>
#include <string.h>

int main() {
	char str[101];
	scanf("%s", str);
	int len = strlen(str);

	bool pal = true;

	for (int i = 0; i < len; ++i) {
		if (str[i] != str[len - 1 - i]) {
			pal = false;
			break;
		}
	}

	printf("%s\n", pal ? "YES" : "NO");

	return 0;
}