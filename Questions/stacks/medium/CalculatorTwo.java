package questions.stacks.medium;

import java.util.Stack;

public class CalculatorTwo {

  private int precedence(char c) {
    if (c == '^')
      return 3;
    else if (c == '*' || c == '/')
      return 2;
    else if (c == '+' || c == '-')
      return 1;

    return -1;
  }

  private String infixPostFix(String input) {
    StringBuilder stb = new StringBuilder();
    Stack<Character> stack = new Stack<>();

    for (char c : input.toCharArray()) {

      // Skip spaces
      if (c == ' ')
        continue;

      // Check if the character is an operand (either a letter or a number)
      if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
        stb.append(c);
      } else if (c == '(')
        stack.push(c);
      else if (c == ')') {
        while (!stack.isEmpty() && stack.peek() != '(') {
          stb.append(stack.pop());
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

  private int evalRPN(String input) {

    Stack<Long> stack = new Stack<>();

    for (char c : input.toCharArray()) {

      if (c == '+') {
        long num2 = stack.pop();
        long num1 = stack.pop();

        stack.push(num1 + num2);
      } else if (c == '*') {
        long num2 = stack.pop();
        long num1 = stack.pop();

        stack.push(num1 * num2);
      } else if (c == '-') {
        long num2 = stack.pop();
        long num1 = stack.pop();

        stack.push(num1 - num2);
      }

      else if (c == '/') {
        long num2 = stack.pop();
        long num1 = stack.pop();

        stack.push(num1 / num2);
      }

      else {
        stack.push(Long.parseLong(c + ""));
      }
    }

    StringBuilder result = new StringBuilder();

    while (!stack.isEmpty()) {
      result.append(stack.pop());
    }

    return Integer.parseInt(result.reverse().toString());
  }

  private int eval(String input) {
    return evalRPN(infixPostFix(input));
  }

  public int calculate(String s) {
    return eval(s);
  }
}
