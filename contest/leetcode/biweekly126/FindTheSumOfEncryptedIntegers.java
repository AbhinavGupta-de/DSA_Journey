package contest.leetcode.biweekly126;

public class FindTheSumOfEncryptedIntegers {
 public int sumOfEncryptedInt(int[] nums) {

  int sum = 0;

  for (int i : nums) {
   sum += encrypt(i);
   System.out.println(encrypt(i));
  }

  return sum;
 }

 public int encrypt(int num) {

  int digits = (int) Math.log10(num);

  int temp = num;

  int max = Integer.MIN_VALUE;

  while (temp > 0) {
   int digit = temp % 10;
   max = Math.max(digit, max);
   temp /= 10;
  }

  int construct = max;
  // Create max number with same number of digits using max digit
  for (int i = 0; i < digits; i++) {
   construct *= 10;
   construct += max;
  }

  return construct;

 }

 public static void main(String[] args) {
  int[] nums = { 776, 858, 33, 969, 1000, 968 };
  System.out.println(new FindTheSumOfEncryptedIntegers().sumOfEncryptedInt(nums));
 }
}
