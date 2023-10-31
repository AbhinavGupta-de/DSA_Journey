package Questions.Searching.MediumQuestions;

/**
 * SearchRotatedArray
 */
public class SearchRotatedArray {

  public int searchInRotatedArray(int nums[], int target) {

    int peak = peak(nums);
    int firstTry = binarySearch(nums, target, 0, peak);
    System.out.println(peak);
    if (firstTry != -1)
      return firstTry;
    return binarySearch(nums, target, peak + 1, nums.length - 1);

  }

  public int peak(int[] nums) {
    int start = 0;
    int end = nums.length - 1;
    while (start < end) {
      int mid = (start + end) / 2;
      if (nums[mid] > nums[mid + 1])
        end = mid;
      else
        start = mid + 1;
    }
    return start;
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