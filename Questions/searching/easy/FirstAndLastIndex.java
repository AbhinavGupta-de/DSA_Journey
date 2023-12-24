package questions.searching.easy;

public class FirstAndLastIndex {
 public int[] firstAndLastIndex(int[] nums, int key) {
  // O(n) solution
  int[] res = new int[2];
  int min = Integer.MAX_VALUE;
  int max = Integer.MIN_VALUE;
  for (int i = 0; i < nums.length; i++) {
   if (nums[i] == key) {
    if (i < min) {
     min = i;
     res[0] = i;
    }
   }
   if (nums[nums.length - 1 - i] == key) {
    if (max < nums.length - 1 - i) {
     max = nums.length - 1 - i;
     res[1] = nums.length - 1 - i;
    }
   }
  }

  if (min == Integer.MAX_VALUE) {
   res[0] = -1;
  }
  if (max == Integer.MIN_VALUE) {
   res[1] = -1;
  }
  return res;
 }

 public int[] firstLastIndex(int[] nums, int key) {
  // O(logn) solution
  int[] res = new int[2];

  res[0] = findFirstIndex(nums, key);
  res[1] = findLastIndex(nums, key);

  return res;
 }

 public int findFirstIndex(int[] nums, int key) {
  int start = 0;
  int end = nums.length - 1;
  int res = -1;
  while (start <= end) {
   int mid = (start + end) / 2;
   if (nums[mid] == key) {
    res = mid;
    end = mid - 1;
   } else if (nums[mid] > key) {
    end = mid - 1;
   } else {
    start = mid + 1;
   }
  }
  return res;
 }

 public int findLastIndex(int[] nums, int key) {
  int start = 0;
  int end = nums.length - 1;
  int res = -1;
  while (start <= end) {
   int mid = (start + end) / 2;
   if (nums[mid] == key) {
    res = mid;
    start = mid + 1;
   } else if (nums[mid] > key) {
    end = mid - 1;
   } else {
    start = mid + 1;
   }
  }
  return res;
 }

 public static void main(String[] args) {
  int[] nums = { 1, 2, 3, 4, 8, 10, 10, 12, 19 };
  int key = 10;
  FirstAndLastIndex obj = new FirstAndLastIndex();
  int[] res = obj.firstAndLastIndex(nums, key);
  System.out.println(res[0] + " " + res[1]);
 }
}
