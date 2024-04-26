package questions.heaps.medium;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class WinnerStone {
 public int solve(ArrayList<Integer> A) {

  PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

  pq.addAll(A);

  while (pq.size() > 1) {
   int stone = pq.poll();
   int ston2 = pq.poll();
   if (stone != ston2) {
    pq.add(Math.abs(stone - ston2));
   }
  }

  if (pq.isEmpty())
   return 0;

  return pq.poll();
 }
}
