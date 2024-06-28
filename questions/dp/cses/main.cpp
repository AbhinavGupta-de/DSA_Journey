#include <iostream>
#include <vector>
#include <bits/stdc++.h>
using namespace std;

const int MOD = 1e9 + 7;
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

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, target;

    cin >> n >> target;

    vector<int> nums;

    for(int i = 0; i < n; i++) {
        int x;
        cin >> x;
        nums.push_back(x);
    }

    sort(nums.begin(), nums.end());

    memset(dp, -1, sizeof(dp));

    long ans = minimalCoins(nums, target);
    if (ans == INT_MAX) {
        cout << -1 << endl;
        return 0;
    }
    cout << ans << endl;

    return 0;
}
