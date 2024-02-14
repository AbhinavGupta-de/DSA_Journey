package questions.BitManipulation.EasyQuestions;

public class SetBitsNumber {
 public static void main(String[] args) {
  int n = 15;
  System.out.println("Number of set bits in " + n + " is " + setBits(n));
  System.out.println("Number of set bits in " + n + " is " + Integer.bitCount(n));
 }

 public static int setBits(int n) {
  int ans = 0;

  while (n > 0) {
   ans++;
   n = n & (n - 1);
  }
  return ans;
 }
}
