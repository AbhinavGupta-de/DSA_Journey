package Questions.Searching.MediumQuestions;

/**
 * SearchRotatedArray
 */
public class SearchRotatedArray {

  public int searchInRotatedArray(int nums[], int target) {

    int pivot = findPivot(nums);

    if (pivot == -1) {
      return binarySearch(nums, target, 0, nums.length - 1);
    }

    if (nums[pivot] == target) {
      return pivot;
    }

    if (target > nums[pivot])
      return -1;

    if (nums[0] <= target) {
      return binarySearch(nums, target, 0, pivot - 1);
    }

    return binarySearch(nums, target, pivot + 1, nums.length - 1);
  }

  public int findPivot(int nums[]) {
    int start = 0;
    int end = nums.length - 1;

    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (nums[mid] >= nums[0]) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }

    return end;
  }

  public int binarySearch(int nums[], int target, int start, int end) {
    while (start <= end) {
      int mid = (start + end) / 2;
      if (nums[mid] == target)
        return mid;
      else if (nums[mid] > target)
        end = mid - 1;
      else
        start = mid + 1;
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] nums = { 3, 4, 5, 6, 1, 2 };
    int target = 2;
    SearchRotatedArray sra = new SearchRotatedArray();
    System.out.println(sra.searchInRotatedArray(nums, target));
  }

}