#include <vector>
#include <bits/stdc++.h>

using namespace std;

int dp[5001][5001];

long editDistance(int i, int j, string a, string b) {

    if(i < 0 && j < 0) return 0;
    if(i < 0) return j+1;
    if(j < 0) return i+1;

    if(dp[i][j] != -1) return dp[i][j];

    if(a[i] == b[j]) return dp[i][j] = editDistance(i-1, j-1, a, b);

    return dp[i][j] = 1 + min(editDistance(i-1, j-1, a, b), min(editDistance(i-1, j, a, b), editDistance(i, j-1, a, b)));
}

long editDistance(string a, string b) {
    memset(dp, -1, sizeof(dp));

    for(int i = 0; i < a.size(); i++) {
        for(int j = 0; j < b.size(); j++) {
            if(i == 0 && j == 0) {
                if(a[i] == b[j]) dp[i][j] = 0;
                else dp[i][j] = 1;
            } else if(i == 0) {
                if(a[i] == b[j]) dp[i][j] = j;
                else dp[i][j] = 1 + dp[i][j-1];
            } else if(j == 0) {
                if(a[i] == b[j]) dp[i][j] = i;
                else dp[i][j] = 1 + dp[i-1][j];
            } else {
                if(a[i] == b[j]) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = 1 + min(dp[i-1][j-1], min(dp[i-1][j], dp[i][j-1]));
            }
        }
    }

    return dp[a.size()-1][b.size()-1];
}