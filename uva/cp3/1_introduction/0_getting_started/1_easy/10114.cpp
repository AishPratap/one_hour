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

int dur, rec, month;
double down, amount, dep;

int main() {
	std::ios::sync_with_stdio(false);
	// freopen("_in","r",stdin);
   	// freopen("_out","w",stdout);

	while (true) {
		cin >> dur >> down >> amount >> rec;
		if (dur <= 0) {
			break;
		}

		double rec_dep[dur + 1];

		for (int i = 0; i < rec; ++i) {
			cin >> month >> dep;
			for (int j = month; j < dur + 1; ++j) {
				rec_dep[j] = dep;
			}
		}

		double monthly_pay = amount / dur;
		double car_worth = (amount + down) * (1.0 - rec_dep[0]);

		if (amount < car_worth) {
			cout << "0 months" << endl;
		} else {
			int end_month = 1;
			while(true) {
				amount -= monthly_pay;
				car_worth *= (1.0 - rec_dep[end_month]);
				if (amount < car_worth) {
					break;
				}

				end_month += 1;
			}

			if (end_month == 1) {
				cout << "1 month" << endl;
			} else {
				cout << end_month << " months" << endl;
			}
		}
	}

	return 0;
}