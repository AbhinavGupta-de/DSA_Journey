package questions.dp.hard;

import java.util.*;

/**
 * FreedomTrail
 */
public class FreedomTrail {

 public int findRotateSteps(String ring, String key) {

  HashMap<Character, List<Integer>> map = new HashMap<>();

  for (int i = 0; i < ring.length(); i++) {
   if (map.containsKey(ring.charAt(i))) {
    map.get(ring.charAt(i)).add(i);
   } else {
    map.put(ring.charAt(i), new ArrayList<>(i));
   }
  }

 }
}