package questions.Recursion.medium;

import java.util.HashSet;
import java.util.List;

public class MaxLengthUniqueChar {

 public int maxLength(List<String> arr) {

  return maxLength(arr, 0, "");

 }

 public int maxLength(List<String> arr, int index, String input) {

  if (index == arr.size() - 1) {
   if (isValid(input)) {
    return input.length();
   }
   return 0;
  }

  int take = maxLength(arr, index + 1, input + arr.get(index));
  int notTake = maxLength(arr, index + 1, input);
  return Math.max(take, notTake);

 }

 public boolean isValid(String input) {
  HashSet<Character> set = new HashSet<>();

  for (char c : input.toCharArray()) {

   if (set.contains(c)) {
    return false;
   }

   set.add(c);

  }
  return true;
 }

}
