package heaps.easy;

import java.util.PriorityQueue;

// Given a K-sorted array. Sort the array
public class SortArray {

 // Sliding Window with Heap
 public static int[] sortArray(int[] nums, int k) {
  int n = nums.length;
  int[] result = new int[n];
  int index = 0;
  PriorityQueue<Integer> minHeap = new PriorityQueue<>();
  for (int i = 0; i < n; i++) {
   minHeap.add(nums[i]);
   if (minHeap.size() > k) {
    result[index++] = minHeap.poll();
   }
  }
  while (!minHeap.isEmpty()) {
   result[index++] = minHeap.poll();
  }
  return result;
 }

}
