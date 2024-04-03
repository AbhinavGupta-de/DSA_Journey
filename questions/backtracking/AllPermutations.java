package backtracking;

import java.util.ArrayList;

public class AllPermutations {
 public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
  ArrayList<ArrayList<Integer>> result = new ArrayList<>();
  ArrayList<Boolean> temp = new ArrayList<>();
  for (int i = 0; i < A.size(); i++) {
   temp.add(false);
  }
  permute(A, result, new ArrayList<>(), temp);
  return result;

 }

 private void permute(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp,
   ArrayList<Boolean> visited) {
  if (temp.size() == A.size()) {
   result.add(new ArrayList<>(temp));
   return;
  }

  for (int i = 0; i < A.size(); i++) {
   if (visited.get(i)) {
    continue;
   }
   visited.set(i, true);
   temp.add(A.get(i));
   permute(A, result, temp, visited);
   temp.remove(temp.size() - 1);
   visited.set(i, false);
  }
 }

}
