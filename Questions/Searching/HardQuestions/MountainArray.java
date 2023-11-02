package Questions.Searching.HardQuestions;

class MountainArray1 {
 public int get(int index) {
  return 0;
 }

 public int length() {
  return 0;
 }
}

// * Basically in this question, we are applying binary search twice for two
// different order in which the array is given to us.
// * First we find the peak element in the array and then we apply binary search
// in the first half of the array and then in the second half of the array.

public class MountainArray {
 public int findInMountainArray(int target, MountainArray1 mountainArr) {
  int peak = peakEle(mountainArr);
  int firstTry = orderAgnosticBS(mountainArr, target, 0, peak);
  if (firstTry != -1) {
   return firstTry;
  }
  return orderAgnosticBS(mountainArr, target, peak + 1, mountainArr.length() - 1);
 }

 public int peakEle(MountainArray1 nums) {
  int start = 0;
  int end = nums.length() - 1;
  while (start < end) {
   int mid = (start + end) / 2;
   if (nums.get(mid) > nums.get(mid + 1)) {
    end = mid;
   } else {
    start = mid + 1;
   }
  }
  return start;
 }

 public int orderAgnosticBS(MountainArray1 nums, int target, int start, int end) {
  boolean isAsc = nums.get(start) < nums.get(end);
  while (start <= end) {
   int mid = (start + end) / 2;
   if (nums.get(mid) == target) {
    return mid;
   }
   if (isAsc) {
    if (nums.get(mid) < target) {
     start = mid + 1;
    } else {
     end = mid - 1;
    }
   } else {
    if (nums.get(mid) > target) {
     start = mid + 1;
    } else {
     end = mid - 1;
    }
   }
  }
  return -1;
 }
}
