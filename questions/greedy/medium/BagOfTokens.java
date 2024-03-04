package greedy.medium;

import java.util.Arrays;

public class BagOfTokens {
 public static int bagOfTokensScore(int[] tokens, int power) {
  Arrays.sort(tokens);
  int score = 0;
  int maxi = 0;

  int min = 0, max = tokens.length - 1;

  while (min <= max) {

   if (power >= tokens[min]) {
    power -= tokens[min];
    min++;
    score++;
    maxi = Math.max(maxi, score);
   } else if (score > 0) {

    power += tokens[max];
    max--;
    score--;
   } else {
    break;
   }

  }

  return maxi;
 }
}

// My tried code....

/*
 * 
 * class Solution {
 * public static int bagOfTokensScore(int[] tokens, int power) {
 * 
 * if (power == 0)
 * return 0;
 * 
 * if (tokens.length == 0)
 * return 0;
 * 
 * int min = 0;
 * int max = tokens.length - 1;
 * 
 * Arrays.sort(tokens);
 * 
 * int score = 0;
 * 
 * while (min < tokens.length && power >= tokens[min]) {
 * power -= tokens[min];
 * score++;
 * min++;
 * }
 * 
 * int newScore = check(tokens, power, min, max);
 * 
 * if (newScore > 0) {
 * score += newScore;
 * return score;
 * }
 * 
 * return score;
 * 
 * }
 * 
 * public static int check(int[] tokens, int power, int min, int max) {
 * 
 * if (min >= max) {
 * return 0;
 * }
 * 
 * int score = 0;
 * 
 * power += tokens[max--];
 * score--;
 * 
 * if(score < 0) return 1;
 * 
 * while (min < tokens.length && power >= tokens[min]) {
 * power -= tokens[min++];
 * score++;
 * }
 * 
 * 
 * int newScore = check(tokens, power, min, max);
 * 
 * if(newScore < 0) return newScore;
 * 
 * if (newScore >= 0) {
 * score += newScore;
 * return score;
 * }
 * 
 * return score;
 * 
 * }
 * 
 * }
 * 
 */
