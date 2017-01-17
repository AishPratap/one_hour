/*
 * Author: Khoi Hoang
 */

#include <bits/stdc++.h>

using namespace std;

#define endl "\n"

int main()
{
	ios::sync_with_stdio(false);
	//freopen("input.txt", "r", stdin);
	//freopen("output.txt", "w", stdout);
	char c;
	bool quoted = false;
	while (cin.get(c)) {
		if (c == '\"') {
			if (!quoted) {
				cout << "``";
			} else {
				cout << "\'\'";
			}
			quoted = !quoted;
		} else {
			cout << c;
		}
	}
}
