package questions.dp.hard;

public class NumberOfDigitOne {
    public int countDigitOne(int n) {

        int[][][] dp = new int[12][2][100];

        Arrays.stream(dp).forEach(k -> Arrays.stream(k).forEach(l -> Arrays.fill(l, -1)));

        return solve(n + "", 0, 1, 0, dp);

    }

    private int solve(String num, int pos, int tight, int ans, int[][][] dp) {

        if(pos == num.length()) return ans;

        int curr = (int) num.charAt(pos);

        if(dp[pos][tight][ans] != -1) return dp[pos][tight][ans];

        int max = (tight == 1) ? curr - '0' : 9;

        int count = 0;

        for(int i = 0; i <= max; i++) {
            int newTight = tight & ((i == max) ? 1 : 0);
            count += solve(num, pos + 1, newTight, (i == 1 ? ans + 1 : ans), dp);
        }

        return dp[pos][tight][ans] = count;

    }
}