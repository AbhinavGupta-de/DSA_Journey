package questions.recursion.easy;

public class Pallindrome {

 public static boolean isPallindrome(Object obj) {
  String str = obj.toString();
  if (str.length() == 0 || str.length() == 1)
   return true;
  if (str.charAt(0) == str.charAt(str.length() - 1))
   return isPallindrome(str.substring(1, str.length() - 1));
  return false;
 }

 public static void main(String[] args) {
  System.out.println(isPallindrome(3443));
 }
}
