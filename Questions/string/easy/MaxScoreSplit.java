package questions.string.easy;

import java.util.Arrays;

public class MaxScoreSplit {
 public static int maxScore(String s) {
  int[] preffixSum = new int[s.length()];
  int[] suffixSum = new int[s.length()];

  if (Integer.parseInt(s.charAt(0) + "") == 1) {
   preffixSum[0] = 0;
  } else {
   preffixSum[0] = 1;
  }

  suffixSum[s.length() - 1] = 0;

  for (int i = 1; i < s.length(); i++) {
   preffixSum[i] = preffixSum[i - 1];
   int digit = Integer.parseInt(s.charAt(i) + "");
   if (digit == 0) {
    preffixSum[i] += digit + 1;
   }
  }

  for (int i = s.length() - 2; i >= 0; i--) {
   suffixSum[i] = suffixSum[i + 1] + Integer.parseInt(s.charAt(i + 1) + "");
  }

  System.out.println(Arrays.toString(preffixSum));
  System.out.println(Arrays.toString(suffixSum));

  int maxScore = 0;

  for (int i = 0; i < s.length() - 1; i++) {
   int score = preffixSum[i] + suffixSum[i];
   if (score > maxScore)
    maxScore = score;
  }

  return maxScore;
 }

 public static void main(String[] args) {
  String str = "00";
  System.out.println(maxScore(str));
 }
}
