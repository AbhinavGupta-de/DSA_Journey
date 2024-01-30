package questions.BitManipulation.EasyQuestions;

/**
 * OddOrEven
 */
public class OddOrEven {

 public static void main(String[] args) {
  int n = 5;
  System.out.println(isOdd(n));
 }

 public static boolean isOdd(int n) {
  return (n & 1) == 1;
 }
}