#include <iostream>
#include <vector>
#include <bits/stdc++.h>
using namespace std;

const int MOD = 1e9 + 7;
const int highLimit = 1e6 + 1;
int dp[highLimit][2];



int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, x;
    cin >> n >> x;
    vector<int> coins(n);
    for (int i = 0; i < n; i++) {
        cin >> coins[i];
    }

    int ans = coinCombinations2(x, coins);
    cout << ans << endl;

    return 0;
}
