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
#define v(type) vector<type>

using namespace std;

int n;
ll a;

int main() {
	std::ios::sync_with_stdio(false);
	// freopen("_in", "r", stdin);
	// freopen("_out","w",stdout);

	cin >> n;
	// cout << "DEBUG: n " << n << endl;
	int dif = 0;

	if (n == 1) {
		cout << 1 << endl;
		return 0;
	}

	ll matrix[n][n];

	forall(i, 0, n) {
		forall(j, 0, n) {
			cin >> matrix[i][j];
		}
	}

	set<ll> mset;
	// row
	// cout << "DEBUG: n " << n << endl;
	forall(i, 0, n) {
		ll sum = 0;
		forall(j, 0, n) {
			sum += matrix[i][j];
		}
		// cout << "row sum : " << sum << endl;
		mset.insert(sum);
		if (mset.size() > 2) {
			cout << -1 << endl;
			return 0;
		}
	}
	// col
	forall(i, 0, n) {
		ll sum = 0;
		forall(j, 0, n) {
			sum += matrix[j][i];
		}
		mset.insert(sum);
		if (mset.size() > 2) {
			cout << -1 << endl;
			return 0;
		}
	}
	ll diasum = 0, diasum2=0;
	forall(i, 0, n) {
		// cout << "DEBUG: " << matrix[i][i] << " " << matrix[i][n - 1 - i] << endl;
		diasum += matrix[i][i];
		diasum2 += matrix[i][n - 1 - i];
	}
	mset.insert(diasum);
	mset.insert(diasum2);
	if (mset.size() > 2) {
		cout << -1 << endl;
		return 0;
	}

	set<ll>::iterator first = mset.begin();
	set<ll>::iterator second = first; ++second;

	cout << abs(*first - *second) << endl;

	return 0;
}