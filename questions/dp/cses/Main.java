import java.io.*;
import java.util.*;

public class Main {
    private static int diceCombinations(int target, int[] dp) {
        if(target == 0) return 1;
        if(target < 0) return 0;
        if(dp[target] != -1) return dp[target];

        int ways = 0;
        for(int i = 1; i <= 6; i++) {
            ways = (ways + diceCombinations(target - i, dp)) % 1000000007;
        }

        return dp[target] = ways;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine().trim());

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        int ans = diceCombinations(n, dp);
        wr.println(ans);

        wr.close();
        br.close();

    }
}