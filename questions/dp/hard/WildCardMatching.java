package questions.dp.hard;

import java.util.Arrays;

/**
 * WildCardMatching
 */
public class WildCardMatching {
 public boolean isMatch(String s, String p) {
  int[][] dp = new int[s.length()][p.length()];
  Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
  return helper(s, p, s.length() - 1, p.length() - 1, dp) == 1;
 }

 private int helper(String s, String p, int i, int j, int[][] dp) {
  if (i < 0 && j < 0)
   return 1;
  if (j < 0)
   return 0;
  if (i < 0) {
   if (p.charAt(j) != '*')
    return 0;
   return helper(s, p, i, j - 1, dp);
  }

  if (dp[i][j] != -1)
   return dp[i][j];

  int ans = 0;

  if (s.charAt(i) == p.charAt(j))
   ans |= helper(s, p, i - 1, j - 1, dp);

  if (p.charAt(j) == '?')
   ans |= helper(s, p, i - 1, j - 1, dp);

  if (p.charAt(j) == '*') {
   ans = ans | (helper(s, p, i - 1, j, dp) | helper(s, p, i, j - 1, dp));
  }
  return dp[i][j] = ans;

 }

}