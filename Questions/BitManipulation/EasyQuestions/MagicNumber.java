package Questions.BitManipulation.EasyQuestions;

public class MagicNumber {
 public static void main(String[] args) {
  int n = 6;

  int ans = 0;
  int base = 5;
  while (n > 0) {
   int lastBit = n & 1;
   n = n >> 1;
   ans += lastBit * base;
   base *= 5;
  }

  System.out.println(ans);
 }
}
