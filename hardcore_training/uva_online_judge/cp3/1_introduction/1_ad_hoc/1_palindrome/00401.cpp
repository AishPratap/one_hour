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

char str[30];
unordered_map<char, char> mirror;

int main() {
	//std::ios::sync_with_stdio(false);
	freopen("_in", "r", stdin);
	freopen("_out","w",stdout);


	mirror['A'] = 'A';
	mirror['M'] = 'M';
	mirror['Y'] = 'Y';
	mirror['Z'] = '5';
	mirror['O'] = 'O';
	mirror['1'] = '1';
	mirror['2'] = 'S';
	mirror['E'] = '3';
	mirror['3'] = 'E';
	mirror['S'] = '2';
	mirror['5'] = 'Z';
	mirror['H'] = 'H';
	mirror['T'] = 'T';
	mirror['I'] = 'I';
	mirror['U'] = 'U';
	mirror['J'] = 'L';
	mirror['V'] = 'V';
	mirror['8'] = '8';
	mirror['W'] = 'W';
	mirror['L'] = 'J';
	mirror['X'] = 'X';

	while (scanf("%s", str) != EOF) {
		int i = 0, j = strlen(str) - 1;

		bool mir_str = true, pal_str = true;

		while (i <= j) {
			if (str[i] != str[j]) {
				pal_str = false;
			}

			if (!mirror[str[i]]) {
				mir_str = false;
			} else {
				if (mirror[str[i]] != str[j]) {
					mir_str = false;
				}
			}

			i += 1;
			j -= 1;
		}

		if (pal_str) {
			if (mir_str) {
				printf("%s -- is a mirrored palindrome.\n", str);
			} else {
				printf("%s -- is a regular palindrome.\n", str);
			}
		} else {
			if (mir_str) {
				printf("%s -- is a mirrored string.\n", str);
			} else {
				printf("%s -- is not a palindrome.\n", str);
			}
		}
		printf("\n");
	}

	return 0;
}