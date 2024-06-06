package questions.dp.cses;

public class CoinCombinations1 {

    private static int coinCombinations(int x, int[] coins) {
        int mod = (int) 1e9 + 7;

        int[] dp = new int[x + 1];

        for(int curr = x; curr >= 0; curr--) {
            if(curr == x) {
                dp[curr] = 1;
                continue;
            }

            for(int i = 0; i < coins.length; i++) {
                if(curr + coins[i] <= x) {
                    dp[curr] = (dp[curr] + dp[curr + coins[i]]) % mod;
                }
            }
        }

        return dp[0];

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

        String[] input = br.readLine().trim().split(" ");
        int n = Integer.parseInt(input[0]);
        int x = Integer.parseInt(input[1]);
        int[] coins = new int[n];
        String[] input1 = br.readLine().trim().split(" ");
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(input1[i]);
        }

        int ans = coinCombinations(x, coins);
        wr.println(ans);

        wr.close();
        br.close();
    }

}