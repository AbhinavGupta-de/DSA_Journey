package questions.searching.medium;

/**
 * Search2DArray
 */
public class Search2DArray {

 public static void main(String[] args) {
  int[][] arr = { { 1, 2, 3 }, { 4, 5, 6, 7 }, { 8, 9 } };
  int target = 5;
  System.out.println(search(arr, target));
 }

 private static boolean search(int[][] arr, int target) {
  // Approach 1: Linear Search
  // for (int[] is : arr) {
  // for (int i : is) {
  // if (i == target) {
  // return true;
  // }
  // }
  // }
  // return false;

  // Approach 2: Binary Search
  int row = 0;
  int col = arr[0].length - 1;
  while (row < arr.length && col >= 0) {
   if (arr[row][col] == target) {
    return true;
   } else if (arr[row][col] > target) {
    col--;
   } else {
    row++;
   }
  }

  return false;
 }
}