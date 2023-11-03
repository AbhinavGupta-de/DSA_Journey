package Questions.Arrays.MediumQuestions;

/**
 * RotateArray
 */
public class RotateArray {

 public void rotate(int[] nums, int k) {

  // Solution 1: Using an extra array : Time Complexity: O(n) Space Complexity:
  // O(n)
  // int[] a = new int[nums.length];
  // for (int i = 0; i < nums.length; i++) {
  // a[(i + k) % nums.length] = nums[i];
  // }
  // for (int i = 0; i < nums.length; i++) {
  // nums[i] = a[i];
  // }

  // Reversing the array
  // First reverse the n - k elements
  // Then reverse the k elements
  // Then reverse the whole array
  // Time Complexity: O(n) Space Complexity: O(1)
  k %= nums.length;
  reverse(nums, 0, nums.length - k - 1);
  reverse(nums, nums.length - k, nums.length - 1);
  reverse(nums, 0, nums.length - 1);

 }

 public void reverse(int[] nums, int start, int end) {
  while (start < end) {
   int temp = nums[start];
   nums[start] = nums[end];
   nums[end] = temp;
   start++;
   end--;
  }
 }

}