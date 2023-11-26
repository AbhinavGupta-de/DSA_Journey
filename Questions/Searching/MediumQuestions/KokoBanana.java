package Questions.Searching.MediumQuestions;

/**
 * KokoBanana
 */
public class KokoBanana {

 public long minVal(int[] nums) {
  long min = Long.MAX_VALUE;

  for (int i : nums) {
   min = Math.min(min, i);
  }

  return min;
 }

 public long maxVal(int[] nums) {
  long max = Long.MIN_VALUE;

  for (int i : nums) {
   max = Math.max(max, i);
  }

  return max;
 }

 public int minEatingSpeed(int[] piles, int h) {
  if (piles.length == 1) {
   return (int) Math.ceil((double) piles[0] / h);
  }

  long start = 1;
  long end = maxVal(piles);

  while (start <= end) {
   long mid = start + (end - start) / 2;

   if (checker(piles, mid, h)) {
    end = mid - 1;
   } else {
    start = mid + 1;
   }
  }

  return (int) start;
 }

 public boolean checker(int[] nums, long mid, int h) {
  long count = 0;

  for (int i : nums) {
   count += (long) Math.ceil((double) i / mid);
   if (count > Integer.MAX_VALUE) {
    return false;
   }
  }

  return count <= h;
 }
}