package heaps.easy;

import java.util.PriorityQueue;

/**
 * GetKSmallestElements
 */
public class GetKSmallestElements {

 public int[] getKSmallest(int[] nums, int k) {

  // One way to make it
  // PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

  PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b.compareTo(a));

  for (int i = 0; i < k; i++) {
   q.add(nums[i]);
  }

  for (int i = k; i < nums.length; i++) {
   if (nums[i] < q.peek()) {
    q.poll();
    q.add(nums[i]);
   }
  }

  return q.stream().mapToInt(i -> i).toArray();

 }

}