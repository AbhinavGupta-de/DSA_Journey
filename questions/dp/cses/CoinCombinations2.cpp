#include <vector>
#include <bits/stdc++.h>
using namespace std;

const int MOD = 1e9 + 7;
const int hightLimit = 1e6 + 1;

int dp[hightLimit][2];

int coinCombinations2(int x, int i, vector<int>& coins) {
       if(x == 0) return 1;
       if(x < 0 || i == coins.size()) return 0;

        if(dp[x][i] != -1) return dp[x][i];

       int ans = 0;

       ans = (coinCombinations2(x - coins[i], i, coins) + ans) % MOD;
       ans = (coinCombinations2(x, i + 1, coins) + ans) % MOD;

        return dp[x][i] = ans;
}

int coinCombinations2(int x, vector<int>& coins) {

    dp[0][0] = 1;
    dp[0][1] = 1;

    for(int i = coins.size() - 1; i >= 0; i--) {

        for(int j = 1; j <= x; j++) {
            dp[j][i%2] = 0;

            if(j - coins[i] >= 0) {
                dp[j][i%2] = (dp[j - coins[i]][i%2] + dp[j][i%2]) % MOD;
            }

            if(i + 1 < coins.size()) {
                dp[j][i%2] = (dp[j][i%2] + dp[j][(i + 1)%2]) % MOD;
            }
        }
    }

    return dp[x][0];
}