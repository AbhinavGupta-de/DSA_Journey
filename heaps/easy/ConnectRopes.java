package heaps.easy;

import java.util.*;

/**
 * ConnectRopes
 */
public class ConnectRopes {

 public int connectRopes(int[] nums) {

  PriorityQueue<Integer> q = new PriorityQueue<Integer>();

  for (int i : nums)
   q.add(i);

  int ans = 0;

  while (q.size() > 1) {
   int t = q.poll();
   int s = q.poll();

   int x = t + s;
   ans += x;
   q.add(x);
  }

  return ans;

 }

}