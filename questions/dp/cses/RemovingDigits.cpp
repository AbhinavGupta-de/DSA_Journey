#include <vector>
#include <bits/stdc++.h>

using namespace std;

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