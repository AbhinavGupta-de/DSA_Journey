package Questions.Arrays.EasyQuestions;

// Minimum Cost to Move Chips to The Same Position
// https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/description/
public class MoveCoins {
  public int minCostToMoveChips(int[] nums) {
    int even = 0;
    int odd = 0;
    for (int i : nums) {
      if (i % 2 == 0)
        even++;
      else
        odd++;
    }
    return Math.min(even, odd);
  }
}
