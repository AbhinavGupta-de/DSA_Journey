package dp.medium;

import java.util.*;

public class PalindromePartition {
 public int minCut(String s) {
  int[] dp = new int[s.length()];
  Arrays.fill(dp, -1);
  Boolean[][] grid = new Boolean[s.length()][s.length()];
  return helper(s, 0, dp, grid) - 1;
 }

 private int helper(String s, int start, int[] dp, Boolean[][] grid) {
  if (start == s.length())
   return 0;

  if (dp[start] != -1)
   return dp[start];

  StringBuilder str = new StringBuilder();

  int min = Integer.MAX_VALUE;
  for (int i = start; i < s.length(); i++) {
   str.append(s.charAt(i));
   if (isPalin(s, start, i, grid)) {
    min = Math.min(helper(s, i + 1, dp, grid) + 1, min);
   }
  }

  return dp[start] = min;

 }

 private boolean isPalin(String s, int i, int j, Boolean[][] grid) {
  if (i >= j)
   return true;
  if (grid[i][j] != null)
   return grid[i][j];
  if (s.charAt(i) != s.charAt(j))
   return false;
  return grid[i][j] = isPalin(s, i + 1, j - 1, grid);
 }
}
