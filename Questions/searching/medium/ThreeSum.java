package questions.searching.medium;

import java.util.*;

public class ThreeSum {

 public List<List<Integer>> threeSum(int[] nums) {
  Arrays.sort(nums);
  List<List<Integer>> result = new ArrayList<>();

  // [-1, 0, 1, 2, -1, -4]
  // [-4, -1, -1, 0, 1, 2]
  // Iterate through the array and for each element, find the other two elements
  // that sum up to 0

  for (int i = 0; i < nums.length - 2; i++) {

   // If the current element is greater than 0, then there is no way to get a sum
   if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {

    int low = i + 1;
    int high = nums.length - 1;
    int sum = 0 - nums[i];

    while (low < high) {
     if (nums[low] + nums[high] == sum) {
      result.add(Arrays.asList(nums[i], nums[low], nums[high]));
      while (low < high && nums[low] == nums[low + 1])
       low++;
      while (low < high && nums[high] == nums[high - 1])
       high--;
      low++;
      high--;
     } else if (nums[low] + nums[high] < sum) {
      low++;
     } else {
      high--;
     }
    }
   }
  }

  return result;

 }

 public int threeSum(int[] nums, int target) {
  Arrays.sort(nums);

  int minDiff = Integer.MAX_VALUE;
  int result = 0;

  for (int i = 0; i < nums.length - 2; i++) {
   int low = i + 1;
   int high = nums.length - 1;

   while (low < high) {
    int sum = nums[i] + nums[low] + nums[high];
    int diff = Math.abs(sum - target);

    if (diff < minDiff) {
     minDiff = diff;
     result = sum;
    }

    if (sum < target) {
     low++;
    } else {
     high--;
    }
   }
  }

  return result;
 }

 public static void main(String[] args) {
  int[] nums = { 2, 2, 2, 3 };

  ThreeSum threeSum = new ThreeSum();

  System.out.println(threeSum.threeSum(nums, 8));
 }

}
