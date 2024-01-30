package questions.searching.easy;

/**
 * GuessNumber
 */
public class GuessNumber {

 public int guessNumber(int n) {
  int start = 0, end = n;

  while (start <= end) {
   int mid = start + (end - start) / 2;
   int guess = guess(mid);
   if (guess == 0) {
    return mid;
   } else if (guess == -1) {
    end = mid - 1;
   } else {
    start = mid + 1;
   }
  }

  return -1;

 }

 private int guess(int mid) {
  return 0;
 }

}