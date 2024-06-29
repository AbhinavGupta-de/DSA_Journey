#include <vector>
#include <bits/stdc++.h>

using namespace std;

long long dp[2][100001];

long long maxPages(vector<int>& prices, vector<int>& pages, int n, int x) {
//    if(n == 0 || x == 0) return 0;
//    if(dp[n][x] != -1) return dp[n][x];
//    if(prices[n-1] <= x) return dp[n][x] = max(pages[n-1] + maxPages(prices, pages, n-1, x-prices[n-1]), maxPages(prices, pages, n-1, x));
//    else return dp[n][x] = maxPages(prices, pages, n-1, x);

     for(int i = 1; i <= n; i++) {
        for(int j = 0; j <= x; j++) {
            if(j == 0) continue;
            dp[i%2][j] = dp[(i-1)%2][j];
            if(prices[i -1] <= j) {
                dp[i%2][j] = max(dp[i%2][j], pages[i-1] + dp[(i-1)%2][j-prices[i-1]]);
            }
        }
     }

    return dp[(n)%2][x];
}