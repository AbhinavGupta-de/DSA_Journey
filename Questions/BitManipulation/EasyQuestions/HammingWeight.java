package Questions.BitManipulation.EasyQuestions;

public class HammingWeight {
 // Calculate number of 1 bits
 public int hammingWeight(int n) {
  int count = 0;
  while (n != 0) {
   count++;
   n = n & (n - 1);
  }

  return count;
 }
}
