package questions.dp.medium;

import java.util.*;

/**
 * LongestIdealSequence
 */
public class LongestIdealSequence {

 public int longestIdealString(String s, int k) {
  int[][] dp = new int[s.length()][128];
  Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));

  return helperFunction(s, k, 0, '#', dp);
 }

 private int helperFunction(String s, int k, int idx, int ch, int[][] dp) {
  if (idx == s.length())
   return 0;
  if (dp[idx][ch] != -1)
   return dp[idx][ch];
  int pick = 0;
  if (Math.abs(ch - s.charAt(idx)) <= k || ch == '#') {
   pick = 1 + helperFunction(s, k, idx + 1, s.charAt(idx) - 'a', dp);
  }
  int notPick = helperFunction(s, k, idx + 1, ch, dp);
  return dp[idx][ch] = Math.max(pick, notPick);
 }
}