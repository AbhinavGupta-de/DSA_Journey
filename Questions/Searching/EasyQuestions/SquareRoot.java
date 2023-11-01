package Questions.Searching.EasyQuestions;

public class SquareRoot {
 // Find square root using binary Search
 public int sqrt(int num) {
  int start = 1;
  int end = num;
  int ans = 0;

  while (start <= end) {
   int mid = (start + end) / 2;
   if (mid * mid == num) {
    return mid;
   } else if (mid * mid < num) {
    start = mid + 1;
    ans = mid;
   } else {
    end = mid - 1;
   }
  }
  return ans;
 }
}
