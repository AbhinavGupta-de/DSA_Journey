package questions.BitManipulation.EasyQuestions;

public class HamingDistance {
 public int hammingDistance(int x, int y) {
  int count = 0;
  while (x > 0 || y > 0) {

   if (((x & 1) ^ (y & 1)) == 1)
    count++;

   x >>= 1;
   y >>= 1;
  }

  return count;
 }
}
