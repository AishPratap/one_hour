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

using namespace std;

string str;

string hash_string(string s) {
	strlower(s);
	sort(all(s));
	return s;
}

int main() {
	std::ios::sync_with_stdio(false);
	//freopen("_in","r",stdin);
    //freopen("_out","w",stdout);

    vector<string> words;
    umap<string, int> mmap;

    while (cin >> str) {
    	if (str == "#") {
    		break;
    	}
    	words.pb(str);
    	mmap[hash_string(str)] += 1;
    }

    vector<string> result;
    forel(i, words) {
    	if (mmap[hash_string(words[i])] == 1) {
    		result.pb(words[i]);
    	}
    }

    sort(all(result));

    forel(i, result) {
    	cout << result[i] << endl;
    }

	return 0;
}