package questions.dp.cses;

import java.util.Arrays;

public class RemovalGame {
    public static long solve(long[] nums) {
        long[][] dp = new long[nums.length][nums.length];
        Arrays.stream(dp).forEach(k -> Arrays.fill(k, -1));
        return helper(0, nums.length - 1, nums, dp);
    }

    private static long helper(int start, int end, long[] nums, long[][] dp) {
        if (start > end) return 0;
        if (dp[start][end] != -1) return dp[start][end];

        long left = nums[start] + Math.min(helper(start + 2, end, nums, dp), helper(start + 1, end - 1, nums, dp));
        long right = nums[end] + Math.min(helper(start + 1, end - 1, nums, dp), helper(start, end - 2, nums, dp));

        return dp[start][end] = Math.max(left, right);
    }

//    works in c++ becauase no index out of bound error... java has index out of bound error
    private static long removalGame(long[] nums) {

        int[][] dp = new int[nums.length][nums.length];

        for(int i = 0; i < nums.length/2; i++) {
            for(int j = nums.length - 1; j >= nums.length/2; j--) {
               dp[i][j] = Math.max(nums[i] + Math.min(dp[i + 2][j], dp[i + 1][j - 1]), nums[j] + Math.min(dp[i + 1][j - 1], dp[i][j - 2]));
            }
        }

        return dp[0][nums.length - 1];
    }
}
