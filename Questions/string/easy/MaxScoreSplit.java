package questions.string.easy;

public class MaxScoreSplit {

 public static int maxScore(String s) {
  int[] prefixSum = new int[s.length()];
  int[] suffixSum = new int[s.length()];

  // Initialize prefix sum
  prefixSum[0] = s.charAt(0) == '0' ? 1 : 0;

  // Calculate prefix sum
  for (int i = 1; i < s.length(); i++) {
   prefixSum[i] = prefixSum[i - 1] + (s.charAt(i) == '0' ? 1 : 0);
  }

  // Initialize suffix sum
  suffixSum[s.length() - 1] = 0;

  // Calculate suffix sum
  for (int i = s.length() - 2; i >= 0; i--) {
   suffixSum[i] = suffixSum[i + 1] + Character.getNumericValue(s.charAt(i + 1));
  }

  int maxScore = 0;

  for (int i = 0; i < s.length() - 1; i++) {
   int score = prefixSum[i] + suffixSum[i];
   maxScore = Math.max(maxScore, score);
  }

  return maxScore;
 }

 public static void main(String[] args) {
  String str = "00";
  System.out.println(maxScore(str));
 }
}
