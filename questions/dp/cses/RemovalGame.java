package questions.dp.cses;

public class RemovalGame {

    private static long solve(long[] nums) {
        long[][] dp = new long[nums.length][nums.length];
        Arrays.stream(dp).forEach(k -> Arrays.fill(k, -1));
        return helper(0, nums.length - 1, nums, dp);
    }

    private static long helper(int start, int end, long[] nums, long[][] dp) {
        if (start == end) return nums[start];
        if(dp[start][end] != -1) return dp[start][end];

        long left = nums[start] - helper(start + 1, end, nums);
        long right = nums[end] - helper(start, end - 1, nums);

        return dp[start][end] = Math.max(left, right);
    }

}