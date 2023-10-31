package Questions.Searching.MediumQuestions;

public class SearchRotatedDuplicateArray {

  public boolean search(int[] nums, int target) {

    // Linear Search if length is less than 3
    if (nums.length < 3) {
      for (int i : nums) {
        if (i == target) {
          return true;
        }
      }
      return false;
    }

    // First we will find pivot
    int pivot = findPivot(nums);
    // If pivot is -1, then array is not rotated

    if (pivot == -1) {
      // Just do normal binary search
      return binarySearch(nums, 0, nums.length - 1, target) != -1;
    }

    // If pivot is found, you have found 2 ascending sorted arrays
    // Now check in which array, target is present
    if (nums[pivot] == target) {
      return true;
    }
    if (nums[0] <= target) {
      return binarySearch(nums, 0, pivot - 1, target) != -1;
    } else {
      return binarySearch(nums, pivot + 1, nums.length - 1, target) != -1;
    }

  }

  public int findPivot(int[] arr) {
    int n = arr.length;
    int l = 0;
    int r = n - 1;

    while (l <= r) {
      int mid = (l + r) / 2;

      if (arr[mid] > arr[(mid + 1) % n] && arr[mid] > arr[(mid - 1 + n) % n]) {
        return mid;
      } else if (arr[mid] > arr[(mid + 1) % n]) {
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }

    return -1;
  }

  public int binarySearch(int[] nums, int start, int end, int target) {
    while (start <= end) {
      int mid = start + (end - start) / 2;

      if (nums[mid] == target) {
        return mid;
      }
      if (nums[mid] > target) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    SearchRotatedDuplicateArray s = new SearchRotatedDuplicateArray();
    int[] arr = { 1, 0, 1, 1, 1 };
    System.out.println(s.search(arr, 0));
  }

}
