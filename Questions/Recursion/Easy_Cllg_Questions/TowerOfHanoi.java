package Questions.Recursion;

public class TowerOfHanoi {
 public static int towerOfHanoi(int n, char fromRod, char toRod, char auxRod) {
  if (n == 1) {
   System.out.println("Move disk 1 from rod " + fromRod + " to rod " + toRod);
   return 1;
  }
  towerOfHanoi(n - 1, fromRod, auxRod, toRod);
  System.out.println("Move disk " + n + " from rod " + fromRod + " to rod " + toRod);
  towerOfHanoi(n - 1, auxRod, toRod, fromRod);
  return 1;
 }

}
