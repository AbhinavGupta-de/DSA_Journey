package questions.Arrays.HardQuestions;

public class MaxValueEquation {

 public int findMaxValueOfEquation(int[][] points, int k) {

  // O(n) solution using Deque
  // We maintain a deque of points such that the difference between their
  // x-coordinates is at most k
  // We also maintain a variable max to keep track of the maximum value of y1 + y2
  // + |x1 - x2|

  // int max = Integer.MIN_VALUE;
  // Deque<int[]> deque = new ArrayDeque<>();

  // for (int[] point : points) {
  // int x = point[0];
  // int y = point[1];

  // // Remove points from the deque that are too far away from the current point
  // while (!deque.isEmpty() && x - deque.peekFirst()[0] > k) {
  // deque.pollFirst();
  // }

  // // If the deque is not empty, calculate the value of y1 + y2 + |x1 - x2| for
  // the
  // // current point and the point at the front of the deque
  // if (!deque.isEmpty()) {
  // int[] front = deque.peekFirst();
  // int value = front[1] + y + x - front[0];
  // max = Math.max(max, value);
  // }

  // // Remove points from the deque that have smaller y-coordinates than the
  // current
  // // point
  // while (!deque.isEmpty() && y - x > deque.peekLast()[1] - deque.peekLast()[0])
  // {
  // deque.pollLast();
  // }

  // // Add the current point to the deque
  // deque.offerLast(point);
  // }

  // return max;

  // My solution
  int max = Integer.MIN_VALUE;

  for (int i = 0; i < points.length - 1; i++) {
   for (int j = i + 1; j < points.length; j++) {
    int x1 = points[i][0];
    int y1 = points[i][1];
    int x2 = points[j][0];
    int y2 = points[j][1];

    if (x2 - x1 > k) {
     continue;
    } else {
     int value = y1 + y2 + Math.abs(x1 - x2);
     if (value > max) {
      max = value;
     }
    }
   }
  }
  return max;
 }
}
