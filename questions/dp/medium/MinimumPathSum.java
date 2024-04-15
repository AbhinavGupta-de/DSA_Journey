package questions.dp.medium;

import java.util.*;

public class MinimumPathSum {
 public int minPathSum(int[][] grid) {
  int[][] nums = new int[grid.length][grid[0].length];
  Arrays.stream(nums).forEach(a -> Arrays.fill(a, -1));

  return helper(0, 0, grid, nums);
 }

 private int helper(int i, int j, int[][] grid, int[][] nums) {
  int n = grid.length;
  int m = grid[0].length;

  if (i >= n || j >= m)
   return Integer.MAX_VALUE;

  if (i == n - 1 && j == m - 1)
   return grid[i][j];

  if (nums[i][j] != -1)
   return nums[i][j];

  int right = helper(i, j + 1, grid, nums);
  int down = helper(i + 1, j, grid, nums);

  nums[i][j] = Math.min(right, down) + grid[i][j];
  return nums[i][j];

 }
}
