#include<iostream>
#include<bits/stdc++.h>

using namespace std;
int dp[1001][1001];

int main() {
    int t;
    cin >> t;

    memset(dp, -1, sizeof(dp));

    while(t--) {
        int n, k;
        cin >> n >> k;

        cout << solve(n,k) << endl;
    }

}

int solve(int n, int k) {
    if(n == 1) return 0;

    if(dp[n][k] != -1) return dp[n][k];

    return dp[n][k] = (k-1)*(1+solve(n/k,k)) + 1+ solve(n-(k-1)*n/k,k);
}