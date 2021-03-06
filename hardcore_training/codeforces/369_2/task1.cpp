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
#define nperm next_permutation
#define forel(i, str) forall(i, 0, str.size())
#define contains(needle,haystack) (haystack.find(needle) != haystack.end())
#define strlower(data) transform(data.begin(), data.end(), data.begin(), ::tolower)
#define strupper(data) transform(data.begin(), data.end(), data.begin(), ::toupper)
#define umap unordered_map
#define pb(i) push_back(i)
#define pf(i) push_front(i)
#define is_pow2(a) ((a & (a - 1)) == 0)
#define between(a, b, c) (a >= b && a <= c)
#define pq priority_queue
#define v(type) vector<type>

using namespace std;

int n;
string str;

int main() {
	std::ios::sync_with_stdio(false);
	// freopen("_in", "r", stdin);
	// freopen("_out", "w", stdout);

	cin >> n;
	v(string) bus;
	bus.resize(n);
	bool pos = false;
	forall(i, 0, n) {
		cin >> str;
		if (!pos) {
			if (str[0] == str[1] && str[1] == 'O') {
				str[0] = '+';
				str[1] = '+';
				pos = true;
			} else if (str[3] == str[4] && str[4] == 'O') {
				str[3] = '+';
				str[4] = '+';
				pos = true;
			}
		}
		bus[i] = str;
	}

	if (pos) {
		cout << "YES" << endl;
		forall(i, 0, n) {
			cout << bus[i] << endl;
		}
	} else {
		cout << "NO" << endl;
	}

	return 0;
}
