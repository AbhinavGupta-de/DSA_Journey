package Algorithms;

/**
 * BinarySearch
 */
public class BinarySearch {

 public static void main(String[] args) {
  int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
  int key = 8;
  int index = binarySearch(arr, key);
  System.out.println(index);
 }

 public static int binarySearch(int[] arr, int key) {
  int start = 0;
  int end = arr.length - 1;
  while (start <= end) {
   int mid = (start + end) / 2;
   if (arr[mid] == key) {
    return mid;
   }
   if (arr[mid] < key) {
    start = mid + 1;
   }
   if (arr[mid] > key) {
    end = mid - 1;
   }
  }

  return -1;
 }
}