package questions.Arrays.MediumQuestions;

public class FirstAndLastPosition {
 public int[] searchRange(int[] nums, int key) {
  // O(logn) solution
  int[] res = new int[2];

  res[0] = findFirstIndex(nums, key);
  res[1] = findLastIndex(nums, key);

  return res;
 }

 public int findFirstIndex(int[] nums, int key) {
  int start = 0;
  int end = nums.length - 1;
  int res = -1;
  while (start <= end) {
   int mid = (start + end) / 2;
   if (nums[mid] == key) {
    res = mid;
    end = mid - 1;
   } else if (nums[mid] > key) {
    end = mid - 1;
   } else {
    start = mid + 1;
   }
  }
  return res;
 }

 public int findLastIndex(int[] nums, int key) {
  int start = 0;
  int end = nums.length - 1;
  int res = -1;
  while (start <= end) {
   int mid = (start + end) / 2;
   if (nums[mid] == key) {
    res = mid;
    start = mid + 1;
   } else if (nums[mid] > key) {
    end = mid - 1;
   } else {
    start = mid + 1;
   }
  }
  return res;
 }
}
