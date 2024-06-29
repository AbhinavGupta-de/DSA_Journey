#include <iostream>
#include <vector>
#include <bits/stdc++.h>
using namespace std;

const int MOD = 1e9 + 7;

long long dp[2][100001];

long long maxPages(vector<int>& prices, vector<int>& pages, int n, int x) {


    for(int i = 1; i <= n; i++) {
        for(int j = 0; j <= x; j++) {
           if(j == 0) continue;
           dp[i%2][j] = dp[(i-1)%2][j];
           if(prices[i-1] <= j) {
               dp[i%2][j] = max(dp[i%2][j], pages[i-1] + dp[(i-1)%2][j-prices[i-1]]);
           }
        }
    }

    return dp[(n)%2][x];
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, x;

    cin >> n >> x;

    vector<int> prices(n), pages(n);

    for(int i = 0; i < n; i++) {
        cin >> prices[i];
    }

    for(int i = 0; i < n; i++) {
        cin >> pages[i];
    }

    memset(dp, 0, sizeof(dp));

    cout << maxPages(prices, pages, n, x) << endl;

    return 0;
}
