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

using namespace std;

int t;
string str;

bool comp(char a, char b) {
	char la = tolower(a);
	char lb = tolower(b);
	if (la == lb) {
		return a < b;
	} else {
		return la < lb;
	}
}

int main() {
	std::ios::sync_with_stdio(false);
	// freopen("_in","r",stdin);
    // freopen("_out","w",stdout);

	cin >> t;
	while(t--) {
		cin >> str;
		sort(all(str), comp);
		string begin = str;
		while (true) {
			cout << str << endl;
			nperm(all(str), comp);
			if (str == begin) {
				break;
			}
		}
	}	

	return 0;
}