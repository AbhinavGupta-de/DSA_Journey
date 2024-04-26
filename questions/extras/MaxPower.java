package questions.extras;

import java.util.ArrayList;

public class MaxPower {
 public int solve(ArrayList<Integer> A) {
  int MOD = 1000000007;
  long neg = 0;
  long even = 0;

  for (Integer i : A) {
   if (i < 0) {
    neg = (i % MOD + neg % MOD) % MOD;
   } else {
    even = (i % MOD + even % MOD) % MOD;
   }
  }
  neg = (neg % MOD * neg % MOD) % MOD;
  even = (even % MOD * even % MOD) % MOD;
  return (int) ((neg % MOD + even % MOD) % MOD);
 }
}
