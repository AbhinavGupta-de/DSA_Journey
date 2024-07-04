

public class MCandies {

    public long solve(int pos, int candies, int[] nums, int[][] dp) {
        if(candies < 0) return 0;
        if(pos == nums.length) {
            if(candies == 0) return 1;
            return 0;
        }

        if(dp[pos][candies] != -1) return dp[pos][candies];

        long ans = 0;
        int max = nums[pos];

        for(int i = 0; i <= max; i++) {
            ans += solve(pos + 1, candies - i, nums, dp);
        }

        return dp[pos][candies] = ans;
    }

}