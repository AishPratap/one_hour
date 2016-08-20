#include <stdio.h>
#include <ctype.h>
#include <string.h>

int main() {
	char str[101];
	fgets(str, 101, stdin);
	for (int i = 0; i < strlen(str); ++i) {
		char c = str[i];
		if ((c >= 'a' && c <= 'z')) {
			str[i] = toupper(c);
		} else if (c >= 'A' && c <= 'Z') {
			str[i] = tolower(c);
		}
	}

	printf("%s\n", str);
	return 0;
}