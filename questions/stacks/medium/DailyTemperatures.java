package questions.stacks.medium;

import java.util.*;

public class DailyTemperatures {

 public int[] dailyTemperatures(int[] temperatures) {

  Stack<Integer> stack = new Stack<>();
  int[] closestMax = new int[temperatures.length];

  int[] result = new int[temperatures.length];

  for (int i = temperatures.length - 1; i >= 0; i--) {
   if (stack.isEmpty()) {
    closestMax[i] = i;
    stack.push(i);
   } else {
    while (!stack.isEmpty()) {
     if (temperatures[stack.peek()] > temperatures[i]) {
      closestMax[i] = stack.peek();
      stack.push(i);
      break;
     }
     stack.pop();
    }

    if (stack.isEmpty()) {
     closestMax[i] = i;
     stack.push(i);
    }
   }
  }

  for (int i = 0; i < temperatures.length; i++) {
   result[i] = closestMax[i] - i;
  }

  return result;
 }

}
