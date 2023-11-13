package Questions.Searching.EasyQuestions;

/**
 * CountNegatives
 */
public class CountNegatives {

 public int countNegatives(int[][] grid) {
  // O(nlogm)
  // int count = 0;
  // for (int[] row : grid) {
  // count += binarySearch(row);
  // }
  // return count;

  // O(n+m)
  int count = 0, i = 0, j = grid[0].length - 1;
  while (i < grid.length && j >= 0) {
   if (grid[i][j] < 0) {
    count += grid.length - i;
    j--;
   } else {
    i++;
   }
  }

  return count;
 }

 // private int binarySearch(int[] row) {
 // int start = 0, end = row.length - 1, ans = -1;
 // while (start <= end) {
 // int mid = start + (end - start) / 2;
 // if (row[mid] < 0) {
 // ans = mid;
 // end = mid - 1;
 // } else {
 // start = mid + 1;
 // }
 // }
 // return ans == -1 ? 0 : row.length - ans;
 // }

}