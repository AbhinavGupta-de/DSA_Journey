package questions.Recursion.Sorting;

import java.util.Arrays;

public class SelectionSort {

 public static void main(String[] args) {
  int[] nums = { 5, 4, 3, 2, 1 };
  sort(nums, 0);
  System.out.println(Arrays.toString(nums));
 }

 public static void sort(int[] nums, int index) {
  if (index == nums.length - 1)
   return;

  sort(nums, index + 1);
  swap(nums, index, maxElement(nums, index)[1]);
 }

 public static int[] maxElement(int[] nums, int index) {
  int max = Integer.MIN_VALUE;
  int[] result = new int[2];
  for (int i = index; i < nums.length; i++) {
   if (nums[i] > max) {
    max = nums[i];
    result[0] = max;
    result[1] = i;
   }
  }
  return result;
 }

 public static void swap(int[] nums, int index, int index2) {
  int temp = nums[index];
  nums[index] = nums[index2];
  nums[index2] = temp;
 }

}
