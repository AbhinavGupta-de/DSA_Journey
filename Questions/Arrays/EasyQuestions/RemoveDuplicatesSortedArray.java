package questions.arrays.easyquestions;

import java.util.HashSet;

/**
 * RemoveDuplicatesSortedArray
 */
public class RemoveDuplicatesSortedArray {

 public int removeDuplicates(int[] nums) {
  int count = 0;
  HashSet<Integer> set = new HashSet<>();

  for (int i : nums) {
   if (!set.contains(i)) {
    set.add(i);
    nums[count++] = i;
   }
  }

  return count;
 }
}