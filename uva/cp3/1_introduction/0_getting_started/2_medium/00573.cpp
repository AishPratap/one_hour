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

int h,u,d,f;

int main() {
	std::ios::sync_with_stdio(false);
	// freopen("_in","r",stdin);
    // freopen("_out","w",stdout);

	while (true) {
		cin >> h >> u >> d >> f;
		if (!h) {
			break;
		}

		double climb_today = (double) u;
		double daily_fail = climb_today * (double) f / 100.0;
		double climbed = 0.0;
		int day = 1;
		double height = (double) h;
		double slide_down = (double) d;

		bool success = true;

		// cout << "DEBUG: daily fail:" << daily_fail << endl;

		while (true) {
			climbed += climb_today;

			// cout << "DEBUG: climb today: " << climb_today << endl;
			// cout << "DEBUG: climbed: " << climbed << endl;

			climb_today = maX(0.0, climb_today - daily_fail);
			if (climbed > height) {
				break;
			}
			climbed -= slide_down;

			if (climbed < 0) {
				success = false;
				break;
			}

			day += 1;
		}

		if (success) {
			cout << "success on day " << day << endl;
		} else {
			cout << "failure on day " << day << endl;
		}
	}

	return 0;
}