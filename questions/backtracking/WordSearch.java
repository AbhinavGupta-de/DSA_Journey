package backtracking;

public class WordSearch {
 public boolean exist(char[][] board, String word) {
  int n = board.length;
  int m = board[0].length;
  for (int i = 0; i < board.length; i++) {
   for (int j = 0; j < board[0].length; j++) {
    if (word.charAt(0) == board[i][j]) {
     if (exist(board, word, i, j, n, m, 0)) {
      return true;
     }
    }
   }
  }
  return false;

 }

 private boolean exist(char[][] board, String word, int row, int col, int n, int m, int idx) {
  if (idx >= word.length())
   return true;
  if (row < 0 || row >= n || col < 0 || col >= m || word.charAt(idx) != board[row][col]) {
   return false;
  }

  board[row][col] = '#';

  boolean flag = false;

  flag |= exist(board, word, row, col + 1, n, m, idx + 1);
  flag |= exist(board, word, row + 1, col, n, m, idx + 1);
  flag |= exist(board, word, row, col - 1, n, m, idx + 1);
  flag |= exist(board, word, row - 1, col, n, m, idx + 1);
  // backtrack
  board[row][col] = word.charAt(idx);

  return flag;
 }
}
