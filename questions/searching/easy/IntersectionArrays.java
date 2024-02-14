package questions.searching.easy;

// import java.util.ArrayList;
import java.util.HashSet;

public class IntersectionArrays {
 public int[] intersection(int[] nums1, int[] nums2) {
  // 1. Brute Force Approach - O(n^2)
  // ArrayList<Integer> list = new ArrayList<>();
  // int i = 0, j = 0;
  // while (i < nums1.length && j < nums2.length) {
  // if (nums1[i] == nums2[j]) {
  // if (!list.contains(nums1[i])) {
  // list.add(nums1[i]);
  // }
  // i++;
  // j++;
  // } else if (nums1[i] < nums2[j]) {
  // i++;
  // } else {
  // j++;
  // }
  // }

  // int[] result = new int[list.size()];
  // for (int k = 0; k < list.size(); k++) {
  // result[k] = list.get(k);
  // }
  // return result;

  // 2. Using Binary Search - O(nlogn)
  // ArrayList<Integer> list = new ArrayList<>();

  // for (int i = 0; i < nums1.length; i++) {
  // if (i > 0 && nums1[i] == nums1[i - 1]) {
  // continue;
  // }
  // if (binarySearch(nums2, nums1[i])) {
  // list.add(nums1[i]);
  // }
  // }

  // int[] result = new int[list.size()];
  // for (int k = 0; k < list.size(); k++) {
  // result[k] = list.get(k);
  // }

  // return result;

  // 3. Using Hashing - O(n)
  HashSet<Integer> set1 = new HashSet<>();
  HashSet<Integer> set2 = new HashSet<>();

  for (int i : nums1) {
   set1.add(i);
  }

  for (int i : nums2) {
   if (set1.contains(i)) {
    set2.add(i);
   }
  }

  int[] result = new int[set2.size()];
  int i = 0;

  for (int j : set2) {
   result[i] = j;
   i++;
  }

  return result;

 }

 // public boolean binarySearch(int[] nums, int target) {
 // int start = 0, end = nums.length - 1;
 // while (start <= end) {
 // int mid = start + (end - start) / 2;
 // if (nums[mid] == target)
 // return true;
 // else if (nums[mid] < target)
 // start = mid + 1;
 // else
 // end = mid - 1;
 // }

 // return false;
 // }
}
