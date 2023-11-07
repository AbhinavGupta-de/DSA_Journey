package Questions.Searching.EasyQuestions;

/**
 * ArrangeCoins
 */
public class ArrangeCoins {

 public int arrangeCoins(int n) {

  int rows = (int) (Math.sqrt(2 * (long) n + 0.25) - 0.5);
  return rows;

 }

}