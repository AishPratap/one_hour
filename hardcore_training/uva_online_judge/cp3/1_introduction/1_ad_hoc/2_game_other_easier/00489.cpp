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

using namespace std;

int r;
string str, gue;

int main() {
	std::ios::sync_with_stdio(false);
	freopen("_in","r",stdin);
    freopen("_out","w",stdout);

    int tcase = 1;

    while (true) {

        bool dead = false;
        bool win = false;

    	cin >> r;
    	if (r == -1) {
    		break;
    	}
    	cin >> str >> gue;
    	set<char> answer;
    	forel(i, str) {
    		answer.insert(str[i]);
    	}
    	int wrong = 0;
    	set<char> guessed;
    	forel(i, gue) {
            char c = gue[i];
            if (!contains(c,guessed)) {
                // cout << "DEBUG: new guess: " << c << endl;
                guessed.insert(c);
                if (!contains(c, answer)) {
                    wrong += 1;
                    if (wrong >= 7) {
                        dead = true;
                        break;
                    }
                } else {
                    answer.erase(c);
                    if (answer.empty()) {
                        win = true;
                        break;
                    }
                }
            }
    	}

        cout << "Round " << tcase++ << endl;
        if (win) {
            cout << "You win." << endl;
        } else if (dead) {
            cout << "You lose." << endl;
        } else {
            cout << "You chickened out." << endl;
        }
        // cout << "DEBUG: " << wrong << "->" << answer.size() << endl;
    }

	return 0;
}