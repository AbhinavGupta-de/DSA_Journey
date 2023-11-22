package Questions.BitManipulation.EasyQuestions;

// import java.util.HashSet;

public class UniqueElement {
 public static void main(String[] args) {
  int[] arr = { 1, 1, 1, 2, 2, 3, 4, 4, 4, 5 };
  uniqueElement3(arr);
 }

 // If there is only one unique element in the array
 public static int uniqueElement(int[] arr) {
  // using Bit Manipulation
  int unique = 0;
  for (int i = 0; i < arr.length; i++) {
   unique ^= arr[i];
  }
  return unique;
 }

 // If there are multiple unique elements in the array
 public static void uniqueElement2(int[] arr) {
  // using Bit Manipulation
  int xor = 0;
  for (int i = 0; i < arr.length; i++) {
   xor ^= arr[i];
  }
  int mask = xor & -xor;
  int x = 0;
  int y = 0;

  for (int i = 0; i < arr.length; i++) {
   if ((arr[i] & mask) == mask) {
    x ^= arr[i];
   } else {
    y ^= arr[i];
   }
  }
  System.out.println(x + " " + y);
 }

 // If all the elements appea thrice except one element
 public static void uniqueElement3(int[] arr) {
  // using Bit Manipulation
  int ans = 0;
  for (int i = 0; i < 32; i++) {
   int count = 0;
   int mask = (1 << i);
   for (int j = 0; j < arr.length; j++) {
    if ((arr[j] & mask) != 0) {
     count++;
    }
   }
   if (count % 3 != 0) {
    ans |= mask;
   }
  }

  System.out.println(ans);
 }
}
