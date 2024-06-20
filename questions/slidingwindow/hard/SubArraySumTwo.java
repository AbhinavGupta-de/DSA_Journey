package questions.slidingwindow.hard;

public class SubArraySumTwo {

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

}