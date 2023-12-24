package questions.arrays.easyquestions;

import java.util.ArrayList;

// https://leetcode.com/problems/create-target-array-in-the-given-order/
public class TargetArray {
 public int[] createTargetArray(int[] nums, int[] index) {
  ArrayList<Integer> arr = new ArrayList<Integer>();
  for (int i = 0; i < nums.length; i++) {

   arr.add(index[i], nums[i]);
  }
  for (int i = 0; i < arr.size(); i++) {
   nums[i] = arr.get(i);
  }
  return nums;
 }

 public static void main(String[] args) {
  TargetArray targetArray = new TargetArray();

  int[] nums = { 0, 1, 2, 3, 4 };
  int[] index = { 0, 1, 2, 2, 1 };

  int[] target = targetArray.createTargetArray(nums, index);

  for (int i = 0; i < target.length; i++) {
   System.out.print(target[i]);
  }
 }
}
