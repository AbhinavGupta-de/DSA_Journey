package questions.sorting.hard;

public class ReversePair {

 public int reversePair(int[] nums) {
  return mergeSort(nums, 0, nums.length);
 }

 private int mergeSort(int[] nums, int start, int end) {

  if (start >= end)
   return 0;

  int mid = (start + end) / 2;
  int revCount = mergeSort(nums, start, mid);
  revCount += mergeSort(nums, mid + 1, end);
  revCount += merge(nums, start, mid, end);

  return revCount;

 }

 private int merge(int[] nums, int start, int mid, int end) {
  int j = mid + 1;
  int revCount = 0;

  for (int i = start; i <= mid; i++) {
   if (j <= end && nums[i] > 2 * (long) (nums[j])) {
    j++;
   }
   revCount += (j - (mid + 1));

  }

  mergeSubArray(nums, start, mid, end);

  return revCount;
 }

 public void mergeSubArray(int[] nums, int start, int mid, int end) {

  int i = start;
  int j = mid + 1;

  int[] temp = new int[end - (start - 1)];
  int index = 0;

  while (i <= mid && j <= end) {
   if (nums[i] < nums[j]) {
    temp[index++] = nums[i++];
   } else {
    temp[index++] = nums[j++];
   }
  }

  if (i > mid) {
   while (j <= end) {
    temp[index++] = nums[j++];
   }
  } else {
   while (i <= end) {
    temp[index++] = nums[i++];
   }
  }

  for (int k = start; k <= end; k++) {
   nums[k] = temp[k - start];
  }

 }
}
