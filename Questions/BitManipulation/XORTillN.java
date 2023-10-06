package Questions.BitManipulation;

public class XORTillN {
 public static void main(String[] args) {
  int n = 5;
  System.out.println("XOR of the numbers till " + n + " is " + xorTillN(n));
 }

 public static int xorTillN(int n) {
  if (n % 4 == 0)
   return n;
  if (n % 4 == 1)
   return 1;
  if (n % 4 == 2)
   return n + 1;
  return 0;
 }
}
