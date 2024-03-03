package heaps.easy;

import java.util.PriorityQueue;

public class KthSmallestElementSortedArray {
 public int kthSmallest(int[][] nums, int k) {

  PriorityQueue<Integer> q = new PriorityQueue<>();

  for (int i = 0; i < nums.length; i++) {
   for (int j = 0; j < nums[i].length; j++) {
    q.add(nums[i][j]);
   }
  }

  while (k > 1) {
   q.poll();
  }

  return q.poll();

 }
}
