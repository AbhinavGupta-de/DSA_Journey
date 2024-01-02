package questions.arrays.mediumquestions;

public class RotateMatrix {
 public void rotate(int[][] matrix) {
  // Transpose then inverse

  transpose(matrix);

  inverse(matrix);

 }

 public void transpose(int[][] matrix) {
  for (int i = 0; i < matrix.length; i++) {
   for (int j = 0; j < i; j++) {
    int temp = matrix[i][j];
    matrix[i][j] = matrix[j][i];
    matrix[j][i] = temp;
   }
  }
 }

 public void inverse(int[][] matrix) {
  for (int i = 0; i < matrix.length / 2; i++) {
   for (int j = 0; j < matrix.length / 2; j++) {
    int temp = matrix[i][j];
    matrix[i][j] = matrix[i][matrix.length - j - 1];
    matrix[i][matrix.length - j - 1] = temp;
   }
  }
 }

}
