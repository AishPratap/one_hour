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

string str;

string solve(const string& str) {
	string result = "";
	string buffer = "";
	deque<string> d;

	bool right = true;

	forall(i, 0, str.size()) {
		char c = str[i];
		if (c == '[' || c == ']') {
			if (right) {
				d.pb(buffer);
			} else {
				d.pf(buffer);
			}
			buffer.clear();
			if (c == '[') {
				right = false;
			} else {
				right = true;
			}
		} else {
			buffer += c;
		}
	}

	if (right) {
		d.pb(buffer);
	} else {
		d.pf(buffer);
	}

	for(deque<string>::iterator it = d.begin(); it != d.end(); ++it) {
		result += *it;
	}

	return result;
}

int main() {
	std::ios::sync_with_stdio(false);
	// freopen("_in", "r", stdin);
	// freopen("_out", "w", stdout);

	while (cin >> str) {
		cout << solve(str) << endl;
	}

	return 0;
}