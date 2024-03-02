package contest.leetcode.biweekly125;

import java.util.PriorityQueue;

/*
 * 
 * You are given a 0-indexed integer array nums, and an integer k.

* In one operation, you will:

* Take the two smallest integers x and y in nums.
* Remove x and y from nums.
* Add min(x, y) * 2 + max(x, y) anywhere in the array.
* Note that you can only apply the described operation if nums contains at least two elements.

* Return the minimum number of operations needed so that all elements of the array are greater than or equal to k.
 * 
 * 
 */

public class MinimumOperationsToExceedThresholdTwo {

 public int minOperations(int[] nums, int k) {

  // Preffix min(x, y) * 2 + max(x, y) this

  // Priority Queue

  PriorityQueue<Long> pq = new PriorityQueue<>();

  for (int i = 0; i < nums.length; i++) {
   pq.add((long) nums[i]);
  }

  int operations = 0;

  while (pq.peek() < k) {

   long x = pq.poll();
   long y = pq.poll();

   long sum = x * 2L + y;

   pq.add(sum);

   operations++;

  }

  return operations;

 }

 public static void main(String[] args) {
  int[] nums = { 1000000000, 999999999, 1000000000, 999999999, 1000000000, 999999999 };
  int k = 1_000_000_000;
  // 9,999,999,990

  MinimumOperationsToExceedThresholdTwo minimumOperationsToExceedThreshold = new MinimumOperationsToExceedThresholdTwo();

  System.out.println(minimumOperationsToExceedThreshold.minOperations(nums, k));
  // 4

 }

}
