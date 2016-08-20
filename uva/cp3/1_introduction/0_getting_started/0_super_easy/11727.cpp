#include <bits/stdc++.h>

#define forall(i,a,b) for(int i=a;i<b;i++)
#define foreach(v, c) for( typeof( (c).begin()) v = (c).begin();  v != (c).end(); ++v)
#define all(a) a.begin(), a.end()
#define fill(a,v)  memset(a, v, sizeof a)
#define maX(a,b)  ( (a) > (b) ? (a) : (b))
#define miN(a,b)  ( (a) < (b) ? (a) : (b))
#define checkbit(n,b)  ( (n >> b) & 1)
#define ll long long
#define pb push_back
#define endln '\n'

using namespace std;

int t, tmp;
int main() {
	std::ios::sync_with_stdio(false);
	freopen("_in","r",stdin);
    // freopen("_out","w",stdout);

	cin >> t;
	for (int c = 1; c <= t; ++c) {
		vector<int> a;
		for (int i = 0; i < 3; ++i) {
			cin >> tmp;
			a.pb(tmp);
		}
		sort(all(a));
		cout << "Case " << c << ": " << a[1] << endl;
	}

	return 0;
}