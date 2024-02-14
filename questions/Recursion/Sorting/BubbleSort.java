package questions.Recursion.Sorting;

import java.util.Arrays;

public class BubbleSort {
 public static void main(String[] args) {
  int[] nums = { 2, 3, 4, 5, 1 };
  int index = 0;

  sort(nums, index);

  System.out.println("Sorted array is: " + Arrays.toString(nums));
 }

 public static void sort(int[] arr, int index) {
  if (index == arr.length - 1) {
   return;
  }
  sort(arr, index + 1);
  if (arr[index] > arr[index + 1]) {
   int temp = arr[index];
   arr[index] = arr[index + 1];
   arr[index + 1] = temp;
  }
 }
}
