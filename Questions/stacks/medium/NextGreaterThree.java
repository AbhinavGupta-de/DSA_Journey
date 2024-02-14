package questions.stacks.medium;

import java.util.*;

public class NextGreaterThree {

 public int nextGreaterElement(int n) {

  ArrayList<Integer> nums = getArray(n);

  long num = getNextGreater(nums);

  if (num > Integer.MAX_VALUE) {
   return -1;
  }

  if (num < Integer.MIN_VALUE)
   return -1;

  if (num <= n)
   return -1;

  return (int) num;

 }

 private ArrayList<Integer> getArray(int n) {

  ArrayList<Integer> nums = new ArrayList<>();

  int temp = n;

  while (temp > 0) {
   nums.add(temp % 10);
   temp /= 10;
  }

  Collections.reverse(nums);
  System.out.print(nums.toString());

  return nums;
 }

 private long getNextGreater(ArrayList<Integer> nums) {
  long num = 0;

  int[] result = getNextGreaterElements(nums);

  for (int i = 0; i < result.length; i++) {

   num += result[i];
   num *= 10;

  }

  return num / 10;
 }

 private int[] getNextGreaterElements(ArrayList<Integer> nums) {
  Stack<Integer> stack = new Stack<>();
  int[] result = new int[nums.size()];

  for (int i = nums.size() - 1; i >= 0; i--) {

   if (stack.isEmpty()) {
    result[i] = nums.get(i);
    stack.push(i);
   } else {
    while (!stack.isEmpty()) {
     if (nums.get(i) < nums.get(stack.peek())) {
      result[stack.peek()] = nums.get(i);
      result[i] = nums.get(stack.peek());
      stack.push(i);

      return result;
     }
     stack.pop();
    }

    if (stack.isEmpty()) {
     result[i] = nums.get(i);
     stack.push(i);
    }
   }
  }

  System.out.print(Arrays.toString(result));

  return result;
 }
}
