package questions.tree.easy;

import java.util.ArrayList;

/**
 * CheckBSTWithOneChild
 */

public class CheckBSTWithOneChild {

 public String checkOneChildBST(ArrayList<Integer> list) {
  int n = list.size();
  if (n <= 2) {
   return "YES";
  }

  int min = Integer.MIN_VALUE;
  int max = Integer.MAX_VALUE;

  for (int i = 1; i < n; i++) {
   int curr = list.get(i);
   int parent = list.get(i - 1);

   if (curr < min || curr > max) {
    return "NO";
   }

   if (curr < parent) {
    max = parent;
   } else {
    min = parent;
   }
  }

  return "YES";
 }

}
