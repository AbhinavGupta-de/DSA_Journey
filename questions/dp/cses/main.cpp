#include <iostream>
#include <vector>
#include <cstring>
using namespace std;

const long long MOD = 1e9 + 7;
long long dp[100001][101];

long long arrayDescription(vector<long long>& nums, long long limit, long long n, long long pos, long long prev) {
    if (pos == n) return 1;
    if (dp[pos][prev] != -1) return dp[pos][prev];
    if (nums[pos] != 0) {
        if (abs(nums[pos] - prev) > 1 && pos != 0) return 0;
        return dp[pos][prev] = arrayDescription(nums, limit, n, pos + 1, nums[pos]) % MOD;
    }
    long long ans = 0;
    for (long long i = 1; i <= limit; i++) {
        if (abs(i - prev) > 1 && pos != 0) continue;
        nums[pos] = i;
        ans = (ans % MOD + arrayDescription(nums, limit, n, pos + 1, i) % MOD) % MOD;
        nums[pos] = 0;
    }
    return dp[pos][prev] = ans;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    long long n, m;
    cin >> n >> m;

    vector<long long> nums(n);
    for (long long i = 0; i < n; i++) {
        cin >> nums[i];
    }

    memset(dp, -1, sizeof(dp));

    cout << arrayDescription(nums, m, n, 0, 0) << endl;

    return 0;
}
