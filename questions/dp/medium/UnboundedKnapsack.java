package dp.medium;

import java.util.*;

public class UnboundedKnapsack {
 public int solve(int A, int[] B, int[] C) {
  int[][] dp = new int[B.length][A + 1];
  Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
  return helper(C, B, A, 0, dp);
 }

 private int helper(int[] weight, int[] values, int target, int pos, int[][] dp) {
  if (pos == weight.length || target == 0) {
   return 0;
  }

  if (dp[pos][target] != -1)
   return dp[pos][target];

  int n = 0;
  int ways = 0;
  while (n * weight[pos] <= target) {
   ways = Math.max(ways, n * values[pos] + helper(weight, values, target - n * weight[pos], pos + 1, dp));
   n++;
  }

  return dp[pos][target] = ways;
 }
}
