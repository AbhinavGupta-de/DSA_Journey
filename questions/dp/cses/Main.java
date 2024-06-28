import java.io.*;
import java.util.*;

public class Main {
    private static int coinCombinations2(int x, int i, int[] coins) {

        if(x == 0) return 1;
        if(i == coins.length || x < 0) return 0;

        int MOD = (int) 1e9 + 7;

        int ans1 = coinCombinations2(x, i + 1, coins);
        int ans2 = coinCombinations2(x - coins[i], i, coins);

        return (ans1 + ans2) % MOD;

    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] nums = new int[n];

        for(int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(coinCombinations2(x, 0, nums));
    }
}
