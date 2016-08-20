#include <bits/stdc++.h>

#define forall(i,a,b) for(int i=a;i<b;i++)
#define all(a) a.begin(), a.end()
#define pb push_back
#define fill(a,v)  memset(a, v, sizeof a)
#define mp make_pair
#define maX(a,b)  ( (a) > (b) ? (a) : (b))
#define miN(a,b)  ( (a) < (b) ? (a) : (b))
#define checkbit(n,b)  ( (n >> b) & 1)
#define ll long long

using namespace std;

int t, n, a;

int main() {
	std::ios::sync_with_stdio(false);
	// freopen("_in","r",stdin);
    // freopen("_out","w",stdout);

	cin >> t;
	for (int tcase = 1; tcase <= t; ++tcase) {
		int max = 0;
		cin >> n;
		while(n--) {
			cin >> a;
			max = maX(max, a);
		}

		cout << "Case " << tcase << ": " << max << endl;
	}

	return 0;
}