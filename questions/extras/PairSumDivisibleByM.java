package extras;

public class PairSumDivisibleByM {
 public int pairCount(int[] A, int B) {

  int[] modulo = new int[A.length];

  for (int i = 0; i < A.length; i++) {
   modulo[i] = A[i] % B;
  }

  // return countPairs(modulo, B);
  return 0;

 }

 // public int countPairs(int[] nums, int target) {

 // //

 // }

 // private long nC2(int num) {
 // return ((long) num - 1L) * (num) / 2L;
 // }

 public static void main(String[] args) {
  int[] nums = { 1, 2, 3, 4, 5 };
  int k = 2;

  System.out.println(new PairSumDivisibleByM().pairCount(nums, k));

 }
}
