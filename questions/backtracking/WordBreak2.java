package backtracking;

import java.util.*;

public class WordBreak2 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> list = new ArrayList<>();
        HashSet<String> set = new HashSet<>(wordDict);
        helper(s, 0, set, list, "");
        return list;
    }

    private void helper(String s, int start, HashSet<String> dict, List<String> ans, String curr) {
        int n = s.length();
        if (start == n) {
            ans.add(curr.trim());
        }

        StringBuilder str = new StringBuilder();

        for (int i = start; i < n; i++) {
            str.append(s.charAt(i));
            if (dict.contains(str.toString()))
                helper(s, i + 1, dict, ans, curr + " " + str.toString());
        }
    }
}
