package questions.Arrays.HardQuestions;

public class TrappingRainWater {
 public int trap(int[] nums) {

  int n = nums.length;
  int water = 0;
  int leftMax = 0;
  int leftMaxIndex = 0;
  int rightMax = 0;

  for (int i = 0; i < n; i++) {

   if (nums[i] > leftMax) {

    leftMax = nums[i];
    leftMaxIndex = i;

   } else {

    water += leftMax - nums[i];

   }
  }

  for (int i = n - 1; i > leftMaxIndex; i--) {

   if (nums[i] > rightMax) {

    rightMax = nums[i];

   } else {

    water += rightMax - nums[i];

   }
  }

  for (int i = leftMaxIndex; i < n; i++) {
   water -= leftMax - nums[i];
  }

  return water;
 }
}
