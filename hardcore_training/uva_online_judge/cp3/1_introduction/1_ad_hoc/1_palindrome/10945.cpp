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
#define lie(i, a, b) (i >= a && i <= b)

using namespace std;

string str;

int main() {
	std::ios::sync_with_stdio(false);
	// freopen("_in","r",stdin);
    // freopen("_out","w",stdout);

	while (true) {
		getline(cin, str);
		if (str == "DONE") {
			break;
		}

		string refined = "";
		forall(i, 0, str.size()) {
			char c = str[i];
			if (lie(c, 'a', 'z') || lie(c, 'A', 'Z')) {
				c = tolower(c);
				refined += c;
			}
		}
		int i = 0, j = refined.size() - 1;
		bool pal = true;
		while (i <= j) {
			if (refined[i] != refined[j]) {
				pal = false;
				break;
			}
			i += 1;
			j -= 1;
		}

		if (pal) {
			cout << "You won't be eaten!" << endl;
		} else {
			cout << "Uh oh.." << endl;
		}
	}	    

	return 0;
}