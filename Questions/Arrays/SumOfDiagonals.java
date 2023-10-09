package Questions.Arrays;

public class SumOfDiagonals {

 public static int sum(int[][] nums) {
  // Finding the Sum of Primary Diagonals
  int sum = 0;
  for (int i = 0; i < nums.length; i++) {
   sum += nums[i][i];
  }

  // Finding the Sum of Secondary Diagonals
  for (int i = 0; i < nums.length; i++) {
   sum += nums[i][nums.length - i - 1];
  }

  // Subtracting the common element
  if (nums.length % 2 != 0) {
   sum -= nums[nums.length / 2][nums.length / 2];
  }

  return sum;
 }

 public static void main(String[] args) {

 }

}
