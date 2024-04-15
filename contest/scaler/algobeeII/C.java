package contest.scaler.algobeeII;

import java.util.Scanner;

public class C {

 static int[][][] dp;

 public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  int r = sc.nextInt();
  int w = sc.nextInt();
  int b = 6; // Assuming b starts from 6
  dp = new int[r + 1][11][b + 1]; // Adjusted dimensions
  for (int i = 0; i <= r; i++) {
   for (int j = 0; j <= 10; j++) {
    for (int k = 0; k <= b; k++) {
     dp[i][j][k] = -1;
    }
   }
  }
  System.out.println(Helper(r, w, b));
 }

 public static int Helper(int r, int w, int b) {
  // Base cases
  if (r <= 0 && w < 10 && b > 0) {
   return 1;
  }
  if (b == 0) {
   if (r <= 0) {
    return 1;
   } else
    return 0;
  }
  if (w == 10) {
   return 0;
  }

  // If result is already computed, return it
  if (dp[r][w][b] != -1) {
   return dp[r][w][b];
  }

  // Calculate result recursively
  int op1 = Helper(r, w, b - 1);
  int op2 = Helper(r - 1, w, b - 1);
  int op3 = Helper(r - 2, w, b - 1);
  int op4 = Helper(r - 3, w, b - 1);
  int op5 = Helper(r - 4, w, b - 1);
  int op6 = Helper(r - 6, w, b - 1);
  int op7 = Helper(r, w + 1, b - 1);

  // Store result in DP table
  dp[r][w][b] = op1 + op2 + op3 + op4 + op5 + op6 + op7;

  return dp[r][w][b];
 }
}