package dp.medium;

import java.util.*;

public class LongestCommonSubsequence {
 public int longestCommonSubsequence(String text1, String text2) {
  int[][] nums = new int[text2.length()][text1.length()];

  Arrays.stream(nums).forEach(a -> Arrays.fill(a, -1));

  return helper(text1, text2, text2.length() - 1, text1.length() - 1, nums);
 }

 private int helper(String a, String b, int i, int j, int[][] nums) {
  if (i < 0 || j < 0)
   return 0;

  if (nums[i][j] != -1)
   return nums[i][j];

  if (a.charAt(j) == b.charAt(i)) {
   nums[i][j] = helper(a, b, i - 1, j - 1, nums) + 1;
  }

  else {
   nums[i][j] = Math.max(helper(a, b, i - 1, j, nums), helper(a, b, i, j - 1,
     nums));
  }

  return nums[i][j];

 }

 // Iterative approach
 public int longestCommonSubsequenceIterative(String text1, String text2) {

  int n = text2.length();
  int m = text1.length();

  if (n == 0 || m == 0)
   return 0;

  int[][] dp = new int[n + 1][m + 1];

  for (int i = 1; i < n + 1; i++) {
   for (int j = 1; j < m + 1; j++) {
    if (text2.charAt(i - 1) == text1.charAt(j - 1)) {
     dp[i][j] = dp[i - 1][j - 1] + 1;
    } else {
     dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
    }
   }
  }

  return dp[n][m];

 }
}
