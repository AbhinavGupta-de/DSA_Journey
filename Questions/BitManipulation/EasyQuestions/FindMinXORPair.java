package Questions.BitManipulation.EasyQuestions;

import java.util.Arrays;

public class FindMinXORPair {

 public int findMinXORPair(int[] nums) {
  Arrays.sort(nums);
  int min = Integer.MIN_VALUE;
  for (int i = 0; i < nums.length - 1; i++) {
   min = Math.max(min, nums[i] ^ nums[i + 1]);
  }
  return min;
 }
}
