package questions.stacks.medium;

import java.util.Stack;

public class MinAddToMakeValidParanthesis {
 public int minAddToMakeValid(String s) {
  Stack<Character> stack = new Stack<>();

  for (char i : s.toCharArray()) {

   if (i == '[' || i == '{' || i == '(') {

    stack.push(i);

   }

   if (i == ')') {
    if (!stack.isEmpty() && stack.peek() == '(')
     stack.pop();
    else
     stack.push(i);
   }

   if (i == '}') {
    if (!stack.isEmpty() && stack.peek() == '{')
     stack.pop();
    else
     stack.push(i);
   }

   if (i == ']') {
    if (!stack.isEmpty() && stack.peek() == '[')
     stack.pop();
    else
     stack.push(i);
   }

  }

  return stack.size();

 }
}
