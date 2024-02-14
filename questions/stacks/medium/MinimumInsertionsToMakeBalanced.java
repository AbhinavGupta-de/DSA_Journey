package questions.stacks.medium;

public class MinimumInsertionsToMakeBalanced {
 public int minInsertions(String s) {

  int opening = 0;
  int closing = 0;

  int i = 0;
  while (i < s.length()) {

   char curr = s.charAt(i);

   if (curr == '(') {
    opening++;
   } else {
    if (i + 1 < s.length() && s.charAt(i + 1) == ')') {

     if (opening > 0)
      opening--;
     else
      closing++;

     i++;

    } else {
     if (opening > 0) {
      opening--;
      closing++;
     } else {
      closing += 2;
     }

    }

   }

   i++;
  }
  return opening * 2 + closing;
 }
}
