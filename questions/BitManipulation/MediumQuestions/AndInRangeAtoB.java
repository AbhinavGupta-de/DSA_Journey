package questions.BitManipulation.MediumQuestions;

public class AndInRangeAtoB {

 public int rangeBitwiseAnd(int left, int right) {
  // Get number of set bits in right
  // Get the first set bit only number
  // Check if it's in the range
  // If it is then that number and the left and
  // If it is not then the right and the left and

  // The above one was a shit observation... ya did work but still shit

  // * What should I have thought was that, the common thing from the left side is
  // * the answer
  // * 110
  // * 111
  // * 110
  // * is the answer, so get that just one loop is needed.

  if (left == right)
   return left;

  int count = 0;

  while (left != right) {
   left >>= 1;
   right >>= 1;
   count++;
  }

  return right << count;
 }

}
