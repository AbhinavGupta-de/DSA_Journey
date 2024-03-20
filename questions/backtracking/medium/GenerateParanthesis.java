package questions.backtracking.medium;

import java.util.ArrayList;

public class GenerateParanthesis {

 public ArrayList<String> generate(int n) {

  ArrayList<String> result = new ArrayList<>();
  generate(n, 0, 0, "", result);
  return result;

 }

 private void generate(int n, int open, int close, String s, ArrayList<String> result) {
  if (s.length() == 2 * n) {
   result.add(s);
   return;
  }

  if (open < n) {
   generate(n, open + 1, close, s + "(", result);
  }

  if (close < open) {
   generate(n, open, close + 1, s + ")", result);
  }

 }

 public static void main(String[] args) {

  GenerateParanthesis obj = new GenerateParanthesis();
  ArrayList<String> result = obj.generate(3);
  for (String s : result) {
   System.out.println(s);
  }

 }

}
