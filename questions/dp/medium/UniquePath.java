package questions.dp.medium;

import java.util.*;

public class UniquePath {
 public int uniquePaths(int m, int n) {
  int[][] nums = new int[m][n];
  for (int[] array : nums) {
   Arrays.fill(array, -1);
  }
  return helper(m, n, 0, 0, nums);
 }

 private int helper(int m, int n, int i, int j, int[][] nums) {
  if (i == m || j == n)
   return 0;
  if (i == m - 1 || j == n - 1)
   return 1;

  if (nums[i][j] != -1)
   return nums[i][j];

  int right = helper(m, n, i, j + 1, nums);
  int down = helper(m, n, i + 1, j, nums);

  nums[i][j] = right + down;
  return right + down;

 }
}
