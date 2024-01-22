package questions.arrays.easyquestions;

import java.util.*;

public class SetMismatch {
 public int[] findErrorNums(int[] nums) {

  HashSet<Integer> set = new HashSet<>();
  int sum = 0;

  int[] result = new int[2];

  for (int i = 0; i < nums.length; i++) {

   if (set.contains(nums[i])) {
    result[0] = nums[i];
   } else {
    sum += nums[i];
   }
  }

  int trueSum = ((nums.length) * (nums.length + 1)) / 2;
  result[1] = trueSum - sum;

  return result;
 }
}
