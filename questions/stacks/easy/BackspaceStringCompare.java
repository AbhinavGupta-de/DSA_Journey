package questions.stacks.easy;

public class BackspaceStringCompare {

 public boolean backspaceCompare(String s, String t) {

  StringBuilder sFinal = new StringBuilder();
  StringBuilder tFinal = new StringBuilder();

  int backSpace = 0;
  for (int i = s.length() - 1; i >= 0; i--) {
   char characterAtLast = s.charAt(i);
   if (characterAtLast == '#')
    backSpace++;

   else {
    if (backSpace > 0)
     backSpace--;
    else {
     sFinal.append(characterAtLast);
    }
   }
  }
  backSpace = 0;
  for (int i = t.length() - 1; i >= 0; i--) {
   char characterAtLast = t.charAt(i);
   if (characterAtLast == '#')
    backSpace++;

   else {
    if (backSpace > 0)
     backSpace--;
    else {
     tFinal.append(characterAtLast);
    }
   }

  }

  if (sFinal.toString().equals(tFinal.toString()))
   return true;

  return false;
 }

}
