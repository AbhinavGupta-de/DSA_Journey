package extras;

import java.util.HashSet;

public class LuckyNumber {
 public int luckyNums(int n) {

  if (n < 6)
   return 0;

  int[] smallestPrimeFactor = new int[n + 1];

  smallestPrimeFactor[1] = 1;
  smallestPrimeFactor[2] = 2;

  for (int i = 2; i <= n; i++) {
   for (int j = i; j <= n; j += i) {
    if (smallestPrimeFactor[j] == 0)
     smallestPrimeFactor[j] = i;
   }
  }
  int result = 0;
  for (int i = 6; i <= n; i++) {

   if (checker(i, smallestPrimeFactor)) {
    result++;
   }

  }

  return result;
 }

 private boolean checker(int num, int[] smallestFactors) {

  HashSet<Integer> factors = new HashSet<>();
  int n = num;
  while (smallestFactors[n] != 1 && factors.size() <= 3) {
   factors.add(smallestFactors[n]);
   n /= smallestFactors[n];
  }
  if (factors.size() == 2)
   return true;
  return false;
 }

}
