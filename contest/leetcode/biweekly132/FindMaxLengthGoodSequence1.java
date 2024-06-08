package contest.leetcode.biweekly132;

public class FindMaxLengthGoodSequence1 {
    private int[][][] dp;

    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        dp = new int[k + 1][n + 1][n + 1];
        for (int[][] arr2d : dp) {
            for (int[] arr1d : arr2d) {
                Arrays.fill(arr1d, -1);
            }
        }
        if (n == 1) return 1;
        int ans = 1;
        for (int i = n - 2; i >= 0; i--) {
            ans = Math.max(ans, rec(nums, i, k, i + 1) + 1);
        }
        return ans;
    }

    private int rec(int[] nums, int i, int k, int pi) {
        if (i < 0 || k < 0) return 0;
        if (dp[k][i][pi] != -1) return dp[k][i][pi];

        if (nums[i] == nums[pi]) {
            return dp[k][i][pi] = 1 + rec(nums, i - 1, k, i);
        }
        if (k > 0) {
            return dp[k][i][pi] = Math.max(rec(nums, i - 1, k - 1, i) + 1, rec(nums, i - 1, k, pi));
        }
        return dp[k][i][pi] = rec(nums, i - 1, k, pi);
    }
}