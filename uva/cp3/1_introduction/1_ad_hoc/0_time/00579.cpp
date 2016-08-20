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

using namespace std;

int h, m;
double hour_deg = 30;
double min_deg = 6;


int main() {
	// std::ios::sync_with_stdio(false);
	// freopen("_in","r",stdin);
    // freopen("_out","w",stdout);

	while (true) {
		scanf("%d:%d", &h, &m);

		if (!h && !m) {
			break;
		}

		double actual_hour = (double) h + (double) m / 60.0;

		double hour = actual_hour * hour_deg;
		double min = min_deg * m;

		// cout << "DEBUG: " << hour << " " << min << endl;

		double dif = abs(hour - min);
		if (dif > 180.0) {
			dif = 360 - dif;
		}

		printf("%.3f\n", dif);
	}

	return 0;
}