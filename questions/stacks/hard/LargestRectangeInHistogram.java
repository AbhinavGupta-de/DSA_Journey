package questions.stacks.hard;

import java.util.Stack;

public class LargestRectangeInHistogram {

 public int largestRectangleArea(int[] heights) {

  int[] x = minElementLeft(heights);
  int[] y = minElementRight(heights);

  int ans = 0;

  for (int i = 0; i < heights.length; i++) {
   ans = Math.max(((y[i] - 1) - (x[i] + 1) + 1) * heights[i], ans);
  }

  return ans;
 }

 public int[] minElementLeft(int[] heights) {

  Stack<Integer> stack = new Stack<>();
  int[] result = new int[heights.length];

  for (int i = 0; i < heights.length; i++) {
   if (stack.isEmpty()) {
    result[i] = -1;
    stack.add(heights[i]);
   } else {
    while (!stack.isEmpty()) {
     if (stack.peek() < heights[i]) {
      result[i] = stack.pop();
      stack.add(heights[i]);
      break;
     } else {
      stack.pop();
     }
    }

    if (stack.isEmpty()) {
     result[i] = -1;
     stack.add(heights[i]);
    }
   }
  }

  return result;
 }

 public int[] minElementRight(int[] heights) {

  Stack<Integer> stack = new Stack<>();
  int[] result = new int[heights.length];

  for (int i = heights.length - 1; i >= 0; i--) {
   if (stack.isEmpty()) {
    result[i] = heights.length;
    stack.push(heights[i]);
   } else {
    while (!stack.isEmpty()) {
     if (heights[i] > stack.peek()) {
      result[i] = stack.pop();
      stack.push(heights[i]);
      break;
     } else {
      stack.pop();
     }
    }

    if (stack.isEmpty()) {
     result[i] = heights.length;
     stack.push(heights[i]);
    }
   }
  }

  return result;
 }

}
