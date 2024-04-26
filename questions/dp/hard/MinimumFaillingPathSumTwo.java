package questions.dp.hard;

// leetcode 1289

public class MinimumFaillingPathSumTwo {
 public int minFallingPathSum(int[][] grid) {

  int[] rowMal = helper(grid, 0);

  for (int i = 1; i < grid.length; i++) {
   for (int j = 0; j < grid.length; j++) {
    if (j != rowMal[2]) {
     grid[i][j] += rowMal[0];
    } else {
     grid[i][j] += rowMal[1];
    }
   }
   rowMal = helper(grid, i);
  }

  return rowMal[0];
 }

 private int[] helper(int[][] grid, int row) {

  int[] props = new int[3];

  int min = Integer.MAX_VALUE;
  int minPos = grid.length;

  for (int i = 0; i < grid.length; i++) {
   if (min > grid[row][i]) {
    min = grid[row][i];
    minPos = i;
   }
  }

  props[0] = min;
  props[2] = minPos;

  int secondMin = Integer.MAX_VALUE;

  for (int i = 0; i < grid.length; i++) {
   if (i != minPos) {
    if (secondMin > grid[row][i]) {
     secondMin = grid[row][i];
    }
   }
  }

  props[1] = secondMin;
  return props;
 }

}
