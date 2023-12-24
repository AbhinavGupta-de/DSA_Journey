package questions.sorting.hard;

public class ReversePair {

 public int reversePair(int[] nums) {
  return mergeSort(nums, 0, nums.length);
 }

 public int mergeSort(int[] nums, int start, int end) {

  if (start >= end)
   return 0;

  int mid = (start + end) / 2;
  int revCount = mergeSort(nums, start, mid);
  revCount += mergeSort(nums, mid + 1, end);
  revCount += merge(nums, start, mid, end);

  return revCount;

 }

 public int merge(int[] nums, int start, int mid, int end) {
  int j = mid + 1;
 }

}
