package Questions.Searching.HardQuestions;

public class AggressiveCows {
 public int solve(int[] arr, int n, int c) {
  int start = 0, end = arr[n - 1] - arr[0], ans = 0;
  while (start <= end) {
   int mid = start + (end - start) / 2;
   if (isValid(arr, n, c, mid)) {
    ans = mid;
    start = mid + 1;
   } else {
    end = mid - 1;
   }
  }
  return ans;
 }

 private boolean isValid(int[] arr, int n, int c, int mid) {
  int cows = 1, pos = arr[0];
  for (int i = 1; i < n; i++) {
   if (arr[i] - pos >= mid) {
    cows++;
    pos = arr[i];
    if (cows == c)
     return true;
   }
  }
  return false;
 }
}
