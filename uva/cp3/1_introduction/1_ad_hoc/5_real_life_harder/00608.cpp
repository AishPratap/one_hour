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

using namespace std;

string l, r, status;
int t, coin[12];

int main() {
	std::ios::sync_with_stdio(false);
	freopen("_in","r",stdin);
    // freopen("_out","w",stdout);

    cin >> t;
    // 0: nope, 1: lighter, 2: heavier, -1: true coin
    while(t--) {
    	fill(coin, 0);
    	forall(z, 0, 3) {
    		cin >> l >> r >> status;
    		if (status == "even") {
    			forel(i, l) {
    				int index = l[i] - 'A';
    				coin[index] = -1;
    			}
    			forel(i, r) {
    				int index = r[i] - 'A';
    				coin[index] = -1;
    			}

    		} else if (status == "up") {
    			forel(i, l) {
    				int index = l[i] - 'A';
    				if (coin[index] == 0) {
    					coin[index] = 2;
    				}
    			}
    			forel(i, r) {
    				int index = r[i] - 'A';
    				if (coin[index] == 0) {
    					coin[index] = 1;
    				}
    			}
    		} else {
    			forel(i, l) {
    				int index = l[i] - 'A';
    				if (coin[index] == 0) {
    					coin[index] = 1;
    				}
    			}
    			forel(i, r) {
    				int index = r[i] - 'A';
    				if (coin[index] == 0) {
    					coin[index] = 2;
    				}
    			}
    		}
    	}
    	forall(i, 0, 12) {
    		cout << (char)(i + 'A') << ": " << coin[i] << endl;
    	}
    }

	return 0;
}