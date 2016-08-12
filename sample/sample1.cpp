#include <bits/stdc++.h>
#define ll long long
using namespace std;
const int MAX = 1000005;
ll Ar[MAX];
vector <ll> vec[80];
//counting number of ones in binary representation.
ll count_one(ll a)
{
    ll coun=0;
    while(a>0)
    {
        coun++;
        a = a&(a-1);
    }
    return coun;
}
int main()
{
   freopen("i1.txt","r",stdin);
    freopen("o1.txt","w",stdout);
    int t;
    for(cin>>t;t;--t)
    {
        ll n;
        cin>>n;
        ll maxi=-1;
        for(int i=0;i<=70;i++)
        vec[i].clear();
        for(int i=0;i<n;i++)
        {
          cin>>Ar[i];
          ll num_one = count_one(Ar[i]);
           vec[num_one].push_back(Ar[i]);
           if(num_one > maxi)
           maxi=num_one;
        }
        for(int i=0;i<=maxi;i++)
        {
            for(int j=0;j<vec[i].size();j++)
            {
                if(i == maxi and j==vec[i].size()-1)
                {
                    cout<<vec[i][j]<<endl;
                }
                else
                {
                    cout<<vec[i][j]<<" ";
                }
            }
        }
    }
       return 0;
}