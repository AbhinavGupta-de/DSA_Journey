package dp.medium;

import java.util.*;

public class MinSumPathTraingle {
 public int minimumTotal(ArrayList<ArrayList<Integer>> a) {

  ArrayList<ArrayList<Integer>> dp = new ArrayList<>();

  for (int i = 0; i < a.size(); i++) {
   ArrayList<Integer> row = new ArrayList<>();
   for (int j = 0; j < a.get(i).size(); j++) {
    row.add(-1);
   }
   dp.add(row);
  }

  return helper(0, 0, a, dp);
 }

 private int helper(int i, int j, ArrayList<ArrayList<Integer>> a, ArrayList<ArrayList<Integer>> dp) {
  int n = a.size();
  if (i == n - 1)
   return a.get(i).get(j);

  if (dp.get(i).get(j) != -1)
   return dp.get(i).get(j);

  int left = helper(i + 1, j, a, dp);

  int right = helper(i + 1, j + 1, a, dp);

  dp.get(i).set(j, a.get(i).get(j) + Math.min(left, right));

  return dp.get(i).get(j);

 }
}
