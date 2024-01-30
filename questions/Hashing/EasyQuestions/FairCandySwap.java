package questions.Hashing.EasyQuestions;

import java.util.HashSet;

public class FairCandySwap {
 public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {

  int sumA = 0;
  int sumB = 0;

  HashSet<Integer> set = new HashSet<>();

  for (int i = 0; i < aliceSizes.length; i++) {
   sumA += aliceSizes[i];
   set.add(aliceSizes[i]);
  }

  for (int i = 0; i < bobSizes.length; i++) {
   sumB += bobSizes[i];
  }

  int diff = (sumA - sumB) / 2;

  for (int i = 0; i < bobSizes.length; i++) {
   if (set.contains(bobSizes[i] + diff)) {
    return new int[] { bobSizes[i] + diff, bobSizes[i] };
   }
  }

  return null;
 }
}
