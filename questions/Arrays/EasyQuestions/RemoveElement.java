package questions.Arrays.EasyQuestions;

import java.util.Arrays;

/**
 * RemoveElement
 */
public class RemoveElement {

 public int removeElement(int[] nums, int val) {
  int count = 0;
  int length = nums.length;
  for (int i = 0; i < length; i++) {
   if (nums[i] == val) {
    count++;
    nums[i] = Integer.MAX_VALUE;
   }
  }
  Arrays.sort(nums);
  return length - count;
 }
}