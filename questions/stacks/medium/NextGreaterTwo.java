package questions.stacks.medium;

import java.util.Stack;

/**
 * NextGreaterTwo
 */
public class NextGreaterTwo {

 public int[] nextGreaterElements(int[] nums) {

  int[] nums2 = getArray(nums);

  return getNextGreater(nums2);

 }

 private int[] getArray(int[] nums) {
  int[] nums2 = new int[nums.length * 2];

  for (int i = 0; i < nums.length; i++) {
   nums2[i] = nums[i];
  }

  for (int i = nums.length; i < nums2.length; i++) {
   nums2[i] = nums[i % nums.length];
  }

  return nums2;
 }

 private int[] getNextGreater(int[] nums) {

  int[] result = new int[nums.length / 2];

  Stack<Integer> stack = new Stack<>();

  for (int i = nums.length - 1; i >= nums.length / 2; i--) {

   stack.push(nums[i]);

  }

  for (int i = nums.length / 2 - 1; i >= 0; i--) {
   if (stack.isEmpty()) {
    result[i] = -1;
    stack.push(nums[i]);
   } else {
    while (!stack.isEmpty()) {
     if (stack.peek() > nums[i]) {
      result[i] = stack.pop();
      stack.push(nums[i]);
      break;
     }
     stack.pop();
    }

    if (stack.isEmpty()) {
     result[i] = -1;
     stack.push(nums[i]);
    }
   }
  }

  return result;
 }

}