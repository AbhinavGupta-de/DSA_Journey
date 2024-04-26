package questions.heaps.easy;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MagcianAndChocolates {
 public int nchoc(int A, ArrayList<Integer> B) {

  PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
  pq.addAll(B);

  int sum = 0;

  while (A > 0) {
   int curr = pq.poll();
   sum += curr;
   pq.add(curr / 2);
   A--;
  }

  return sum;
 }
}
