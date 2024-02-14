package questions.searching.hard;

/**
 * SplitSubArray
 */
public class SplitSubArray {

  public int paint(int A, int B, int[] C) {
    // long ans = splitArray(C, A);
    // long b = (long)B;
    // int result = (int) ((b * ans));

    long ans = splitArray(C, A);

    return (int) ((B * ans) % 10000003);
  }

  public long splitArray(int[] nums, int k) {

    long start = nums[0];
    long sum = 0;
    for (long i : nums) {
      sum += i;
      if (i > start)
        start = i;
    }

    if (nums.length <= k) {
      return start;
    }
    ;

    long end = sum;

    while (start <= end) {
      long mid = (start + end) / 2;
      long subArrays = countSubArrays(nums, mid);

      if (k < subArrays) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return start;
  }

  public long countSubArrays(int[] nums, long maxSum) {
    long subarrays = 1;
    long sum = 0;

    for (int i = 0; i < nums.length; i++) {
      if (sum + nums[i] <= maxSum) {
        sum += nums[i];
      } else {
        subarrays++;
        sum = nums[i];
      }
    }

    return subarrays;
  }

  public static void main(String[] args) {
    int[] nums = { 1000000, 1000000 };
    SplitSubArray s = new SplitSubArray();
    int ans = s.paint(1, 1000000, nums);
    System.out.println(ans);
  }
}