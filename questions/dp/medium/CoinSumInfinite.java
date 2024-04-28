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
  int MOD = 1000000007;
  if (amount == 0)
   return 1;

  if (pos >= coins.length)
   return 0;

  if (amount < 0)
   return 0;

  if (dp[pos][amount] != -2)
   return dp[pos][amount];

  int ways1 = helper(amount - coins[pos], coins, pos, dp);
  int ways2 = helper(amount, coins, pos + 1, dp);
  int ways = ((ways1 % MOD) + (ways2 % MOD)) % MOD;
  return dp[pos][amount] = ways;
 }
}
