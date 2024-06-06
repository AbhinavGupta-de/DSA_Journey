#include <iostream>
#include <vector>
using namespace std;

const int MOD = 1e9 + 7;

int coinCombinations(int x, vector<int>& coins) {
    vector<int> dp(x + 1, 0);

    for (int curr = x; curr >= 0; curr--) {
        if (curr == x) {
            dp[curr] = 1;
            continue;
        }

        for (int coin : coins) {
            if (curr + coin <= x) {
                dp[curr] = (dp[curr] + dp[curr + coin]) % MOD;
            }
        }
    }

    return dp[0];
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, x;
    cin >> n >> x;
    vector<int> coins(n);
    for (int i = 0; i < n; i++) {
        cin >> coins[i];
    }

    int ans = coinCombinations(x, coins);
    cout << ans << endl;

    return 0;
}
