package dp.easy;

public class Tribonacci {

  public int tribonacci(int n) {
    return fibonacci(n);
  }

  public int fibonacci(int n) {
    if (n == 0)
      return 0;

    if (n < 3)
      return 1;

    int[] nums = new int[n + 1];
    nums[1] = 1;
    nums[2] = 1;

    int a = nums[0];
    int b = nums[1];
    int c = nums[2];
    int d = a + b + c;

    for (int i = 3; i < n + 1; i++) {
      d = a + b + c;
      a = b;
      b = c;
      c = d;
    }

    return d;
  }
}
