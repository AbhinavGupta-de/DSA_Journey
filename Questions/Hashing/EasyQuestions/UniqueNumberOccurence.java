package questions.hashing.easyquestions;

import java.util.HashMap;
import java.util.HashSet;

public class UniqueNumberOccurence {
 public boolean uniqueOccurrences(int[] nums) {

  HashMap<Integer, Integer> frequency = new HashMap<>();
  HashSet<Integer> set = new HashSet<>();

  for (int i : nums) {
   if (frequency.containsKey(i)) {
    frequency.put(i, frequency.get(i) + 1);
   } else {
    frequency.put(i, 0);
   }
  }

  for (Integer i : frequency.values()) {
   if (set.contains(i)) {
    return false;
   } else {
    set.add(i);
   }
  }

  return true;

 }
}
