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

int sum, dif;
int t;

int main() {
	std::ios::sync_with_stdio(false);
	// freopen("_in","r",stdin);
    // freopen("_out","w",stdout);

	cin >> t;
	while(t--) {
		cin >> sum >> dif;
		int a2 = sum + dif;

		bool im = false;

		if (a2 % 2 == 1) {
			im = true;
		}
		if (!im) {
			int a = a2 / 2;
			int b = sum - a;
			if (b < 0) {
				cout << "impossible" << endl;
			} else {
				cout << a << " " << b << endl;
			}
		} else {
			cout << "impossible" << endl;
		}
	}

	return 0;
}