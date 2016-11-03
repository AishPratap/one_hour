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

int t, p, l, cp;
char str[10010], c;

float get_money(char str[], umap<char, float>& mmap) {
	float total = 0;
	// printf("DEBUG: string: %s\n", str);
	forall(i, 0, strlen(str)) {
		// cout << "DEBUG: real: " << str[i] << " " << mmap[str[i]] << endl; 
		total += mmap[str[i]];
	}
	// cout << "DEBUG: total: " <<  total << endl;
	return total;
}

int main() {
	// std::ios::sync_with_stdio(false);
	// freopen("_in","r",stdin);
    // freopen("_out","w",stdout);

    scanf("%d\n", &t);
    // cout << "DEBUG: t " << t << endl;
    while(t--) {
    	scanf("%d\n", &p);
    	// cout << "DEBUGE: p: " << p << endl;
    	umap<char, float> mmap;
    	while(p--) {
    		scanf("%c %d\n", &c, &cp);
    		mmap[c] = cp / 100.0;
    		// cout << "DEBUG: c, cp: " << c << " " << cp << endl;
    		// paid characters
    	}
    	scanf("%d\n", &l);
    	// cout << "DEBUG: l : " << l << endl;
    	float total = 0;
    	while(l--) {
    		// scanf("%s\n", str); Fucking failure!
    		fgets(str, 10010, stdin);
    		total += get_money(str, mmap);
    		// line
    	}
    	printf("%.2f$\n", total);
    	//case
    }

	return 0;
}