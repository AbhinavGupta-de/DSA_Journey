package questions.dp.hard;

public class NonNegativeIntegersWithoutConsecutiveOnes {

    public int findIntegers(int n) {
        int[][][] dp = new int[32][2][2];
        Arrays.stream(dp).forEach(k -> Arrays.stream(k).forEach(j -> Arrays.fill(j, -1)));
        String num = toBinary(n);
        return solve(num, 0, 1, 0, dp);
    }

    private int solve(String num, int pos, int tight, int prev, int[][][] dp) {
        if(pos = num.length()) return 1;

        if(dp[pos][tight][prev] != -1) return dp[pos][tight][prev];

        int max = (tight == 1) ? num.charAt(pos) - '0' : 1;

        int ans = 0;

        for(int i = 0; i <= max; i++) {
            int newtight = (tight) & ((i == max) ? 1 : 0);

            if(i == 1 && prev == 1) continue;

            ans += solve(num, pos + 1, newtight, i, dp);
        }

        return dp[pos][tight][prev] = ans;
    }

    private String toBinary(int n) {
        StringBuilder str = new StringBuilder();

        for(int i = 30; i >= 0; i--) {
            if((n & (1 << i)) >= 1) str.append('1');
            else str.append('0');
        }

        return str.toString();
    }

}