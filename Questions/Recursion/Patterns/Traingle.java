package questions.recursion.patterns;

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
  printTriangle(5);
  System.out.println();
  printTriangle2(5, 0);
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

 public static void printTriangle(int row) {
  if (row == 0) {
   return;
  }
  for (int i = 0; i < row; i++) {
   System.out.print("*");
  }
  System.out.println();
  printTriangle(row - 1);
 }

 public static void printTriangle2(int row, int column) {
  if (row == 0) {
   return;
  }
  if (column < row) {
   printTriangle2(row, column + 1);
   System.out.print("*");
  } else {
   printTriangle2(row - 1, 0);
   System.out.println();
  }
 }

}
