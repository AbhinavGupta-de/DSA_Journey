#include <vector>
#include <bits/stdc++.h>

using namespace std;

const int maxLimit = 1e6 + 1;
long long dp[maxLimit];

long long minimalCoins(vector<int>& coins, int target) {
    if(target == 0) return 0;
    if (dp[target] != -1) return dp[target];
    long long ways = INT_MAX;
    for(auto &i : coins) {
        if(i <= target) ways = min(ways, minimalCoins(coins, target - i) + 1);
        else break;
    }

    return dp[target] = ways;
}