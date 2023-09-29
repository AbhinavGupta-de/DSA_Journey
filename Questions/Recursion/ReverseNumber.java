package Questions.Recursion;

/**
 * ReverseNumber
 */
public class ReverseNumber {

 public static int reverseNumber(int n) {
  if (n == 0)
   return 0;
  // * n % 10 gives the last digit of the number
  // * (int) Math.log10(n) gives the number of digits in the number
  // * (int) Math.pow(10, (int) Math.log10(n)) gives the power of 10 to be
  // * multiplied with the last digit
  // * n / 10 gives the number without the last digit
  return n % 10 * (int) Math.pow(10, (int) Math.log10(n)) + reverseNumber(n / 10);
 }

 public static void main(String[] args) {
  System.out.println(reverseNumber(458));
 }
}