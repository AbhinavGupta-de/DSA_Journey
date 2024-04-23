package dp.medium;

import java.util.*;

public class WorkBreak {
 public boolean wordBreak(String s, List<String> wordDict) {

  HashSet<String> set = new HashSet<>(wordDict);

  int n = s.length();
  boolean[] ans = new boolean[n + 1];
  ans[n] = true;

  for (int i = n - 1; i >= 0; i--) {
   StringBuilder str = new StringBuilder();
   for (int j = i; j < n; j++) {
    str.append(s.charAt(j));
    if (set.contains(str.toString()))
     ans[i] |= ans[j + 1];
   }
  }

  return ans[0];
  // return helper(s, set, 0, n, ans);
 }

 private boolean helper(String s, HashSet<String> set, int pos, int length, Boolean[] ans) {
  if (pos == length)
   return true;

  if (ans[pos] != null)
   return ans[pos];

  boolean val = false;

  StringBuilder word = new StringBuilder();

  for (int i = pos; i < length; i++) {
   char c = s.charAt(i);
   word.append(c);
   val = set.contains(word.toString()) ? val | helper(s, set, i + 1, length, ans) : val;
  }

  return ans[pos] = val;
 }
}
