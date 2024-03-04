package greedy.medium;

import java.util.PriorityQueue;

public class FractionalKnackscaks {

 public int maxVal(int[] values, int[] weights, int capacity) {

  PriorityQueue<Integer> storeIndex = new PriorityQueue<>((i, j) -> {
   if (weights[i] / values[i] < weights[j] / values[j])
    return 1;

   return -1;
  });

  for (int i = 0; i < values.length; i++) {
   storeIndex.add(i);
  }

  int k = 0;
  int result = 0;

  while (!storeIndex.isEmpty()) {
   int i = storeIndex.poll();
   if (weights[i] + k <= capacity) {
    result += weights[i] * values[i];
    k += weights[i];
   } else {
    int diff = capacity - k;
    result += ((float) diff / weights[i]) * values[i];
    k += diff;
   }
  }
  return result;
 }

}
