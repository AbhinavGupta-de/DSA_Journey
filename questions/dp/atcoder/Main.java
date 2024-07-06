import java.util.*;
import java.io.*;

public class Main {

    public static int knapsack(int N, int W, int[][] sacks) {
        int maxValue = 0;
        for (int[] sack : sacks) {
            maxValue += sack[0];
        }
        long[][] dp = new long[N + 1][maxValue + 1];
        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }
        int ans = 0;
        for (int profit = 0; profit <= maxValue; profit++) {
            if (possibleMinWeight(0, profit, dp, sacks, N) <= W) {
                ans = profit;
            }
        }
        return ans;
    }

    private static long possibleMinWeight(int index, int profit, long[][] dp, int[][] sacks, int N) {
        if (profit == 0) return 0;
        if (index == N) return (long) 1e14;

        if (dp[index][profit] != -1) return dp[index][profit];

        long ans1 = possibleMinWeight(index + 1, profit, dp, sacks, N);
        long ans2 = Integer.MAX_VALUE;
        if (profit >= sacks[index][0]) {
            ans2 = sacks[index][1] + possibleMinWeight(index + 1, profit - sacks[index][0], dp, sacks, N);
        }

        return dp[index][profit] = Math.min(ans1, ans2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int W = sc.nextInt();

        int[][] sacks = new int[N][2];
        for (int i = 0; i < N; i++) {
            sacks[i][0] = sc.nextInt();  // profit
            sacks[i][1] = sc.nextInt();  // weight
        }

        System.out.println(knapsack(N, W, sacks));
    }
}
