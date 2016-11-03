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
#define contains(needle,haystack) haystack.find(needle) != haystack.end()


using namespace std;

int main() {
	std::ios::sync_with_stdio(false);
	freopen("_in","r",stdin);
    // freopen("_out","w",stdout);

    set<int> a;
    a.insert(3);
    a.insert(4);
    a.insert(5);
    a.insert(2);
    a.insert(1);

    bool z = contains(3, a);
    cout << z << endl;

	return 0;
}