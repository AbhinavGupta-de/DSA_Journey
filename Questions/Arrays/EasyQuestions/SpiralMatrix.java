package questions.arrays.easyquestions;

import java.util.*;

// https://leetcode.com/problems/spiral-matrix/
public class SpiralMatrix {
 public List<Integer> spiralOrder(int[][] matrix) {
  // ArrayList<Integer> ans = new ArrayList<>();

  // TLE -> Time limit exceeded.
  // int top = 0;
  // int bottom = matrix.length - 1;
  // int left = 0;
  // int right = matrix[0].length - 1;

  // if (matrix.length == 0) {
  // return ans;
  // }
  // if (matrix.length == 1) {
  // for (int i = 0; i < matrix[0].length; i++) {
  // ans.add(matrix[0][i]);
  // }
  // return ans;
  // }

  // while (top != bottom) {
  // for (int i = left; i <= right; i++) {
  // ans.add(matrix[top][i]);
  // }
  // top++;
  // for (int i = top; i <= bottom; i++) {
  // ans.add(matrix[i][right]);
  // }
  // right--;
  // for (int i = right; i >= left; i--) {
  // ans.add(matrix[bottom][i]);
  // }
  // bottom--;
  // for (int i = bottom; i >= top; i--) {
  // ans.add(matrix[i][left]);
  // }
  // left++;
  // }
  // if (top == bottom) {
  // for (int i = left; i <= right; i++) {
  // ans.add(matrix[top][i]);
  // }
  // }

  // return ans;

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
