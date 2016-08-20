#include <stdio.h>
#include <ctype.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>
#include <stdbool.h>
#include <vector>
#include <algorithm>

#define ll long long

using namespace std;

int count_one(ll num) {
   int count = 0;
   while (num) {
      count += 1;
      num &= (num - 1);
   }

   return count;
}

bool comp(ll a, ll b) {
   return count_one(a) < count_one(b);
}

int main() {
   freopen("_in","r",stdin);
   // freopen("_out","w",stdout);

   int t, n;
   scanf("%d", &t);
   while (t--) {
      scanf("%d", &n);
      vector<ll> v;
      while (n--) {
         ll tmp;
         scanf("%lld", &tmp);
         v.push_back(tmp);
      }

      stable_sort(v.begin(), v.end(), comp);

      for (int i = 0; i < v.size(); ++i) {
         printf("%lld ", v[i]);
      }
      printf("\n");
   }

   return 0;
}