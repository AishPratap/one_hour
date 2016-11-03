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

int n, a, b;

int main() {
	std::ios::sync_with_stdio(false);
	// freopen("_in","r",stdin);
    // freopen("_out","w",stdout);

    while(cin >> n) {
    	stack<int> stack;
    	queue<int> queue;
    	pq<int> pq;

    	bool bstack = true, bqueue = true, bpq = true;

    	while(n--) {
    		cin >> a >> b;
    		if (a == 1) {
    			stack.push(b);
    			queue.push(b);
    			pq.push(b);
    		} else {
    			bstack &= (b == stack.top());
    			if (!stack.empty()) stack.pop();
    			bqueue &= (b == queue.front());
    			if (!queue.empty()) queue.pop();
    			bpq &= (b ==  pq.top());
    			if (!pq.empty()) pq.pop();
    		}
    		// command
    	}
    	if (bstack && !bqueue && !bpq) {
    		cout << "stack" << endl;
    	} else if (!bstack && bqueue && !bpq) {
    		cout << "queue" << endl;
    	} else if (!bstack && !bqueue && bpq) {
    		cout << "priority queue" << endl;
    	} else if (bstack || bqueue || bpq) {
    		cout << "not sure" << endl;
    	} else {
    		cout << "impossible" << endl;
    	}
    	// case
    }

	return 0;
}