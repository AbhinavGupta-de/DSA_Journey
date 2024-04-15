package questions.dp.medium;

/**
 * WineProb
 */
public class WineProb {

 public int maxProfit(int[] wines, int start, int end, int[][] dp) {
  if (start > end)
   return 0;

  if (dp[start][end] != -1)
   return dp[start][end];

  int year = start + (wines.length - end);

  int left = wines[start] * year + maxProfit(wines, start + 1, end, dp);
  int right = wines[end] * year + maxProfit(wines, start, end - 1, dp);

  return dp[start][end] = Math.max(left, right);
 }

}