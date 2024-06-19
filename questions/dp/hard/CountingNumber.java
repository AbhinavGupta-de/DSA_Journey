package questions.dp.hard;

public class CountingNumber {

    private static long solve(long a, long b) {
        long left = getNumbers(a - 1);
        long right = getNumbers(b);
        return right - left;
    }

    private static long getNumbers(long n) {
        if (n == 0) return 1;
        String num = Long.toString(n);
        long[][][][] dp = new long[20][10][2][2];
        Arrays.stream(dp).forEach(k -> Arrays.stream(k).forEach(l -> Arrays.stream(l).forEach(d -> Arrays.fill(d, -1))));
        return helper(num, 0, 0, 1, 1, dp);
    }

    private static long helper(String s, int pos, int prev, int leading_zero, int tight, long[][][][] dp) {
        if (pos == s.length()) return 1;
        if (dp[pos][prev][leading_zero][tight] != -1) return dp[pos][prev][leading_zero][tight];

        int max = (tight == 1) ? s.charAt(pos) - '0' : 9;
        long ans = 0;

        for (int i = 0; i <= max; i++) {
            int newTight = (tight == 1 && i == max) ? 1 : 0;
            if (i == prev && leading_zero == 0) continue;

            int newLeadingZero = (leading_zero == 1 && i == 0) ? 1 : 0;
            ans += helper(s, pos + 1, i, newLeadingZero, newTight, dp);
        }

        return dp[pos][prev][leading_zero][tight] = ans;
    }
}

}