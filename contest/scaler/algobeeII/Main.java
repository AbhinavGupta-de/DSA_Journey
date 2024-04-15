package contest.scaler.algobeeII;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();

    for (int i = 0; i < t; i++) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      int min = Integer.MAX_VALUE;
      for (int j = 0; j < n; j++) {
        arr[j] = sc.nextInt();
        min = Math.min(min, arr[j]);
      }

      long[] prefixSum = new long[n + 1];
      for (int j = 0; j < n; j++) {
        prefixSum[j + 1] = prefixSum[j] + arr[j];
      }

      long total = n * (n + 1L) / 2;
      long count = countSubarray(prefixSum, 0);
      System.out.println(total - count);
    }
  }

  static long countSubarray(long[] prefixSum, int k) {
    Arrays.sort(prefixSum);
    int n = prefixSum.length;

    int start = 0, end = 0;
    long count = 0;

    while (end < n) {
      if (prefixSum[end] - (start > 0 ? prefixSum[start - 1] : 0) < k) {
        end++;
        if (end >= start)
          count += end - start;
      } else {
        start++;
      }
    }

    return count;
  }
}