package Questions.Searching.EasyQuestions;

/**
 * CeilLetter: Find smallest letter greater than target
 */
public class CeilLetter {

 public char nextGreaterLetter(int[] letters, char target) {
  int start = 0;
  int end = letters.length - 1;
  while (start <= end) {
   int mid = (start + end) / 2;
   if (letters[mid] == target) {
    return (char) letters[mid];
   } else if (letters[mid] > target) {
    end = mid - 1;
   } else {
    start = mid + 1;
   }
  }
  return (char) letters[start % letters.length];
 }

}