package questions.Recursion.Sorting;

import java.util.Arrays;

public class MergeSort {

 public static void main(String[] args) {
  int[] arr = { 5, 4, 3, 1, 2, 23, 15, 9, 0 };
  mergeSort(arr, 0, arr.length - 1);
  System.out.println("Sorted Array: " + Arrays.toString(arr));
 }

 public static void mergeSort(int[] arr, int start, int end) {
  if (start == end) {
   return;
  }

  int mid = (end + start) / 2;
  mergeSort(arr, start, mid);
  mergeSort(arr, mid + 1, end);
  merge(arr, start, mid, end);
 }

 public static void merge(int[] nums, int l, int r, int m) {
  int[] temp = new int[m - l + 1];
  int i = l, j = r + 1, k = 0;
  while (i <= r && j <= m) {
   if (nums[i] <= nums[j]) {
    temp[k++] = nums[i++];
   } else {
    temp[k++] = nums[j++];
   }
  }
  while (i <= r) {
   temp[k++] = nums[i++];
  }
  while (j <= m) {
   temp[k++] = nums[j++];
  }
  for (int p = 0; p < temp.length; p++) {
   nums[l + p] = temp[p];
  }
  return;
 }

}
