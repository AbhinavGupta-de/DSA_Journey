package questions.dp.hard;

import java.util.Arrays;

public class MinimumFaillingPathSumTwo {
 public int minFallingPathSum(int[][] grid) {

  int[][] dp = new int[grid.length][grid.length + 1];
  Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
  return helper(grid, 0, grid.length, dp, grid.length);

 }

 private int helper(int[][] grid, int row, int prevCol, int[][] dp, int n) {
  if (row > n || prevCol >= n)
   return 0;

  if (row == n)
   return 1;

  if (dp[row][prevCol] != -1)
   return dp[row][prevCol];

  int sum = 0;
  for (int i = 0; i < n; i++) {
   if (i != prevCol) {
    int temp = prevCol;
    sum += helper(grid, row + 1, i, dp, n);
    prevCol = temp;
   }
  }

  return dp[row][prevCol] = sum;

 }
}
