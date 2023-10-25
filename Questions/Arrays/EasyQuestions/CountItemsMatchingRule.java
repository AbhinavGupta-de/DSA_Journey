package Questions.Arrays.EasyQuestions;

import java.util.*;

public class CountItemsMatchingRule {
 public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
  int count = 0;
  int index = 0;
  if (ruleKey.equals("type")) {
   index = 0;
  } else if (ruleKey.equals("color")) {
   index = 1;
  } else {
   index = 2;
  }
  for (int i = 0; i < items.size(); i++) {
   if (items.get(i).get(index).equals(ruleValue)) {
    count++;
   }
  }
  return count;
 }
}
