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
	
	int t, a, b;
	cin >> t;
	while (t--) {
		cin >> a >> b;
		if (a < b) {
			cout << "<" << endl;
		} else if (a > b) {
			cout << ">" << endl;
		} else {
			cout << "=" << endl;
		}
	}
}
