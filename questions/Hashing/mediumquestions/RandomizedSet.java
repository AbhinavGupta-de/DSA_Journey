package questions.Hashing.mediumquestions;

import java.util.*;

public class RandomizedSet {

 HashMap<Integer, Integer> map = new HashMap<>();
 ArrayList<Integer> list = new ArrayList<>();
 int size;

 public RandomizedSet() {
  size = 0;
 }

 public boolean insert(int val) {
  if (map.containsKey(val))
   return false;

  map.put(val, size);
  list.add(val);
  size++;
  return true;
 }

 public boolean remove(int val) {
  if (map.containsKey(val)) {
   int index = map.get(val);
   int lastValue = list.get(size - 1);

   map.put(lastValue, index);
   map.remove(val);

   list.set(index, lastValue);
   list.remove(size - 1);

   size--;

   return true;
  }

  return false;
 }

 public int getRandom() {

  Random rand = new Random();
  int randVal = rand.nextInt(size);

  return list.get(randVal);

 }
}