package dp.easy;

public class Fibonacci {
 public int fib(int n) {
  // int[] opti = new int[n + 1];
  // return fibonacci(n, opti);
  return fibonacci(n);
 }

 public int fibonacci(int n, int[] optimization) {
  if (n < 2)
   return n;

  if (n != 0 && optimization[n - 1] == 0)
   optimization[n - 1] = fib(n - 1);
  if (n != 0 && optimization[n - 2] == 0)
   optimization[n - 2] = fib(n - 2);

  return optimization[n - 1] + optimization[n - 2];

 }

 public int fibonacci(int n) {
  if (n == 0)
   return 0;
  int[] nums = new int[n + 1];
  nums[1] = 1;

  int a = nums[0];
  int b = nums[1];
  int c = a + b;

  for (int i = 2; i < n + 1; i++) {
   c = a + b;
   a = b;
   b = c;
  }

  return c;
 }

}
