package Questions.BitManipulation.EasyQuestions;

public class XORFromAToB {
 public static void main(String[] args) {
  int a = 5, b = 10;
  System.out.println("XOR of the numbers from " + a + " to " + b + " is " + xorFromAToB(a, b));
 }

 public static int xorFromAToB(int a, int b) {
  int xorTillA = XORTillN.xorTillN(a - 1);
  int xorTillB = XORTillN.xorTillN(b);
  return xorTillA ^ xorTillB;
 }
}
