package Questions.BitManipulation;

public class Power {
 public static void main(String[] args) {
  int base = 2;
  int power = 4;
  System.out.println(base + " raised to the power of " + power + " is " + power(base, power));
 }

 public static int power(int num, int power) {
  int ans = 1;
  while (power > 0) {
   int lastBit = power & 1;
   power = power >> 1;
   if (lastBit == 1) {
    ans *= num;
   }
   num *= num;
  }
  return ans;
 }
}
