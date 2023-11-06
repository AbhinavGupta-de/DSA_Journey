package Questions.Searching.EasyQuestions;

public class TwoSum {

 public int[] twoSum(int[] numbers, int target) {

  for (int i = 0; i < numbers.length - 1; i++) {
   int index = binarySearch(numbers, i + 1, target - numbers[i]);
   if (index != -1) {
    return new int[] { i + 1, index + 1 };
   }
  }
  return new int[] { -1, -1 };
 }

 public int binarySearch(int[] nums, int start, int target) {
  int end = nums.length - 1;
  while (start <= end) {
   int mid = start + (end - start) / 2;
   if (nums[mid] == target) {
    return mid;
   } else if (nums[mid] < target) {
    start = mid + 1;
   } else {
    end = mid - 1;
   }
  }

  return -1;
 }

}
