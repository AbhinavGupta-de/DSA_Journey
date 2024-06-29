#include <iostream>
#include <vector>
#include <bits/stdc++.h>
using namespace std;

const int MOD = 1e9 + 7;

long long dp[1001][1001];

long long gridPath(vector<vector<char>> &grid, int i, int j, int n) {
    if (i == n - 1 && j == n - 1) return grid[i][j] == '.';
    if (i >= n || j >= n) return 0;
    if (dp[i][j] != -1) return dp[i][j];
    if (grid[i][j] == '*') return 0;
    return dp[i][j] = (gridPath(grid, i + 1, j, n)%MOD + gridPath(grid, i, j + 1, n)%MOD)%MOD;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;

    cin >> n;

    vector<vector<char>> grid(n, vector<char>(n));

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> grid[i][j];
        }
    }

    memset(dp, -1, sizeof(dp));

    cout << gridPath(grid, 0, 0, n) % MOD << endl;
}
