package questions.BitManipulation.EasyQuestions;

/**
 * ReverseBits
 */
public class ReverseBits {

 public static long reverseBits(long num) {
  int rev = 0;
  for (int i = 0; i < 32; i++) {
   rev <<= 1;
   rev |= (num & 1);
   num >>= 1;
  }

  return rev;
 }

 public static void main(String[] args) {
  long num = 13;
  System.out.println(reverseBits(num));
 }
}