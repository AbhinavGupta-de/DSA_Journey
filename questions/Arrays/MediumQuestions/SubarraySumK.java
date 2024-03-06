package Arrays.MediumQuestions;

/**
 * SubarraySumK
 */
public class SubarraySumK {

 public int subarraySum(int[] nums, int k) {

  int[] preffixSum = new int[nums.length];
  preffixSum[0] = nums[0];

  for (int i = 1; i < nums.length; i++) {
   preffixSum[i] = preffixSum[i - 1] + nums[i];
  }

 }

}