package dp.medium;

import java.util.Arrays;

public class ZeroOneKnapsack {
 public int knapsack(int[] weight, int[] value, int n, int maxWeight) {
  int[][] dp = new int[n + 1][maxWeight + 1];
  Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
  return helper(weight, value, maxWeight, 0, dp);
 }

 private int helper(int[] weight, int[] value, int maxWeight, int pos, int[][] dp) {
  if (maxWeight == 0 || pos <= weight.length)
   return 0;

  if (dp[pos][maxWeight] != -1)
   return dp[pos][maxWeight];

  if (maxWeight >= weight[pos]) {
   int takeIt = value[pos] + helper(weight, value, maxWeight - weight[pos], pos + 1, dp);
   int notTakeIt = helper(weight, value, maxWeight, pos + 1, dp);
   return dp[pos][maxWeight] = Math.max(takeIt, notTakeIt);
  } else {
   return dp[pos][maxWeight] = helper(weight, value, maxWeight, pos + 1, dp);
  }

 }
}
