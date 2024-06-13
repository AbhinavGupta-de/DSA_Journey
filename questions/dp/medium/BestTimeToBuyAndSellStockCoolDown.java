package questions.dp.medium;

public class BestTimeToBuyAndSellStockCoolDown {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;

        int[] buy = new int[n];
        int[] sell = new int[n];
        int[] cool = new int[n];

        buy[0] = -prices[0];
        sell[0] = 0;
        cool[0] = 0;

        for (int i = 1; i < n; i++) {
            buy[i] = Math.max(buy[i - 1], cool[i - 1] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
            cool[i] = Math.max(cool[i - 1], sell[i - 1]);
        }

        return sell[n - 1];
    }

    public int maxProfitConstSpace(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[2][3];

        dp[0][0] -= prices[0];

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < 3; j++) {
                int last = (i + 1)%2;
                if(j == 0) dp[i%2][j] = Math.max(dp[last][j], dp[last][2] - prices[i]);
                if(j == 1) dp[i%2][j] = Math.max(dp[last][j], dp[last][0] + prices[i]);
                if(j == 2) dp[i%2][j] = Math.max(dp[last][j], dp[last][1]);
            }
        }

        return dp[(n+1)%2][1];
    }
}