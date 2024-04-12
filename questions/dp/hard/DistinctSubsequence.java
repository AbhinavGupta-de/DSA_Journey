package questions.dp.hard;

import java.util.*;

public class DistinctSubsequence {
 public int numDistinct(String s, String t) {
  int[][] dp = new int[s.length()][t.length()];
  Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));

  return helper(s, t, s.length() - 1, t.length() - 1, dp);
 }

 private int helper(String s, String t, int i, int j, int[][] dp) {
  if (i < 0 && j < 0)
   return 1;
  if (i < 0)
   return 0;
  if (j < 0)
   return 1;

  if (dp[i][j] != -1)
   return dp[i][j];

  int ans = 0;

  if (s.charAt(i) == t.charAt(j)) {
   ans += helper(s, t, i - 1, j, dp) + helper(s, t, i - 1, j - 1, dp);
  }

  else
   ans += helper(s, t, i - 1, j, dp);

  return dp[i][j] = ans;
 }
}
