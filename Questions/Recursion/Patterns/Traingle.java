package Questions.Recursion.Patterns;

/*
 * *****
 * ****
 * ***
 * **
 * *
 */
public class Traingle {
 public static void main(String[] args) {
  printTriangle(5, 0);
  System.out.println();
  printTriangle(5, 0);
 }

 public static void printTriangle(int row, int column) {
  if (row == 0) {
   return;
  }
  if (column < row) {
   System.out.print("*");
   printTriangle(row, column + 1);
  } else {
   System.out.println();
   printTriangle(row - 1, 0);
  }
 }

}
