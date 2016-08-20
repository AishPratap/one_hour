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

int n, p, met;
string str;
float price;

int main() {
	std::ios::sync_with_stdio(false);
	// freopen("_in","r",stdin);
    // freopen("_out","w",stdout);

	int tcase = 1;
	bool nl = false;

	while (true) {

		int max_met = 0;
		float min_price = 0;
		string best = "";

		cin >> n >> p;
		if (!n && !p) {
			break;
		}
		cin.ignore();

		while(n--) {
			getline(cin, str);
		}

		while(p--) {
			getline(cin, str);
			cin >>  price >> met;
			cin.ignore();

			if (met > max_met) {
				max_met = met;
				best = str;
				min_price = price;
			} else if (met == max_met) {
				if (price < min_price) {
					best = str;
					min_price = price;
				}
			}

			while(met--) {
				getline(cin, str);
			}
		}

		if (nl) {
			cout << endl;
		} else {
			nl = true;
		}

		cout << "RFP #" << tcase++ << endl;
		cout << best << endl;
	}

	return 0;
}