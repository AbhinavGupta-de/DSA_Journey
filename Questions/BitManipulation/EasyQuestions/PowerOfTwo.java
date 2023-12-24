package questions.bitmanipulation.easyquestions;

public class PowerOfTwo {
 public static void main(String[] args) {
  int n = 16;
  System.out.println("Is " + n + " power of two? " + isPowerOfTwo(n));
 }

 public static boolean isPowerOfTwo(int n) {
  return (n & (n - 1)) == 0;
 }
}
