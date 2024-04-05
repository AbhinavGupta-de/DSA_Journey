package dp.easy;

public class ClimbingStairs {
 public int climbStairs(int n) {

  int[] nums = new int[n + 1];
  return helper(n, nums);

 }

 private int helper(int n, int[] nums) {
  if (n < 2)
   return n;
  if (n == 2)
   return 2;

  if (n != 0 && nums[n - 1] == 0)
   nums[n - 1] = helper(n - 1, nums);
  if (n != 0 && nums[n - 2] == 0)
   nums[n - 2] = helper(n - 2, nums);

  return nums[n - 1] + nums[n - 2];

 }
}
