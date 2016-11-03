#include <bits/stdc++.h>

#define forall(i,a,b) for(int i=a;i<b;i++)
#define foreach(v, c) for( typeof( (c).begin()) v = (c).begin();  v != (c).end(); ++v)
#define all(a) a.begin(), a.end()
#define fill(a,v)  memset(a, v, sizeof a)
#define maX(a,b)  ( (a) > (b) ? (a) : (b))
#define miN(a,b)  ( (a) < (b) ? (a) : (b))
#define checkbit(n,b)  ( (n >> b) & 1)
#define ll long long
#define endln '\n'

using namespace std;

int n, m;
string str;

int main() {
	std::ios::sync_with_stdio(false);
	// freopen("_in","r",stdin);
    // freopen("_out","w",stdout);

	int tcase = 1;
	bool line = false;

	while (true) {
		cin >> n >> m;
		if (!n && !m) {
			break;
		}

		int field[n][m];
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				field[i][j] = 0;
			}
		}

		for (int i = 0; i < n; ++i) {
			cin >> str;
			for (int j = 0; j < m; ++j) {
				char c = str[j];
				if (c == '*') {
					field[i][j] = -INT_MAX;
					for (int k = i - 1; k <= i + 1; ++k) {
						for (int l = j - 1; l <= j + 1; ++l) {
							if (k >= 0 && k < n && l >= 0 && l < m) {
								field[k][l] += 1;
							}
						}
					}
				}
			}
		}

		if (line) {
			cout << endl;
		} else {
			line = true;
		}
		cout << "Field #" << tcase++ << ":" << endl;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (field[i][j] < 0) {
					cout << "*";
				} else {
					cout << field[i][j];
				}
			}
			cout << endl;
		}
	}

	return 0;
}