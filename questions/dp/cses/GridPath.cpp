#include <vector>
#include <bits/stdc++.h>

using namespace std;

long long dp[1001][1001];

long long gridPath(vector<vector<char>> &grid, int i, int j, int n) {
    if (i == n - 1 && j == n - 1) return grid[i][j] == '.';
    if (i >= n || j >= n) return 0;
    if (dp[i][j] != -1) return dp[i][j];
    if (grid[i][j] == '*') return 0;
    return dp[i][j] = (gridPath(grid, i + 1, j, n)%MOD + gridPath(grid, i, j + 1, n)%MOD)%MOD;
}