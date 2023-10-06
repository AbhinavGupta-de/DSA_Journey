package Important_Concepts;

/**
 * BinarySearch
 */
public class BinarySearch {

  static int binarySearch(int[] nums, int target) {

    int order = accendDecend(nums);
    if (order == 1) {

      int start = 0;
      int end = nums.length - 1;
      while (start <= end) {

        // * we did start + (end - start)/ 2 instead of (start + end) / 2
        // * to avoid integer overflow, because start + end can be greater than
        // * Integer.MAX_VALUE that's why we did start + (end - start) / 2
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
          return mid;
        } else if (nums[mid] < target) {
          start = mid + 1;
        } else {
          end = mid - 1;
        }
      }
    } else {
      int start = nums.length - 1;
      int end = 0;

      while (start >= end) {
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
          return mid;
        } else if (nums[mid] < target) {
          start = mid - 1;
        } else {
          end = mid + 1;
        }
      }
    }

    return -1;
  }

  static long binarySearch(long[] nums, long target) {
    int start = 0;
    int end = nums.length - 1;
    while (start <= end) {

      // * we did start + (end - start)/ 2 instead of (start + end) / 2
      // * to avoid integer overflow, because start + end can be greater than
      // * Integer.MAX_VALUE that's why we did start + (end - start) / 2
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

  static double binarySearch(double[] nums, double target) {
    int start = 0;
    int end = nums.length - 1;
    while (start <= end) {

      // * we did start + (end - start)/ 2 instead of (start + end) / 2
      // * to avoid integer overflow, because start + end can be greater than
      // * Integer.MAX_VALUE that's why we did start + (end - start) / 2
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

  static int accendDecend(int[] nums) {
    if (nums[0] > nums[nums.length - 1])
      return -1;
    else
      return 1;
  }

  public static void main(String[] args) {
    long[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 3454324325L };
    long target = 3454324325L;

    System.out.println(binarySearch(nums, target));
  }

}