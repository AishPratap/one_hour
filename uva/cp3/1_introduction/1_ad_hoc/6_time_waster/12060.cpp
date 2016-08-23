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

int n, a;

int gcd(int a, int b) {
	int t;
	while (b) {
		t = b;
		b = a % b;
		a = t;
	}

	return a;
}

void simplify(int&up, int&down) {
	int g = gcd(up, down);
	up /= g;
	down /= g;
}

void get_components(int&num, int&up, int&down, bool& pos) {
	pos = (up >= 0);
	num = abs(num);
	num = up / down;
	up -= (num * down);
	simplify(up, down);
}

void display(int num, int up, int down, bool pos, int ks) {
	cout << "Case " << ks << ":" << endl;
	num = abs(num);
	up = abs(up);
	down = abs(down);
	string central = "", upper = "", lower = "";
	if (!pos) {
		central += "- ";
	}
	if (num) {
		central += to_string(num);
	}
	if (up) {
		upper += to_string(up);
		lower += to_string(down);

		int lower_size = lower.size();

		for (int i = 0; i < lower_size; ++i) {
			central += "-";
		}
	}
	int cen_len = central.size();
	if(!upper.empty()) {
		cout.width(cen_len); cout << right << upper << endl;
	}
	cout << central << endl;
	if (!lower.empty()) {
		cout.width(cen_len); cout << right << lower << endl;
	}
}

int main() {
	std::ios::sync_with_stdio(false);
	// freopen("_in","r",stdin);
    // freopen("_out","w",stdout);

    int ks = 1;

    while(1) {
    	cin >> n;
    	if (!n) {
    		break;
    	}

    	int total = 0;

    	forall(z, 0, n) {
    		cin >> a;
    		total += a;
    	}

    	int num, up = total, down = n;
    	bool pos = true;
    	get_components(num, up, down, pos);
    	display(num, up, down, pos, ks++);
    }

	return 0;
}