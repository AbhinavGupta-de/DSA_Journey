package questions.dp.medium;

import java.util.*;

public class EditDistance {
 public int minDistance(String A, String B) {
  int m = A.length();
  int n = B.length();
  int[][] dp = new int[m][n];
  Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));

  return helper(m - 1, n - 1, A, B, dp);
 }

 private int helper(int i, int j, String A, String B, int[][] dp) {
  if (i < 0 && j < 0)
   return 0;
  if (i < 0 && j >= 0)
   return j + 1;
  if (i >= 0 && j < 0)
   return i + 1;

  if (dp[i][j] != -1)
   return dp[i][j];

  if (A.charAt(i) == B.charAt(j)) {
   dp[i][j] = helper(i - 1, j - 1, A, B, dp);
  } else {
   int delete = helper(i - 1, j, A, B, dp);
   int insert = helper(i, j - 1, A, B, dp);
   int update = helper(i - 1, j - 1, A, B, dp);

   dp[i][j] = Math.min(Math.min(delete, update), insert) + 1;
  }

  return dp[i][j];

 }
}
