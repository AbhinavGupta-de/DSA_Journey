package Questions.BitManipulation.EasyQuestions;

import java.util.HashSet;

public class UniqueElement {
 public static void main(String[] args) {
  int[] arr = { 1, 2, 3, 4, 1, 2, 3 };
  System.out.println(uniqueElement(arr));
 }

 public static int uniqueElement(int[] arr) {
  // using Bit Manipulation
  // int unique = 0;
  // for (int i = 0; i < arr.length; i++) {
  // unique ^= arr[i];
  // }
  // return unique;

  // Using hashing

  HashSet<Integer> set = new HashSet<>();
  HashSet<Integer> unique = new HashSet<>();

  for (int i = 0; i < arr.length; i++) {
   if (set.contains(arr[i])) {
    unique.remove(arr[i]);
   } else {
    set.add(arr[i]);
    unique.add(arr[i]);
   }
  }

  return unique.iterator().next();

 }
}
