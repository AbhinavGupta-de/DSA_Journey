package dp.hard;

public class LongestCommonSupersequence {
 public String shortestCommonSupersequence(String str1, String str2) {
  String[][] dp = new String[str1.length()][str2.length()];
  return helper(str1, str2, 0, 0, dp);
 }

 private String helper(String str1, String str2, int i, int j, String[][] dp) {
  int n = str1.length();
  int m = str2.length();
  if (i >= n && j >= m)
   return "";
  if (i >= n && j < m)
   return str2.substring(j);
  if (i < n && j >= m)
   return str1.substring(i);

  if (dp[i][j] != null)
   return dp[i][j];
  StringBuilder temp = new StringBuilder();

  char c = str1.charAt(i);
  char w = str2.charAt(j);
  if (c == w) {
   return dp[i][j] = temp.append(c + helper(str1, str2, i + 1, j + 1, dp)).toString();
  }
  String text1 = helper(str1, str2, i + 1, j, dp);
  String text2 = helper(str1, str2, i, j + 1, dp);

  if (text1.length() < text2.length()) {
   temp.append(c);
   temp.append(text1);
  } else {
   temp.append(w);
   temp.append(text2);
  }

  return dp[i][j] = temp.toString();

 }
}
