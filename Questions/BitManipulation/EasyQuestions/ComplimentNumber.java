package Questions.BitManipulation.EasyQuestions;

/**
 * ComplimentNumber
 */
public class ComplimentNumber {

 public Integer findComplement(int num) {
  // int ans = 0;
  // int i = 0;
  // while (num > 0) {
  // if ((num & 1) == 0) {
  // ans += (1 << i);
  // }
  // i++;
  // num >>= 1;
  // }
  // return ans;

  // ~5 = 11111111111111111111111111111010
  // 1 << 3 = 00000000000000000000000000001000
  // 1 << 3 - 1 = 00000000000000000000000000000111
  // ~5 & (1 << 3 - 1) = 00000000000000000000000000000010
  return ~num & ((Integer.highestOneBit(num) << 1) - 1);
 }

 public static void main(String[] args) {
  ComplimentNumber cn = new ComplimentNumber();
  System.out.println(cn.findComplement(5));
 }

}