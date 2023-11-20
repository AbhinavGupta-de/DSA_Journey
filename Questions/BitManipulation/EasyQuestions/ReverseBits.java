package Questions.BitManipulation.EasyQuestions;

/**
 * ReverseBits
 */
public class ReverseBits {

 public static long reverseBits(long num) {
  long len = 0;
  long temp = num;
  while (temp != 0) {
   len++;
   temp = temp >> 1;
  }

  return num << (32 - len);
 }

 public static void main(String[] args) {
  long num = 13;
  System.out.println(reverseBits(num));
 }
}