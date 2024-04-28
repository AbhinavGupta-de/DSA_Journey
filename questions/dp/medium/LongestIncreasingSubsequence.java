package dp.medium;

// leetcode 300
public class LongestIncreasingSubsequence {
 public int lengthOfLIS(int[] nums) {
  // int[][] dp = new int[nums.length][nums.length];
  // Arrays.fill(dp, -1);
  // return helper(nums, 0, Integer.MIN_VALUE, dp);
  int[] dp = new int[nums.length];
  for (int i = 0; i < nums.length; ++i) {
   for (int j = i - 1; j >= 0; --j) {
    if (nums[j] < nums[i]) {
     dp[i] = Math.max(dp[i], 1 + dp[j]);
    }
   }
  }

  return dp[nums.length];
 }

 // private int helper(int[] nums, int start, int prev, int[] dp) {
 // if (start >= nums.length || nums[start] <= prev)
 // return 0;

 // if (dp[start] != -1)
 // return dp[start];

 // return dp[start] = Math.max(helper(nums, start + 1, prev, dp),
 // helper(nums, start + 1, nums[start], dp) + 1);
 // }

}