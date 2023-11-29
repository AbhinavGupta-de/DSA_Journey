package Questions.BitManipulation.MediumQuestions;

public class SumOfOR {
 public long sumOR(int[] A) {

  long ans = 0;

  for (long i = 31; i >= 0; i--) {
   long temp = A.length;
   long zeros = 0;
   for (int j : A) {
    if (((long) j & (1L << i)) > 0) {
     ans += (zeros + 1) * (temp) * (1L << i);
     zeros = 0;
    } else
     zeros++;

    temp--;
   }
  }
  return ans;
 }
}
