package Questions.Arrays;

/**
 * TransposeMatrix
 */
public class TransposeMatrix {

 public static int[][] transpose(int[][] nums) {

  int[][] result = new int[nums[0].length][nums.length];

  for (int i = 0; i < result.length; i++) {
   for (int j = 0; j < result[i].length; j++) {
    result[i][j] = nums[j][i];
   }
  }

  return result;
 }

 public static void main(String[] args) {

 }
}