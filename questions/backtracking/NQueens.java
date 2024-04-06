package backtracking;

import java.util.*;

public class NQueens {
 public ArrayList<ArrayList<String>> solveNQueens(int A) {

  char[][] board = new char[A][A];
  for (int i = 0; i < A; i++) {
   Arrays.fill(board[i], '.');
  }
  ArrayList<ArrayList<String>> result = new ArrayList<>();
  helper(board, 0, result);
  return result;
 }

 private void helper(char[][] board, int row, ArrayList<ArrayList<String>> result) {

  if (row == board.length) {
   ArrayList<String> boardList = new ArrayList<>();
   for (char[] damRow : board) {
    boardList.add(new String(damRow));
   }

   result.add(boardList);
   return;
  }

  for (int i = 0; i < board.length; i++) {
   if (isSafe(board, row, i)) {
    board[row][i] = 'Q'; // work and call
    helper(board, row + 1, result);
    board[row][i] = '.'; // backtracking
   }
  }

 }

 private boolean isSafe(char[][] board, int row, int col) {

  int n = board.length;
  int[] dx = { -1, -1, -1 };
  int[] dy = { -1, 0, 1 };
  for (int i = 0; i < 3; i++) {
   int x = row;
   int y = col;
   while (x >= 0 && y >= 0 && y < n) {
    if (board[x][y] == 'Q')
     return false;
    x += dx[i];
    y += dy[i];
   }
  }

  return true;

 }
}
