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

int t, a, b;

int main() {
	std::ios::sync_with_stdio(false);
	//freopen("_in","r",stdin);
    // freopen("_out","w",stdout);

	cin >> t;
	while(t--) {
		cin >> a >> b;
		if (a < b) {
			cout << "<" << endl;
		} else if (a == b) {
			cout << "=" << endl;
		} else {
			cout << ">" << endl;
		}
	}

	return 0;
}