package questions.Arrays.MediumQuestions;

import java.util.ArrayList;
import java.util.List;

/**
 * SpiralMatrix1
 */
public class SpiralMatrix1 {
 public List<Integer> spiralOrder(int[][] matrix) {
  // * Better solution
  List<Integer> ans = new ArrayList<>();
  if (matrix.length == 0) {
   return ans;
  }
  int top = 0;
  int bottom = matrix.length - 1;
  int left = 0;
  int right = matrix[0].length - 1;
  int size = matrix.length * matrix[0].length;

  while (ans.size() < size) {
   for (int i = left; i <= right && ans.size() < size; i++) {
    ans.add(matrix[top][i]);
   }
   top++;
   for (int i = top; i <= bottom && ans.size() < size; i++) {
    ans.add(matrix[i][right]);
   }
   right--;
   for (int i = right; i >= left && ans.size() < size; i--) {
    ans.add(matrix[bottom][i]);
   }
   bottom--;
   for (int i = bottom; i >= top && ans.size() < size; i--) {
    ans.add(matrix[i][left]);
   }
   left++;
  }
  return ans;
 }
}