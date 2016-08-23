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

int t, players, warps, rolls;

int main() {
	std::ios::sync_with_stdio(false);
	// freopen("_in","r",stdin);
    // freopen("_out","w",stdout);

    cin >> t;
    while(t--) {
    	cin >> players >> warps >> rolls;
    	umap<int, int> mmap;
 	  	while(warps--) {
 	  		int from, to;
 	  		cin >> from >> to;
 	  		mmap[from] = to;

    	}
    	bool win = false;
    	int turn = 0;
    	int pos[players];
    	forall(i, 0, players) {
    		pos[i] = 1;
    	}
    	while(rolls--) {
    		int dice;
    		cin >> dice;
    		if (!win) {
    			pos[turn] += dice;

                if (contains(pos[turn], mmap)) {
                    pos[turn] = mmap[pos[turn]];
                }

    			if (pos[turn] >= 100) {
                    pos[turn] = 100;
                    win = true;
    			}
    		}
    		turn = (turn + 1) % players;
    	}

        forall(i, 0, players) {
            cout << "Position of player " << i + 1 << " is " << pos[i] << "." << endl;
        }
    }


	return 0;
}