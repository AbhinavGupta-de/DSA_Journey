package dp.easy;

public class Party {

 public int solve(int n) {

  int[] nums = new int[n];
  return helper(n, nums);

 }

 public int helper(int n, int[] nums) {
  if (n == 0)
   return 0;
  if (n == 1)
   return 1;
  if (n == 2)
   return 2;

  if (n != 0 && nums[n - 1] == 0)
   nums[n - 1] = helper(n - 1, nums);
  if (n != 0 && nums[n - 2] == 0)
   nums[n - 2] = helper(n - 2, nums);

  return nums[n - 1] + (n - 1) * nums[n - 2];

 }

}
