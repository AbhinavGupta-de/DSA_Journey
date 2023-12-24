package questions.arrays.mediumquestions;

public class JumpGame {

  public boolean canJump(int[] nums) {

    // if (nums.length == 1) {
    // return true;
    // }

    // for (int i = 0; i < nums.length - 1; i++) {

    // if (nums[i] == 0) {
    // int j = i - 1;

    // while (j >= 0) {
    // if (nums[j] == i - j && i - j == nums.length - 1)
    // break;
    // if (nums[j] > i - j) {
    // break;
    // }
    // j--;
    // }
    // if (j < 0) {
    // return false;
    // }
    // }
    // }

    // return true;

    int boundary = 0;
    for (int i = 0; i <= boundary; i++) {
      boundary = Math.max(boundary, i + nums[i]);
      if (boundary >= nums.length - 1)
        return true;
    }
    return false;
  }
}
