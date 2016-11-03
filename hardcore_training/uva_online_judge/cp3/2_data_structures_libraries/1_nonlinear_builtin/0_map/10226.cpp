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

using namespace std;

int t;
string str;

int main() {
	std::ios::sync_with_stdio(false);
	// freopen("_in","r",stdin);
    // freopen("_out","w",stdout);

    cin >> t;
    cin.ignore();
    getline(cin, str);

    bool nl = false;

    while(t--) {
    	map<string, int> mmap;
    	int count = 0;
    	while(1) {
    		getline(cin, str);
    		if (cin.eof() || str.empty()) {
    			break;
    		}
    		count += 1;
    		mmap[str] += 1;
    		// each tree
    	} 
    	if (nl) {
    		cout << endl;
    	} else {
    		nl = true;
    	}

    	for(map<string, int>::iterator it = mmap.begin(); it != mmap.end(); ++it) {
    		string name = it->first;
    		int total = it->second * 100;
    		double avg = (double) total / count;
    		cout.precision(4);
    		cout << name << " " << fixed << avg << endl;
    	}
    	// each case
    }

	return 0;
}