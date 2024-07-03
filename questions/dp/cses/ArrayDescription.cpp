#include <vector>
#include <bits/stdc++.h>

using namespace std;

const int MOD = 1e9 + 7;
long long dp[101][101];

long long arrayDescription(vector<int>& nums, int limit, int n, int pos, int prev) {

    if(pos == n) return 1;

    if(dp[pos][prev] != -1) return dp[pos][prev];


    if(nums[pos] != 0) {
        if(abs(nums[pos] - prev) > 1 && pos != 0) {
            return 0;
        }
        return dp[pos][prev] = arrayDescription(nums, limit, n, pos+1, nums[pos]) % MOD;
    }

    long long ans = 0;

    for(int i = 1; i <= limit; i++) {
        if(abs(i - prev) > 1 || pos == 0) continue;
        nums[pos] = i;
        ans = (ans + arrayDescription(nums, limit, n, pos+1, i)) % MOD;
        nums[pos] = 0;
    }

    return dp[pos][prev] = ans;
}