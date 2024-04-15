package dp.medium;

import java.util.*;

public class CoinSumInfinite {
 public int coinchange2(int[] A, int B) {
  return change(B, A);
 }

 public int change(int amount, int[] coins) {
  int[][] dp = new int[coins.length][amount];
  Arrays.stream(dp).forEach(a -> Arrays.fill(a, -2));

  return helper(amount, coins, 0, dp);
 }

 private int helper(int amount, int[] coins, int pos, int[][] dp) {
  if (amount == 0)
   return 1;

  if (pos >= coins.length)
   return 0;

  if (dp[pos][amount] != -2)
   return dp[pos][amount];

  int n = 0;
  int ways = 0;
  while (n * coins[pos] <= amount) {
   ways = (ways + helper(amount - n * coins[pos], coins, pos + 1, dp));
   n++;
  }

  return dp[pos][amount] = ways;
 }
}
