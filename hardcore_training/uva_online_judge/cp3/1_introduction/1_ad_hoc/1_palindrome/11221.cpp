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

int t;
string curline;

// int main() {
// 	cout << is_pow2(2);
// 	return 0;
// }

bool is_square(int a) {
    int root = sqrt(a);
    return root*root == a;
}

int is_magic(string raw_str) {
    string str = "";
    forall(i, 0, raw_str.size()) {
        char c = raw_str[i];
        if (between(c, 'a', 'z')) {
            str += c;
        }
    }

    if (!is_square(str.size())) {
        return -1;
    }
    int len = sqrt(str.size());
    
    string str2 = "";
    for (int i = str.size() - 1; i >= 0; --i) {
        str2 += str[i];
    }   // reversed
    string str3 = "";
    for (int i = 0; i < len; ++i) {
        for (int j = 0; j < len; ++j) {
            int index = i + j*len;
            str3 += str[index];
        }
    }
    string str4 = "";
    for (int i = len - 1; i >= 0; --i) {
        for (int j = len - 1; j >= 0; --j) {
            int index = i + j*len;
            str4 += str[index];
        }
    }

    if ((str == str2) && (str == str3) && (str == str4)) {
        return len;
    }

    return -1;
}

void print_result(int a) {
    if (a > 0) {
        cout << a << endl;
    } else {
        cout << "No magic :(" << endl;
    }
}

// int main() {
//     cout << is_magic("sator arepo tenet opera rdotas") << endl;

//     return 0;
// }

int main() {
	std::ios::sync_with_stdio(false);
	// freopen("_in","r",stdin);
    // freopen("_out","w",stdout);

    cin >> t;
    cin.ignore();
    for (int ks = 1; ks <= t; ++ks) {
    	getline(cin, curline);
    	cout << "Case #" << ks << ":" << endl;
        print_result(is_magic(curline));
    }

	return 0;
}