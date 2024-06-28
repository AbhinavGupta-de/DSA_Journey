package questions.dp.cses;

public class CoinCombination2 {

    private static int coinCombinations2(int x, int i, int[] coins) {

        if(x == 0) return 1;
        if(i == coins.length || x < 0) return 0;

        int MOD = (int) 1e9 + 7;

       int ans1 = coinCombinations2(x, i + 1, coins);
        int ans2 = coinCombinations2(x - coins[i], i, coins);

     return (ans1 + ans2) % MOD;

    }

    private static int coinCombinations2(int x, int[] coins) {
        int MOD = (int) 1e9 + 7;

        int[][] dp = new int[coins.length + 1][x + 1];

        for()
        return dp[x];
    }

}