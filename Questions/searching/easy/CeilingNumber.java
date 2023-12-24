package questions.searching.easy;

public class CeilingNumber {
 public int ceilNum(int[] nums, int k) {
  int start = 0;
  int end = nums.length - 1;
  while (start <= end) {
   int mid = (start + end) / 2;
   if (nums[mid] == k) {
    return nums[mid];
   } else if (nums[mid] > k) {
    end = mid - 1;
   } else {
    start = mid + 1;
   }
  }
  return nums[start];
 }

 public static void main(String[] args) {
  CeilingNumber obj = new CeilingNumber();
  int[] nums = { 1, 2, 3, 4, 8, 10, 10, 12, 19 };
  int k = 20;
  System.out.println(obj.ceilNum(nums, k));
 }
}
