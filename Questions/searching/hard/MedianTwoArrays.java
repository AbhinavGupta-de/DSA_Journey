package questions.searching.hard;

/**
 * MedianTwonums2ays
 */
public class MedianTwoArrays {

 public double findMedianSortednums2ays(int[] nums1, int[] nums2) {
  int n = nums1.length;
  int m = nums2.length;
  if (n > m) {
   return findMedianSortednums2ays(nums2, nums1);
  }
  int start = 0;
  int end = n;
  while (start <= end) {
   int cut1 = (start + end) / 2;
   int cut2 = (n + m + 1) / 2 - cut1;

   int left1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
   int left2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];

   int right1 = cut1 == n ? Integer.MAX_VALUE : nums1[cut1];
   int right2 = cut2 == m ? Integer.MAX_VALUE : nums2[cut2];

   if (left1 <= right2 && left2 <= right1) {
    if ((n + m) % 2 == 0) {
     return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
    } else {
     return Math.max(left1, left2);
    }
   } else if (left1 > right2) {
    end = cut1 - 1;
   } else {
    start = cut1 + 1;
   }
  }
  return 0.0;

  // int n = nums1.length;
  // int m = nums2.length;

  // if (n > m) {
  // return findMedianSortednums2ays(nums2, nums1);
  // }

  // int start = 0;
  // int end = n - 1;
  // int median = (n + m) / 2;
  // boolean isEven = (n + m) % 2 == 0 ? true : false;
  // System.out.println(median);

  // while (start <= end) {
  // int mid = (start + end) / 2;
  // int floor = binarySearch(nums2, nums1[mid]);

  // if (floor == -1) {
  // if (mid == median && isEven) {
  // int min = Math.min(nums1[mid + 1], nums2[0]);
  // return (nums1[mid] + min) / 2.0;
  // } else if (mid == median && !isEven) {
  // return nums1[mid];
  // } else if (mid < median) {
  // start = mid + 1;
  // } else {
  // end = mid - 1;
  // }
  // } else {
  // if (mid + floor == median && isEven) {
  // int min = Math.min(nums1[mid + 1], nums2[floor]);
  // return (nums1[mid] + min) / 2.0;
  // } else if (mid + floor == median && !isEven) {
  // return nums1[mid];
  // } else if (mid + floor < median) {
  // start = mid + 1;
  // } else {
  // end = mid - 1;
  // }
  // }
  // }
  // return 0.0;
  // }

  // public int binarySearch(int[] nums, int target) {
  // int start = 0;
  // int end = nums.length - 1;
  // int floor = -1;
  // while (start <= end) {
  // int mid = (start + end) / 2;
  // if (nums[mid] == target) {
  // return mid;
  // } else if (nums[mid] < target) {
  // floor = mid;
  // start = mid + 1;
  // } else {
  // end = mid - 1;
  // }
  // }
  // return floor;
 }

 public static void main(String[] args) {
  int[] nums1 = { 1, 2, 3, 6, 7, 8 };
  int[] nums2 = { 4 };

  MedianTwoArrays m = new MedianTwoArrays();
  System.out.println(m.findMedianSortednums2ays(nums1, nums2));
 }

}