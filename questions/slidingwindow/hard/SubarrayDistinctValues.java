package questions.slidingWindow.hard;

public class SubarrayDistinctValues {
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
}