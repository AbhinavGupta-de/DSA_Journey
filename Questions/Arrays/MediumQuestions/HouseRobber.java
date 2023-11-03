package Questions.Arrays.MediumQuestions;

/**
 * HouseRobber
 */
public class HouseRobber {

 // PreffixSum

 public int rob(int[] nums) {

  int evenSum = nums[0];
  int oddSum = 0;

  for (int i = 1; i < nums.length; i++) {
   if (i % 2 == 0) {
    evenSum = Math.max(evenSum + nums[i], oddSum);
   } else {
    oddSum = Math.max(oddSum + nums[i], evenSum);
   }
  }

  return Math.max(evenSum, oddSum);

 }

 public static void main(String[] args) {
  int[] nums = { 1, 1 };
  HouseRobber obj = new HouseRobber();
  System.out.println(obj.rob(nums));
 }

}