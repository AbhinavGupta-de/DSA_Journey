package Questions.Recursion;

public class SumFromN {

 public static int sumFromN(int n) {
  if (n == 1)
   return 1;

  return n + sumFromN(n - 1);
 }

 public static void main(String[] args) {
  System.out.println(sumFromN(5));
 }
}
