package Questions.Searching.EasyQuestions;

public class SquareRoot {
 // Find square root using binary Search
 public int sqrt(int num) {
  int start = 1;
  int end = num;
  int ans = 0;

  while (start <= end) {
   int mid = start + (end - start) / 2;
   if ((long) mid * mid == num) {
    return mid;
   } else if ((long) mid * mid < num) {
    start = mid + 1;
    ans = mid;
   } else {
    end = mid - 1;
   }
  }
  return ans;
 }

 public static void main(String[] args) {
  int sqrt = new SquareRoot().sqrt(808201);

  System.out.println(sqrt);
 }
}
