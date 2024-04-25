package questions.dp.medium;

public class UniqueBinarySearchTrees {
 public int numTrees(int n) {
  int[] g = new int[n + 1];
  g[0] = 1;
  g[1] = 1;

  for (int i = 4; i <= n; i++) {
   int sum = 0;
   for (int j = 1; j <= i; j++) {
    sum += g[j - 1] * g[i - j];
   }
   g[i] = sum;
  }

  return g[n];
 }
}
