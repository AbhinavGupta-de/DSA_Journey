import java.io.*;
import java.util.*;

public class Main {
    private static long solve(long[] nums) {
        long[][] dp = new long[nums.length][nums.length];
        Arrays.stream(dp).forEach(k -> Arrays.fill(k, -1));
        return helper(0, nums.length - 1, nums, dp);
    }

    private static long helper(int start, int end, long[] nums, long[][] dp) {
        if (start == end) return nums[start];
        if(dp[start][end] != -1) return dp[start][end];

        long left = nums[start] - helper(start + 1, end, nums, dp);
        long right = nums[end] - helper(start, end - 1, nums, dp);

        return dp[start][end] = Math.max(left, right);
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] nums = new long[n];

        for(int i = 0; i < n; i++) {
            nums[i] = sc.nextLong();
        }

        System.out.println(solve(nums));
    }
}
