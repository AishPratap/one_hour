#include <bits/stdc++.h>

#define forall(i,a,b) for(int i=a;i<b;i++)
#define all(a) a.begin(), a.end()
#define pb push_back
#define fill(a,v)  memset(a, v, sizeof a)
#define mp make_pair
#define maX(a,b)  ( (a) > (b) ? (a) : (b))
#define miN(a,b)  ( (a) < (b) ? (a) : (b))
#define checkbit(n,b)  ( (n >> b) & 1)
#define ll long long

using namespace std;

int n, b, h, w, p, a;

int main() {
	// std::ios::sync_with_stdio(false);
	//freopen("_in","r",stdin);
   // freopen("_out","w",stdout);

	while(scanf("%d %d %d %d", &n, &b, &h, &w) != EOF) {
		int money = INT_MAX;
		while(h--) {
			scanf("%d", &p);
			for (int i = 0; i < w; ++i) {
				scanf("%d", &a);
				if (a >= n) {
					money = miN(money, n * p);
				}
			}
		}
		if (money > b) {
			printf("stay home\n");
		} else {
			printf("%d\n", money);
		}
	}

	return 0;
}