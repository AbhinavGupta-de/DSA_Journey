package Questions.Arrays;

import java.util.*;

public class LuckyNumberInMatrix {
 public static List<Integer> luckyNumbers(int[][] matrix) {
  List<Integer> result = new ArrayList<>();

  List<Integer> minRow = new ArrayList<>();
  // Brute Force - O(n^2)
  for (int i = 0; i < matrix.length; i++) {
   for (int j = 0; j < matrix[i].length; j++) {
    if (matrix[i][j] < matrix[i][j + 1]) {
     minRow.add(matrix[i][j]);
    }
   }
  }

  return result;
 }
}
