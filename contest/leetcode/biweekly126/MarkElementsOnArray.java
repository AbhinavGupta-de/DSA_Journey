package contest.leetcode.biweekly126;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

public class MarkElementsOnArray {

 private class Element {
  int index;
  int value;

  public Element(int index, int value) {
   this.index = index;
   this.value = value;
  }
 }

 public long[] unmarkedSumArray(int[] nums, int[][] queries) {

  long[] sum = new long[queries.length];

  HashSet<Integer> marked = new HashSet<>();

  PriorityQueue<Element> q = new PriorityQueue<>((a, b) -> {
   if (a.value == b.value) {
    return a.index - b.index;
   }

   return a.value - b.value;
  });

  long sumVar = 0;

  for (int i = 0; i < nums.length; i++) {
   sumVar += nums[i];
   q.add(new Element(i, nums[i]));
  }

  for (int i = 0; i < queries.length; i++) {

   int markindex = queries[i][0];
   int smallVals = queries[i][1];

   if (!marked.contains(markindex)) {
    marked.add(markindex);
    sumVar -= nums[markindex];
   }

   int count = 0;

   while (!q.isEmpty() && count < smallVals) {
    Element e = q.poll();
    if (!marked.contains(e.index)) {
     sumVar -= e.value;
     count++;
     marked.add(e.index);
    }
   }

   sum[i] = sumVar;
  }

  return sum;
 }

 public static void main(String[] args) {
  int[] nums = { 1, 12, 12, 4, 14, 1, 12, 1 };
  int[][] queries = { { 1, 2 }, { 5, 4 }, { 4, 0 }, { 0, 1 }, { 0, 3 } };

  long[] sum = new MarkElementsOnArray().unmarkedSumArray(nums, queries);

  System.out.println(Arrays.toString(sum));

 }
}
