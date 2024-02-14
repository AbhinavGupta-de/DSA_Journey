package questions.string.easy;

/**
 * ValidPalindrome
 */
public class ValidPalindrome {

 public boolean isPalindrome(String s) {
  StringBuilder stb = new StringBuilder();

  for (char c : s.toCharArray()) {
   if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
    stb.append(c);
   }
  }

  return isPallin(stb.toString().toLowerCase());
 }

 public boolean isPallin(String str) {
  if (str.length() == 0 || str.length() == 1) {
   return true;
  }
  if (str.charAt(0) == str.charAt(str.length() - 1)) {
   return isPallin(str.substring(1, str.length() - 1));
  }
  return false;
 }
}