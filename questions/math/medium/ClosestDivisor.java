package questions.math.medium;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * ClosestDivisor
 */

/*
 * Thing I learnt from this question was that the upper limit on number of
 * divisors of a natural number is about the order of cubrt(n) -> It's not true
 * for everything just use it here as in CP this is what matters.
 * 
 * For 10^9 the upper limit is -> 1,344 -> 10^3
 * For 10^18 the upper limit is -> 1,03,680 -> 10 ^ 5
 * 
 */
public class ClosestDivisor {

 public List<Integer> getDivisors(int n) {
  List<Integer> divisors = new ArrayList<>();

  for (int i = 1; i * i <= n; i++) {
   if (n % i == 0) {
    divisors.add(i);
    divisors.add(n / i);
   }
  }

  return divisors;
 }

 public int[] closestDivisors(int num) {

  int minDiff = Integer.MAX_VALUE;
  int minIndex = 0;
  boolean isFirst = false;

  List<Integer> divisors1 = getDivisors(num + 1);
  List<Integer> divisors2 = getDivisors(num + 2);

  Collections.sort(divisors1); // 10^3 max number of elements so n(log(n)) isn't that big
  Collections.sort(divisors2); // same as above

 }
}