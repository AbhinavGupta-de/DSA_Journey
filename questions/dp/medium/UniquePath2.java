package questions.dp.medium;

import java.util.*;

public class UniquePath2 {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {

    if (obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1)
      return 0;

    Arrays.stream(obstacleGrid).forEach(
        row -> Arrays.setAll(row, j -> row[j] == 1 ? -1 : -2));

    return helper(0, 0, obstacleGrid);
  }

  private int helper(int i, int j, int[][] matrix) {
    if (i == matrix.length || j == matrix[0].length)
      return 0;

    if (i == matrix.length - 1 && j == matrix[0].length - 1)
      return 1;

    if (matrix[i][j] == -1)
      return 0;

    if (matrix[i][j] > 0)
      return matrix[i][j];

    int right = helper(i, j + 1, matrix);
    int down = helper(i + 1, j, matrix);

    matrix[i][j] = right + down;

    return right + down;

  }
}
