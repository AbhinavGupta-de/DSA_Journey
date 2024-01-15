package stacks.medium;

import java.util.Stack;

public class CalculatorTwo {

 public int precedence(char c) {
  if (c == '^')
   return 3;
  else if (c == '*' || c == '/')
   return 2;
  else if (c == '+' || c == '-')
   return 1;

  return 0;
 }

 public String infixPostFix(String input) {
  StringBuilder stb = new StringBuilder();
  Stack<Character> stack = new Stack<>();

  for (char c : input.toCharArray()) {

   if (c >= 'a' && c <= 'z') {
    stb.append(c);
   } else if (c == '(')
    stack.push(c);
   else if (c == ')') {
    while (!stack.isEmpty() && stack.peek() != '(') {
     stb.append(c);
     stack.pop();
    }

    if (!stack.isEmpty())
     stack.pop();
   } else {
    while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
     stb.append(stack.pop());
    }
    stack.push(c);
   }
  }

  while (!stack.isEmpty()) {
   stb.append(stack.pop());
  }

  return stb.toString();
 }

 public int calculate(String s) {

  return 0;
 }
}
