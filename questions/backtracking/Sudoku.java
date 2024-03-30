package backtracking;

public class Sudoku {

 public void solveSudoku(char[][] A) {
  solve(A);
 }

 public boolean solve(char[][] A) {

  for (int i = 0; i < A.length; i++) {
   for (int j = 0; j < A[0].length; j++) {
    if (A[i][j] == '.') {
     for (char c = '1'; c <= '9'; c++) {
      if (isValid(A, i, j, c)) {
       A[i][j] = c;
       if (solve(A)) {
        return true;
       } else {
        A[i][j] = '.';
       }
      }
     }
     return false;
    }
   }
  }
  return true;
 }

 private boolean isValid(char[][] A, int row, int col, char c) {
  for (int i = 0; i < 9; i++) {
   if (A[i][col] != '.' && A[i][col] == c) {
    return false;
   }
   if (A[row][i] != '.' && A[row][i] == c) {
    return false;
   }
   if (A[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != '.' && A[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
    return false;
   }
  }
  return true;
 }

}
