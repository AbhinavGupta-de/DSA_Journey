package questions.stacks.medium;

import java.util.*;

public class EvaluateReversePolishNotation {
 public int evalRPN(String[] A) {
  Stack<Integer> stack = new Stack<>();

  for (String i : A) {
   if (i.equals("+")) {
    int num1 = stack.pop();
    int num2 = stack.pop();
    stack.push(num1 + num2);
   }

   else if (i.equals("-")) {
    int num2 = stack.pop();
    int num1 = stack.pop();
    stack.push(num1 - num2);
   }

   else if (i.equals("*")) {
    int num1 = stack.pop();
    int num2 = stack.pop();
    stack.push(num1 * num2);
   } else if (i.equals("/")) {
    int num2 = stack.pop();
    int num1 = stack.pop();
    stack.push(num1 / num2);
   } else {
    stack.push(Integer.parseInt(i));
   }
  }

  return stack.pop();
 }
}
