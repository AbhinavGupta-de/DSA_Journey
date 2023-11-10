package Questions.Searching.EasyQuestions;

import java.util.HashSet;

public class KthMissingNumber {
 public int findKthPositive(int[] nums, int k) {
  // O(n) time complexity
  // HashSet<Integer> set = new HashSet<>();
  // for (int i = 0; i < nums.length; i++)
  // set.add(nums[i]);

  // int count = 0;
  // int i = 1;
  // while (count < k) {
  // if (!set.contains(i))
  // count++;
  // i++;
  // }

  // return i - 1;

  // O(logn) time complexity
  int low = 0;
  int high = nums.length - 1;
  while (low <= high) {
   int mid = low + (high - low) / 2;
   if (nums[mid] - mid - 1 < k)
    low = mid + 1;
   else
    high = mid - 1;
  }

  return low + k;
 }
}
