package contest.leetcode.biweekly125;

import java.util.Arrays;

public class MinimumOperationsToExceedThreshold {

 // Return the min num of operations we need to do so that all the elements
 // remaining are greater than k
 public int minOperations(int[] nums, int k) {

  Arrays.sort(nums);

  for (int i = 0; i < nums.length; i++) {

   if (nums[i] >= k) {
    return i;
   }

  }

  return -1;

 }

}
