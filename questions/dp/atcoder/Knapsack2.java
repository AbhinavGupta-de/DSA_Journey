public class Knapsack2 {

    public int knapsack(int N, int W, int[][] sacks) {

        int[][] dp = new int[110][(int) 1e5 + 10];
        int ans = 0;
        for (int profit = 0; profit <= (int) 1e5; profit++) {
            if (possibleMinWeight(0, profit, dp, sacks) <= W) {
               ans = profit;
            }
        }

        return ans;
    }

    private int possibleMinWeight(int index, int profit, int[][] dp, int[][] sacks) {
        if (index == N) {
            if (profit == 0) return 0;
            return Integer.MAX_VALUE;
        }

        if (dp[index][profit] != -1) return dp[index][profit];

        long ans = possibleMinWeight(index + 1, profit, dp);
        if (profit >= sacks[index][1]) {
            ans = Math.min(ans, weights[index] + possibleMinWeight(index + 1, profit - profits[index], dp));
        }

        return dp[index][profit] = ans;
    }

}