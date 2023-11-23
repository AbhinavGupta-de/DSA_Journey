package Questions.Searching.MediumQuestions;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Arrays;

public class FindRightInterval {

 public int[] findRightInterval(int[][] intervals) {

  // Creating a map of intervals and their indices
  HashMap<int[], Integer> map = new HashMap<>();
  for (int i = 0; i < intervals.length; i++) {
   map.put(intervals[i], i);
  }

  sort(intervals);

  int[] result = new int[intervals.length];

  for (int i = 0; i < intervals.length; i++) {

   int index = findIndex(intervals, intervals[i][1], i, intervals.length - 1);

   result[map.get(intervals[i])] = index != -1 ? map.get(intervals[index]) : -1;

  }

  return result;
 }

 public int findIndex(int[][] intervals, int target, int left, int right) {
  int index = -1;

  while (left <= right) {
   int mid = left + (right - left) / 2;

   if (intervals[mid][0] == target)

    return mid;
   else if (intervals[mid][0] > target) {
    index = mid;
    right = mid - 1;

   } else

    left = mid + 1;

  }
  // System.out.println(index);
  return index;
 }

 public void sort(int[][] matrix) {
  Comparator<int[]> compare = new Comparator<int[]>() {
   @Override
   public int compare(int[] a, int[] b) {
    return (a[0] > b[0] ? 1 : -1);
   }
  };

  Arrays.sort(matrix, compare);
  // System.out.println(Arrays.deepToString(matrix));
 };

 public static void main(String[] args) {
  int[][] matrix = { { 1, 1 }, { 3, 4 } };

  FindRightInterval fr = new FindRightInterval();

  System.out.println(Arrays.toString(fr.findRightInterval(matrix)));
 }
}
