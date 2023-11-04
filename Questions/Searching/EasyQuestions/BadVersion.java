package Questions.Searching.EasyQuestions;

public class BadVersion {

 public int firstBadVersion(int n) {
  int start = 1, end = n;

  while (start <= end) {
   int mid = start + (end - start) / 2;
   if (isBadVersion(mid)) {
    end = mid - 1;
   } else {
    start = mid + 1;
   }
  }
  return start;
 }

 public boolean isBadVersion(int mid) {
  return true;
 }

}
