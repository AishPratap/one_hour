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
#define is_pow2(a) ((a & (a - 1)) == 0)
#define between(a, b, c) (a >= b && a <= c)

using namespace std;

long a;

long at(const vector<long>& s, int index) {
	return s[index];
}

long get_med(const vector<long>& s) {
	int size = s.size();
	if (size % 2 == 1) {
		return at(s, size / 2);
	} else {
		int isec = size / 2;
		int ifirst = isec - 1;
		long valfirst = at(s, ifirst);
		long valsec = at(s, isec);

		return (valfirst + valsec) / 2;
	}
}

int main() {
	std::ios::sync_with_stdio(false);
	// freopen("_in","r",stdin);
    // freopen("_out","w",stdout);

    vector<long> s;

    while(cin >> a) {
    	s.pb(a);
    	sort(all(s));
    	cout << get_med(s) << endl;
    }

	return 0;
}