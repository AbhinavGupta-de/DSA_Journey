package Questions.Searching.HardQuestions;

import java.util.Arrays;

public class AggressiveCows {
  // public int solve(int[] arr, int n, int c) {
  // int start = 0, end = arr[n - 1] - arr[0], ans = 0;
  // while (start <= end) {
  // int mid = start + (end - start) / 2;
  // if (isValid(arr, n, c, mid)) {
  // ans = mid;
  // start = mid + 1;
  // } else {
  // end = mid - 1;
  // }
  // }
  // return ans;
  // }

  // private boolean isValid(int[] arr, int n, int c, int mid) {
  // int cows = 1, pos = arr[0];
  // for (int i = 1; i < n; i++) {
  // if (arr[i] - pos >= mid) {
  // cows++;
  // pos = arr[i];
  // if (cows == c)
  // return true;
  // }
  // }
  // return false;
  // }

  public int maxDistance(int[] position, int m) {
    Arrays.sort(position);
    int start = 0, end = position[position.length - 1] - position[0];

    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (canWePlaceCows(position, m, mid)) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }

    return end;
  }

  public boolean canWePlaceCows(int[] position, int m, int count) {
    int cows = 1, pos = position[0];
    for (int i = 1; i < position.length; i++) {
      if (position[i] - pos >= count) {
        cows++;
        pos = position[i];
        if (cows == m)
          return true;
      }
    }
    return false;
  }
}
