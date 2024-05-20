package questions.backtracking;

public class SumOfAllSubsetXORTotal {
    public int subsetXORSum(int[] nums) {
        return subsetXORSum(nums, 0, 0, 0);
    }

    private int subsetXORSum(int[] nums, int index, int xor, int total) {
        if (index == nums.length) {
            return total + xor;
        }

        return subsetXORSum(nums, index + 1, xor ^ nums[index], total) + subsetXORSum(nums, index + 1, xor, total);
    }
}