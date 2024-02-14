package questions.searching.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * FourSum
 */
public class FourSum {

 public List<List<Integer>> fourSum(int[] nums, int target) {
  ArrayList<List<Integer>> ans = new ArrayList<>();

  Arrays.sort(nums); // Sort the array to handle duplicates

  for (int i = 0; i < nums.length; i++) {
   if (i > 0 && nums[i] == nums[i - 1])
    continue; // Skip duplicates

   int threeSumTarget = target - nums[i];
   int[] threeSumArray = Arrays.copyOfRange(nums, i + 1, nums.length);
   List<List<Integer>> threeSumAns = threeSum(threeSumArray, threeSumTarget);

   for (List<Integer> threeSumList : threeSumAns) {
    threeSumList.add(nums[i]);
    ans.add(threeSumList);
   }
  }

  return ans;

 }

 public List<List<Integer>> threeSum(int[] nums, int target) {
  ArrayList<List<Integer>> ans = new ArrayList<>();

  Arrays.sort(nums); // Sort the array to handle duplicates

  for (int i = 0; i < nums.length; i++) {
   if (i > 0 && nums[i] == nums[i - 1])
    continue; // Skip duplicates

   int twoSumTarget = target - nums[i];
   int[] twoSumArray = Arrays.copyOfRange(nums, i + 1, nums.length);
   List<List<Integer>> twoSumAns = twoSum(twoSumArray, twoSumTarget);

   for (List<Integer> twoSumList : twoSumAns) {
    twoSumList.add(nums[i]);
    ans.add(twoSumList);
   }
  }

  return ans;
 }

 public List<List<Integer>> twoSum(int[] nums, int target) {
  ArrayList<List<Integer>> ans = new ArrayList<>();

  int low = 0;
  int high = nums.length - 1;

  while (low < high) {
   int sum = nums[low] + nums[high];

   if (sum == target) {
    ArrayList<Integer> temp = new ArrayList<>();
    temp.add(nums[low]);
    temp.add(nums[high]);
    ans.add(temp);

    while (low < high && nums[low] == nums[low + 1])
     low++;
    while (low < high && nums[high] == nums[high - 1])
     high--;

    low++;
    high--;
   } else if (sum < target) {
    low++;
   } else {
    high--;
   }
  }

  return ans;
 }

 public static void main(String[] args) {
  int[] nums = { 2, 2, 2, 2, 2 };
  int target = 8;

  FourSum fs = new FourSum();
  List<List<Integer>> ans = fs.fourSum(nums, target);

  System.out.println(ans.toString());
 }
}