package backtracking;

import java.util.*;

public class WordBreak2 {
 public List<String> wordBreak(String s, List<String> wordDict) {

 }

 private void helper(String s, List<String> wordDict, int start, StringBuilder test, StringBuilder result) {
     if(start == s.length()){
         wordDict.add(result.toString());
         return;
     }


     for(int i = start; i < s.length(); i++) {
         test.append(s.charAt(i));
         int start = 0;
         if(isValid(test, wordDict)){
             start = result.length() - 1;
             result.append(" " + test);
             helper(s, wordDict, start + 1, test, result);
         } else {
             continue;
         }

         result.r

     }
 }
}
