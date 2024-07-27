package questions.backtracking.hard;

public class RatInMaze {

 public int countOfPaths(int[][] matrix) {

 }

 // Given a maze of n*n size, the function should return if the path is possible
 // or not
 public boolean isPathPossible(int[][] matrix, int n, int m) {

  if (n < 0 || m < 0 || n >= matrix.length || m >= matrix[0].length || matrix[n][m] == 1) {
   return false;
  }

  if (isPathPossible(matrix, n + 1, m) || isPathPossible(matrix, n, m + 1)) {
   return true;
  }

  return false;

 }

}
