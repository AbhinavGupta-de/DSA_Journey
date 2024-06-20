import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    private static long countSubarrayWithDistinctValues(long[] nums, long k) {
        long n = nums.length;
        HashMap<Long, Long> map = new HashMap<>();
        int l = 0;
        int r = 0;
        int dist = 0; // Correctly initialize dist to 0
        long count = 0L; // This should accumulate the count

        while (r < n) {
            if (!map.containsKey(nums[r]) || map.get(nums[r]) == 0) {
                dist++;
            }
            map.put(nums[r], map.getOrDefault(nums[r], 0L) + 1L);

            while (dist > k) {
                map.put(nums[l], map.get(nums[l]) - 1);
                if (map.get(nums[l]) == 0) {
                    dist--;
                }
                l++;
            }

            count += r - l + 1; // Accumulate the count correctly

            r++;
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        long k = Long.parseLong(input[1]);

        long[] nums = new long[n];
        String[] numStrings = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Long.parseLong(numStrings[i]);
        }

        System.out.println(countSubarrayWithDistinctValues(nums, k));
    }
}
