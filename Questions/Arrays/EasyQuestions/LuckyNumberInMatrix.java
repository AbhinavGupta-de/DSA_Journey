package Questions.Arrays.EasyQuestions;

import java.util.*;

public class LuckyNumberInMatrix {
 public static List<Integer> luckyNumbers(int[][] matrix) {
  List<Integer> result = new ArrayList<>();

  for (int i = 0; i < matrix.length; i++) {
   int minRow = matrix[i][0];
   int colIndex = 0;
   for (int j = 1; j < matrix[i].length; j++) {
    if (matrix[i][j] < minRow) {
     minRow = matrix[i][j];
     colIndex = j;
    }
   }

   boolean isMaxCol = true;
   for (int k = 0; k < matrix.length; k++) {
    if (matrix[k][colIndex] > minRow) {
     isMaxCol = false;
     break;
    }
   }

   if (isMaxCol) {
    result.add(minRow);
   }
  }

  return result;
 }
}
