package Questions.BitManipulation.MediumQuestions;

public class Divide {
 public int divide(int A, int B) {

  long divident = A;
  long divisor = B;

  return ans(divident, divisor);

 }

 public int ans(long A, long B) {

  int multiplier = 1;

  if (A == Integer.MIN_VALUE) {
   if (B == 1)
    return Integer.MIN_VALUE;
   if (B == -1)
    return Integer.MAX_VALUE;
  }

  if (A > 0 && B < 0) {
   B = (-1) * B;
   multiplier = -1;
  } else if (A < 0 && B > 0) {
   A = (-1) * A;
   multiplier = -1;
  }
  if (A < 0 && B < 0) {
   B = (-1) * B;
   A = (-1) * A;
  }

  long ans = division(A, B);

  if (ans > Integer.MAX_VALUE)
   return Integer.MAX_VALUE;

  return (int) ans * multiplier;

 }

 public long division(long A, long B) {
  if (A == 0)
   return 0;
  if (B == 1)
   return A;

  long ans = 0;
  for (int i = 31; i >= 0; i--) {
   if ((B << i) <= A) {
    ans = (ans | (1 << i));
    A -= (B << i);
   }
  }

  return ans;
 }
}
