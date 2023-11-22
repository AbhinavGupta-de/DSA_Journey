package Questions.BitManipulation.EasyQuestions;

/**
 * TotalHammingDistance
 */
public class TotalHammingDistance {

 public int totalHammingDistance(int[] nums) {
  return cntBits(nums);
 }

 public int cntBits(int[] nums) {

  int ans = 0;

  for (int i = 0; i < 32; i++) {
   int setbits = countSetBits(nums, i);
   int unsetbits = nums.length - setbits;

   int MOD = (int) Math.pow(10, 9) + 7;
   ans += (setbits * unsetbits) % MOD;
  }

  return ans;

 }

 public int countSetBits(int[] arr, int i) {
  int count = 0;
  int mask = (1 << i);
  for (int j = 0; j < arr.length; j++) {
   if ((arr[j] & mask) != 0) {
    count++;
   }
  }
  return count;
 }

 public static void main(String[] args) {
  int[] arr = { 4, 14, 2 };
  TotalHammingDistance thd = new TotalHammingDistance();
  System.out.println(thd.totalHammingDistance(arr));
 }

}