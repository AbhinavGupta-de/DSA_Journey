package Questions.Arrays.EasyQuestions;

import java.util.*;

public class ArrayFormInteger {
 public static List<Integer> arrayForm(int[] A, int K) {
  int n = A.length;
  List<Integer> result = new ArrayList<>();

  int carry = K;
  for (int i = n - 1; i >= 0 || carry > 0; i--) {
   if (i >= 0)
    carry += A[i];

   result.add(carry % 10);
   carry /= 10;
  }

  Collections.reverse(result);
  return result;
 }

 public static void main(String[] args) {
  int[] nums = { 1, 2, 0, 0 };
  int k = 34;

  List<Integer> num = arrayForm(nums, k);

  for (Integer i : num) {
   System.out.print(i + " ");
  }

 }
}
