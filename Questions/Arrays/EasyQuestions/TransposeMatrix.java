package questions.arrays.easyquestions;

import java.util.*;

/**
 * TransposeMatrix
 */
public class TransposeMatrix {

 public static List<Integer> transpose(int[] A, int K) {

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

 }
}