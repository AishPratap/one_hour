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

int q, n, m, x, y;

int main() {
	std::ios::sync_with_stdio(false);
	//freopen("_in","r",stdin);
    // freopen("_out","w",stdout);

	while (true) {
		cin >> q;
		if (!q) {
			break;
		}

		cin >> n >> m;

		while (q--) {
			cin >> x >> y;
			if (x == n || y == m) {
				cout << "divisa" << endl;
			} else {
				string result = "";
				if (y > m) {
					result += "N";
				} else {
					result += "S";
				}
				if (x > n) {
					result += "E";
				} else {
					result += "O";
				}

				cout << result << endl;
			}
		}
	}

	return 0;
}