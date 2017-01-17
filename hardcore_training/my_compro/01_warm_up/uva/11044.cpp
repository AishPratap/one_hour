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
	int t, m, n;
	cin >> t;
	while (t--) {
		cin >> m >> n;
		m -= 2;
		n -= 2;

		if (m % 3 == 0) {
			m /= 3;
		} else {
			m = m / 3 + 1;
		}
		if (n % 3 == 0) {
			n /= 3;
		} else {
			n = n / 3 + 1;
		}

		cout << m * n << endl;
	}
}
