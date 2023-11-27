package Questions.Searching.MediumQuestions;

public class MinimumNumberOfDaysToMakeBouquet {

 public int min(int[] arr) {
  int min = Integer.MAX_VALUE;
  for (int i = 0; i < arr.length; i++) {
   min = Math.min(min, arr[i]);
  }
  return min;
 }

 public int max(int[] arr) {
  int max = Integer.MIN_VALUE;
  for (int i = 0; i < arr.length; i++) {
   max = Math.max(max, arr[i]);
  }
  return max;
 }

 public int minDays(int[] bloomDay, int m, int k) {

  int start = min(bloomDay);
  int end = max(bloomDay);

  int ans = -1;

  while (start <= end) {
   int mid = start + (end - start) / 2;

   if (isPossible(bloomDay, m, k, mid)) {
    ans = mid;
    end = mid - 1;
   } else {
    start = mid + 1;
   }
  }

  return ans;

 }

 public boolean isPossible(int[] bloomDay, int m, int k, int day) {
  int flower = 0;
  int bouquets = 0;
  for (int i = 0; i < bloomDay.length; i++) {
   if (bloomDay[i] <= day) {
    flower++;
   } else {
    flower = 0;
    bouquets += flower / k;
   }
  }

  bouquets += flower / k;
  return bouquets >= m;
 }
}
