package contest.scaler.algobeeII;

import java.util.*;

public class B {
 public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  int t = sc.nextInt();

  for (int i = 0; i < t; i++) {
   int n = sc.nextInt();
   int k = sc.nextInt();

   int[] arr = new int[n];

   for (int j = 0; j < n; j++) {
    arr[j] = sc.nextInt();
   }
   if (k >= n) {
    System.out.println(Integer.MAX_VALUE - 1);
    continue;
   }
   Arrays.sort(arr);

   if (arr[k] < 0) {
    for (int j = k; j < n; j++) {
     if (arr[j] > 0) {
      System.out.println(arr[j] - 1);
      break;
     }
    }
   } else {
    System.out.println(arr[k] - 1);
   }

  }

 }
}
