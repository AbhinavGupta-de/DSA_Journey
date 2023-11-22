package Questions.Searching.MediumQuestions;

import java.util.Comparator;
import java.util.Arrays;

public class FindRightInterval {

 public int[] findRightInterval(int[][] intervals) {

  Comparator<int[]> intervalComparator = new Comparator<int[]>() {
   @Override
   public int compare(int[] a, int[] b) {
    return (a[0] > b[0] ? 1 : -1);
   }
  };

  // Sort the given matrix
  Arrays.sort(intervals, intervalComparator);

  System.out.println(Arrays.deepToString(intervals));

  int[] result = new int[intervals.length];
  for (int i = 0; i < intervals.length; i++) {
   int target = intervals[i][1];
   int left = i + 1;
   int right = intervals.length - 1;
   int index = -1;

   // Perform binary search to find the right interval
   while (left <= right) {
    int mid = left + (right - left) / 2;
    if (intervals[mid][0] >= target) {
     index = mid;
     right = mid - 1;
    } else {
     left = mid + 1;
    }
   }

   result[i] = index != -1 ? intervals[index][0] : -1;
  }

  return result;
 }

 public static void main(String[] args) {
  int[][] matrix = { { 3, 4 }, { 2, 3 }, { 1, 2 } };

  FindRightInterval fr = new FindRightInterval();

  System.out.println(Arrays.toString(fr.findRightInterval(matrix)));
 }
}
