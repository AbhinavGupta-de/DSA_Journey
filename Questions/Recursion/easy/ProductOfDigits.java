package questions.recursion.easy;

public class ProductOfDigits {
 public static int productOfDigits(int n) {
  if (n == 0)
   return 1;

  return n % 10 * productOfDigits(n / 10);
 }

 public static void main(String[] args) {
  System.out.println(productOfDigits(458));
 }
}
