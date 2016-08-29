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

int n, a, x;

long f(int num, int required, map<int, int> occ) {
	// cout << "-------" << endl;
	// cout << "DEBUG: " << num << " " << required << endl;
	// for(map<int,int>::iterator it = occ.begin(); it != occ.end(); ++it) {
	// 	cout << it->first << " " << it->second << endl;
	// }

	int total = 0;
	if (num <= 1) {
		// cout << "DEBUG:1: " << occ[required] << endl;
		return occ[required];
	} else {
		for(map<int, int>::iterator it = occ.begin(); it != occ.end(); ++it) {
			while(it->second > 0) {
				it->second -= 1;
				total += f(num - 1, required - it->first, occ);
			}
		}
		return total;
	}
}

int main() {
	std::ios::sync_with_stdio(false);
	// freopen("_in","r",stdin);
    // freopen("_out","w",stdout);

   	map<int, int> occ;

    cin >> n >> a;
    forall(i, 0, n) {
    	cin >> x;
    	occ[x] += 1;
    }

    long total = 0;
    forall(i, 1, n + 1) {
    	total += f(i, a * i, occ);
    }
    cout << total << endl;

	return 0;
}