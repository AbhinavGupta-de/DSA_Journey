package Questions.Searching.MediumQuestions;

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

  int iterator = 1 << nums.length;
  for (int i = 0; i < iterator; i++) {
   List<Integer> temp = check(i, nums, target);
   if (temp.size() == 4) {
    ans.add(temp);
   }
  }

  return ans;
 }

 public List<Integer> check(int num, int[] nums, int target) {
  List<Integer> temp = new ArrayList<>();
  int sum = 0;
  int n = nums.length - 1;

  while (num > 0 && n >= 0) {
   if ((num & 1) == 1) {
    temp.add(nums[n]);
    sum += nums[n];
   }
   n--;
   num = num >> 1;
  }

  if (sum == target) {
   return temp;
  }

  return new ArrayList<>();
 }

 public static void main(String[] args) {
  int[] nums = { 2, 2, 2, 2, 2 };
  int target = 8;

  FourSum fs = new FourSum();
  List<List<Integer>> ans = fs.fourSum(nums, target);

  System.out.println(ans.toString());
 }
}