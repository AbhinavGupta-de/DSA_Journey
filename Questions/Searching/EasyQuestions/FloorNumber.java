package Questions.Searching.EasyQuestions;

/**
 * FloorNumber
 */
public class FloorNumber {

 public int floorNum(int[] nums, int target) {
  int start = 0;
  int end = nums.length - 1;
  while (start <= end) {
   int mid = (start + end) / 2;
   if (nums[mid] == target) {
    return nums[mid];
   } else if (nums[mid] > target) {
    end = mid - 1;
   } else {
    start = mid + 1;
   }
  }

  return nums[end];
 }

 public static void main(String[] args) {
  FloorNumber obj = new FloorNumber();
  int[] nums = { 1, 2, 3, 4, 8, 10, 10, 12, 19 };
  int target = 6;
  System.out.println(obj.floorNum(nums, target));
 }

}