package dp.medium;

import java.util.*;

public class LongestCommonSubsequence {
 public int longestCommonSubsequence(String text1, String text2) {
  int[][] nums = new int[text2.length()][text1.length()];

  Arrays.stream(nums).forEach(a -> Arrays.fill(a, -1));

  return helper(text1, text2, text2.length() - 1, text1.length() - 1, nums);
 }

 private int helper(String a, String b, int i, int j, int[][] nums) {
  if (i < 0 || j < 0)
   return 0;

  if (nums[i][j] != -1)
   return nums[i][j];

  if (a.charAt(j) == b.charAt(i)) {
   nums[i][j] = helper(a, b, i - 1, j - 1, nums) + 1;
  }

  else {
   nums[i][j] = Math.max(helper(a, b, i - 1, j, nums), helper(a, b, i, j - 1,
     nums));
  }

  return nums[i][j];

 }
}
