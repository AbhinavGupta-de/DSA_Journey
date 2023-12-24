package questions.arrays.easyquestions;

import java.util.*;

/**
 * TwoSum
 */
public class TwoSum {

 public static int[] twoSum(int[] nums, int target) {

  // Brute Force - O(n^2)
  // for (int i = 0; i < nums.length; i++) {
  // for (int j = i + 1; j < nums.length; j++) {
  // if (nums[i] + nums[j] == target) {
  // result[0] = i;
  // result[1] = j;
  // return result;
  // }
  // }
  // }

  // Using HashMap - O(n)
  // We will use HashMap to store the values of the array along with their index
  // values
  HashMap<Integer, Integer> map = new HashMap<>();
  for (int i = 0; i < nums.length; i++) {
   int complement = target - nums[i];
   if (map.containsKey(complement)) {
    return new int[] { map.get(complement), i };
   }
   map.put(nums[i], i);
  }

  return null;
 }

 public static void main(String[] args) {
  int[] nums = { 2, 7, 11, 15 };
  int target = 9;
  int[] result = twoSum(nums, target);
  System.out.println(result[0] + " " + result[1]);
 }

}