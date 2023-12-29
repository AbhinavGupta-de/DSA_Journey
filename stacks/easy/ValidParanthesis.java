package stacks.easy;

import java.util.*;

public class ValidParanthesis {
 public boolean isValid(String s) {
  Stack<Character> stack = new Stack<>();
  for (char c : s.toCharArray()) {
   if (c == '{' || c == '[' || c == '(') {
    stack.push(c);
   }

   else {
    if (c != stack.pop())
     return false;
   }
  }

  return true;
 }
}
