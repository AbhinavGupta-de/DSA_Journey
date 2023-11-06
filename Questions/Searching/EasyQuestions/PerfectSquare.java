package Questions.Searching.EasyQuestions;

public class PerfectSquare {

 public boolean isPefectSquare(int num) {
  int start = 1;
  int end = (num / 2) + 1;
  int ans = 0;

  while (start <= end) {
   int mid = start + (end - start) / 2;
   if (mid * mid == num) {
    return true;
   } else if (mid * mid < num) {
    start = mid + 1;
    ans = mid;
   } else {
    end = mid - 1;
   }
  }
  return ans * ans == num;
 }

}
