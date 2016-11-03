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
#define lie(i, a, b) (i >= b && i <= b)
#define is_alpha(c) (lie(c, 'a', 'z') || lie(c, 'A', 'Z'))

using namespace std;

int t;
string str;

bool ana(string a, string b) {
	string ra = "", rb = "";
	forel(i, a) {
		char c = a[i];
		if (c != ' ') {
			ra += tolower(c);
		}
	}
	forel(i, b) {
		char c = b[i];
		if (c != ' ') {
			rb += tolower(c);
		}
	}
	sort(all(ra));
	sort(all(rb));

	return ra == rb;
}

// int main() {
// 	cout << ana("carthorse", "horse     cart") << endl;
// 	return 0;
// }

int main() {
	std::ios::sync_with_stdio(false);
	freopen("_in", "r", stdin);
	freopen("_out", "w", stdout);

	cin >> t;
	cin.ignore();
	bool nl = false;

	getline(cin, str);

	while (t--) {
		vector<string> v;
		while (true) {
			getline(cin, str);
			if (str == "") {
				break;
			}
			v.pb(str);
		}

		if (nl) {
			cout << endl;
		} else {
			nl = true;
		}

		sort(all(v));
		forall(i, 0, v.size()) {
			forall(j, i + 1, v.size()) {
				// cout << "DEBUG: " << v[i] << "|" << v[j] << endl;
				if (ana(v[i], v[j])) {
					cout << v[i] << " = " << v[j] << endl;
					// cout << "\tDEBUG: BINGO" << endl;
				}
			}
		}
	}

	return 0;
}