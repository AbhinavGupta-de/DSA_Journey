package questions.backtracking.easy;

import java.util.*;

public class GenerateSubSequences {

 public List<List<Integer>> generateSubsequences(List<Integer> list) {
  Collections.sort(list);

  List<List<Integer>> result = new ArrayList<>();

  List<Integer> currList = new ArrayList<>();

  generateSubsequences(list, 0, 0, result, currList);

  return result;
 }

 public void generateSubsequences(List<Integer> list, int index, int index2, List<List<Integer>> result,
   List<Integer> currList) {
  if (index == list.size()) {
   result.add(new ArrayList<>(currList));
   return;
  }

  currList.add(list.get(index));
  generateSubsequences(list, index + 1, index2, result, currList);
  currList.remove(currList.size() - 1);
  generateSubsequences(list, index + 1, index2, result, currList);

 }

 public static void main(String[] args) {
  List<List<Integer>> list = new GenerateSubSequences().generateSubsequences(Arrays.asList(1, 2, 3));

  for (List<Integer> temp : list) {
   System.out.println(temp.toString());
  }

 }
}
