package Questions.Recursion.Easy_Cllg_Questions;

public class AnyBaseToDecimal {

 public int anyBaseToDecimal(int num, int base) {

  // Without recursion (iterative) -> O(n)
  // int ans = 0;
  // int multiplier = 1;
  // while (num != 0) {
  // ans += (num % 10) * multiplier;
  // multiplier *= base;
  // num /= 10;
  // }
  // return ans;

  // With recursion -> O(n)
  return conversion(num, base, 0);
 }

 public int conversion(int num, int base, int power) {
  // Base case
  if (num == 0)
   return 0;

  // Finding the power of the base to multiply with the last digit of the number
  int multiplier = (int) Math.pow(base, power);

  // Multiplying the last digit of the number with the power of the base
  int ans = (num % 10) * multiplier;

  // Recursively calling the function for the remaining digits of the number
  return ans + conversion(num / 10, base, power + 1);
 }
}
