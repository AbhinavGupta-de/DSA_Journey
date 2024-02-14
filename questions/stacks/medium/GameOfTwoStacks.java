package questions.stacks.medium;

import java.util.Arrays;

/**
 * GameOfTwoStacks
 */
public class GameOfTwoStacks {

 public int gameofTwoStacks(int maxSum, int[] nums1, int[] nums2) {

  return gameofTwoStacks(maxSum, nums1, nums2, 0, 0) - 1;

 }

 private int gameofTwoStacks(int maxSum, int[] nums1, int[] nums2, int sum, int count) {

  if (sum > maxSum)
   return count;

  if (nums1.length == 0 || nums2.length == 0)
   return count;

  int ans1 = gameofTwoStacks(maxSum, Arrays.copyOfRange(nums1, 1, nums1.length), nums2, sum + nums1[0], count + 1);
  int ans2 = gameofTwoStacks(maxSum, nums1, Arrays.copyOfRange(nums2, 1, nums2.length), sum + nums2[0], count + 1);

  return Math.max(ans1, ans2);

 }

}