import java.io.*;
import java.util.*;

public class Main {
    private static long removalGame(long[] nums) {
        int n = nums.length;
        long[][] dp = new long[n][n];

        // Fill the dp array
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                long a = (i + 2 <= j) ? dp[i + 2][j] : 0;
                long b = (i + 1 <= j - 1) ? dp[i + 1][j - 1] : 0;
                long c = (i <= j - 2) ? dp[i][j - 2] : 0;

                dp[i][j] = Math.max(nums[i] + Math.min(a, b), nums[j] + Math.min(b, c));
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] nums = new long[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextLong();
        }

        System.out.println(removalGame(nums));
    }
}
