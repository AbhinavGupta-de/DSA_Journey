package questions.dp.medium;

public class SumOfDigitsInGivenRange {

    int[][] dp = new int[18][18 * 9 + 1];

    private int calSum(int pos, int n, int sum, int k) {
        if(pos == n) return sum == k ? 1 : 0;
        if(dp[pos][sum] != -1) return dp[pos][sum];

        long ans  = 0l;

        for(int i = 0; i < 10; i++) {
            ans += calSum(pos + 1, n, sum + i, k);
        }

        return dp[pos][sum] = ans;
    }

    public int[][] solve(int[][] qurries) {

        int[] ans = qurries.length;

        for(int i = 0; i < qurries.length; i++){
            int l = qurries[0];
            int r = qurries[1];
            int n = qurries[2];

            ans[i] = calSum(0, 17, 0, n)
        }

    }

    int[][][] dp3 = new int[18][18*9 + 1][10];
    Arrays.stream(dp3).forEach(d -> Arrays.stream(d).forEach(k -> Arrays.fill(k, -1)));

    private int reqGCDandSum(int idx,int sum, int cgcd, int len, int reqSum, int reqGcd) {
        if(idx == len) return (sum == reqSum && cgcd == reqGcd) ? 1 : 0;

        if(dp3[idx][sum][cgcd] != -1) return dp3[idx][sum][cgcd];

        int ans = 0;

        for(int i = 0; i < 10; i++){
            ans += reqGCDandSum(idx + 1, sum + i, gcd(cgcd, i), len, reqSum, reqGcd);
        }

        return dp3[idx][sum][cgcd] = ans;

    }

    private int gcd(int a, int b) {
        if(b == 0) return a;

        return gcd(b, a%b);
    }

}