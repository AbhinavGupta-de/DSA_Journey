package questions.math.medium;

public class Power {

 public double myPow(double x, int n) {

  if (n == 0)
   return 1;

  if (n < 0) {
   return 1 / power(x, -1 * ((long) n));
  }

  return power(x, n);
 }

 public double power(double x, long n) {
  if (n <= 1)
   return x;

  double num = power(x, n / 2);
  if (n % 2 == 0) {
   return num * num;
  }

  return num * num * x;
 }

}
