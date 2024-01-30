package questions.Arrays.EasyQuestions;

/**
 * HighestAltitude
 */
public class HighestAltitude {
 public int largestAltitude(int[] gain) {
  int max = 0;
  // for (int i = 0; i < gain.length; i++) {
  // sum += gain[i];
  // if (sum > max) {
  // max = sum;
  // }
  // }

  // * Other method -> Finding prefix Sum array then just the max in that array
  int[] prefixSum = new int[gain.length + 1];
  prefixSum[0] = 0;
  for (int i = 1; i < prefixSum.length; i++) {
   prefixSum[i] = prefixSum[i - 1] + gain[i - 1];
  }
  for (int i = 0; i < prefixSum.length; i++) {
   if (prefixSum[i] > max) {
    max = prefixSum[i];
   }
  }
  return max;
 }
}