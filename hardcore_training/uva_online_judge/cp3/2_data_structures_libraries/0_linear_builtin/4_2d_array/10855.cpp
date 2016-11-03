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

int big_length, small_length;
string str;

void rotate(v(v(int))& square) {	// check
	int length = square.size();
	int clone[length][length];
	forall(i, 0, length) {
		forall(j, 0, length) {
			clone[i][j] = square[i][j];
		}
	}

	forall(i, 0, length) {
		forall(j, 0, length) {
			square[i][j] = clone[length - 1 - j][i];
		}
	}
}

bool match(v(v(int)) big_square, v(v(int)) small_square, int row, int col) {
	bool result = true;

	forall(i, row, small_square.size()) {
		forall(j, col, small_square.size()) {
			if (small_square[i][j] != big_square[i][j]) {
				result = false;
				break;
			}
		}
	}

	return result;
}

int slide_match(v(v(int)) small_square, v(v(int)) big_square) {
	int result = 0;
	int small_length = small_square.size();
	int big_length = big_square.size();

	forall(i, 0, big_length - small_length) {
		forall(j, 0, big_length - small_length) {
			if (match(small_square, big_square, i, j)) {
				result += 1;
			}
		}
	}

	return result;
}

void solve(v(v(int)) big_square, v(v(int)) small_square) {
	int d0 = slide_match(small_square, big_square);
	rotate(small_square);

	int d90 = slide_match(small_square, big_square);
	rotate(small_square);

	int d180 = slide_match(small_square, big_square);
	rotate(small_square);

	int d270 = slide_match(small_square, big_square);
	rotate(small_square);

	cout << d0 << " " << d90 << " " << d180 << " " << d270 << endl;
}

int main() {
	std::ios::sync_with_stdio(false);
	freopen("_in","r",stdin);
    // freopen("_out","w",stdout);

    while(cin >> big_length >> small_length) {
    	if(!big_length && !small_length) {
    		break;
    	}

    	cout << "DEBUG: blength, slenght: " << big_length << " " << small_length << endl;

    	v(v(int)) big_square;
    	big_square.resize(big_length);
    	forall(i, 0, big_length) {
    		big_square[i].resize(big_length);
    	}
    	v(v(int)) small_square;
    	small_square.resize(small_length);
    	forall(i, 0, small_length) {
    		big_square[i].resize(small_length);
    	}

    	forall(i,0,big_length) {
    		forall(j,0,big_length) {
    			cin >> big_square[i][j];
    		}
    	}
    	forall(i,0,small_length) {
    		forall(j,0,small_length) {
    			cin >> small_square[i][j];
    		}
    	}


    	cout << "DEBUG:" << endl;
    	forall(i,0,big_length) {
    		forall(j, 0, big_length) {
    			cout << big_square[i][j] << " ";
    		}
    		cout << endl;
    	}


    	solve(big_square, small_square);

    	// case
    }

	return 0;
}