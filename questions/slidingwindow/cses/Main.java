import java.io.*;
import java.util.*;

public class Main {

    public static long sum(long[] arr, long X) {
        int N = arr.length;

        Map<Long, Long> prefSums = new HashMap<>();
        prefSums.put(0L, 1L);

        long pref = 0L;
        long cnt = 0L;

        for (int i = 0; i < N; ++i) {
            pref += arr[i];
            cnt += prefSums.getOrDefault(pref - X, 0L);
            prefSums.put(pref, prefSums.getOrDefault(pref, 0L) + 1);
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        long target = Long.parseLong(input[1]);

        long[] nums = new long[n];
        String[] numStrings = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Long.parseLong(numStrings[i]);
        }

        System.out.println(sum(nums, target));
    }
}
