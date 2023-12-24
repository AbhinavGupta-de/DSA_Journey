package questions.arrays.mediumquestions;

/**
 * SpiralMatrix2
 */
public class SpiralMatrix2 {

 public int[][] generateMatrix(int n) {
  int arr[][] = new int[n][n];

  int top = 0;
  int left = 0;
  int right = n - 1;
  int bottom = n - 1;

  int count = 1;
  while (count <= n * n) {
   for (int i = left; i <= right; i++) {
    arr[top][i] = count++;
   }
   top++;
   for (int i = top; i <= bottom; i++) {
    arr[i][right] = count++;
   }
   right--;
   for (int i = right; i >= left; i--) {
    arr[bottom][i] = count++;
   }
   bottom--;
   for (int i = bottom; i >= top; i--) {
    arr[i][left] = count++;
   }
   left++;
  }

  return arr;
 }

}