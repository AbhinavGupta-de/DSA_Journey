import java.util.*;

public class MagicNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        for(int i = 0 ; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        long[][] prefixAnd = new long[32][n];

        for(int i = 0; i < 32; i++) {
            prefixAnd[i][0] = (nums[0] >> i) & 1;
        }

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < 32; j++) {
                prefixAnd[j][i] = prefixAnd[j][i - 1] + ((nums[i] >> j) & 1);
            }
        }

        int q = sc.nextInt();

        for (int i = 0; i < q; i++) {
            int l = sc.nextInt() - 1;
            int r = sc.nextInt() - 1;

            long ans = 0;

            for(int j = 0; j < 32; j++) {
                long cnt = prefixAnd[j][r] - (l > 0 ? prefixAnd[j][l - 1] : 0);
                if(cnt == r - l + 1) {
                    ans |= (1 << j);
                }
            }

            System.out.println(ans);
        }

    }
}