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
	
	int t, n, c;
	cin >> t;
	while (t--) {
		cin >> n;
		int maxv = -1, minv = 100;
		while (n--) {
			cin >> c;
			minv = min(minv, c);
			maxv = max(maxv, c);
		}

		cout << (maxv - minv) * 2 << endl;
	}
}
