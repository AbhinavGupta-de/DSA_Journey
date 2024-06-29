#include <iostream>
#include <vector>
#include <bits/stdc++.h>
using namespace std;

const int MOD = 1e9 + 7;
long long dp[1000001];

long long removingDigit(int n) {
    if(n == 0) return 0;
    if(dp[n] != -1) return dp[n];
    long long ans = INT_MAX;
    for(char c : to_string(n)) {
        if(c == '0') continue;
        ans = min(ans, 1 + removingDigit(n - (c - '0')));
    }
    return dp[n] = ans;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;

    cin >> n;
    memset(dp, -1, sizeof(dp));

    long long ans = removingDigit(n);
    cout << ans << endl;

    return 0;
}
