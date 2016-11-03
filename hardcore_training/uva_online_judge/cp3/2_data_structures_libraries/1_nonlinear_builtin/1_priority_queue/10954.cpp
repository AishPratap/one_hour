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

using namespace std;

int t, a;

int main() {
	std::ios::sync_with_stdio(false);
	// freopen("_in","r",stdin);
    // freopen("_out","w",stdout);

    while(cin >> t) {
    	if (!t) {
    		break;
    	}
    	pq<int, vector<int>, greater<int> > q;
    	while(t--) {
    		cin >> a;
    		// cout << "DEBUG: a " << a << endl;
    		q.push(a);
    	}
    	int price = 0;

    	while(q.size() >= 2) {
    		int top1 = q.top();
    		q.pop();
    		int top2 = q.top();
    		q.pop();
    		price += (top1 + top2);
    		q.push(top1 + top2);
    		// cout << "DEBUG: top1 top2: " << top1 << " " << top2 << endl;
    	}

    	cout << price << endl;
    }

	return 0;
}