package questions.slidingwindow.medium;

public class MaxConsecutiveOnesThree {

 public int countZeros(int[] preffixSum, int i, int j) {
  // return (j - i + 1) - (preffixSum[j] - preffixSum[i]) + 1;
  int sum = preffixSum[j];
  if (i > 0)
   sum -= preffixSum[i - 1];
  return (j - i + 1) - sum;
 }

 public int[] longestOne(int[] nums, int k) {

  // prefix Sum
  int[] preffixSum = new int[nums.length];
  preffixSum[0] = nums[0];
  for (int i = 1; i < nums.length; i++) {
   preffixSum[i] = preffixSum[i - 1] + nums[i];
  }

  int i = 0;
  int j = 0;

  int ansL = 0;
  int ansR = 0;

  while (i < nums.length) {

   while (j < nums.length && countZeros(preffixSum, i, j) <= k)
    j++;

   if ((j - i) > (ansR - ansL + 1)) {
    ansL = i;
    ansR = j - 1;
   }

   i++;
  }

  int[] ans = new int[ansR - ansL + 1];
  for (int z = 0; z < ans.length; z++) {
   ans[z] = ansL++;
  }

  return ans;
 }

}
