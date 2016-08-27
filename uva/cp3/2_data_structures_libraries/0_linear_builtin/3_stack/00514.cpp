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

int n, a;

bool is_possible(int train[], int n) {

	// forall(i, 0, n) {
	// 	cout << train[i] << " ";
	// }
	// cout << endl;


	stack<int> station;
	int head = 0;
	forall(i, 1, n + 1) {
		station.push(i);
		while(!station.empty() && station.top() == train[head]) {
			station.pop();
			head += 1;
		}
	}

	return station.empty();
}

int main() {
	std::ios::sync_with_stdio(false);
	// freopen("_in","r",stdin);
    // freopen("_out","w",stdout);

    while(cin >> n) {
    	if (!n) {
    		break;
    		// end
    	}

    	int train[n];
    	while(1) {
    		cin >> a;
    		if (!a) {
    			break;
    		}
    		train[0] = a;
    		forall(i, 1, n) {
    			cin >> train[i];
    		}
            cout << (is_possible(train, n) ? "Yes" : "No") << endl;
    	}
        cout << endl;
    }
	return 0;
}