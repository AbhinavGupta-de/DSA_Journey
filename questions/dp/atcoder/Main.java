import java.util.*;
import java.io.*;

public class Main {

    public static long solve(int candies, int[] nums) {
        int MOD = (int) 1e9 + 7;

        long[][] dp = new long[nums.length + 1][candies + 1];
        long[][] prefix = new long[nums.length + 1][candies + 1];

        for (int pos = nums.length; pos >= 0; pos--) {
            for (int k = 0; k <= candies; k++) {
                if (pos == nums.length) {
                    if (k == 0) dp[pos][k] = 1;
                    else dp[pos][k] = 0;
                } else {
                    int max = Math.min(k, nums[pos]);

                    if (max >= 0) {
                        long ans = 0L;
                        int start = k - max;
                        int end = k;

                        ans = (prefix[pos + 1][end] - (start > 0 ? prefix[pos + 1][start - 1] : 0) + MOD) % MOD;
                        dp[pos][k] = ans;
                    }
                }
            }

            prefix[pos][0] = dp[pos][0];
            for (int i = 1; i <= candies; i++) {
                prefix[pos][i] = (prefix[pos][i - 1] + dp[pos][i]) % MOD;
            }
        }

        return dp[0][candies];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(solve(k, nums));
    }
}
