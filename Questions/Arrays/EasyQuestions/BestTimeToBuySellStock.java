package questions.arrays.easyquestions;

public class BestTimeToBuySellStock {
 public int maxProfit(int[] A) {
  int maxProfit = 0;
  if (A.length == 0)
   return 0;

  int max = A[A.length - 1];

  for (int i = A.length - 2; i >= 0; i--) {
   if (max > A[i]) {
    int Profit = max - A[i];
    if (maxProfit < Profit) {
     maxProfit = Profit;
    }
   } else {
    max = A[i];
   }
  }

  return maxProfit;
 }
}
