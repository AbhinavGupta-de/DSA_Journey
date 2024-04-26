package questions.heaps.easy;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MishaAndCandies {
 public int solve(ArrayList<Integer> A, int B) {

  PriorityQueue<Integer> pq = new PriorityQueue<>(A);
  int sum = 0;

  while (!pq.isEmpty()) {
   int curr = (int) pq.poll();
   if (curr > B)
    break;

   sum += (curr / 2);
   if (pq.isEmpty())
    break;

   int nextBox = (int) pq.poll() + (int) Math.ceil(curr / 2.0);
   pq.add(nextBox);
  }

  return sum;
 }

}
