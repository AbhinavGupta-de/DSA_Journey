package Questions.BitManipulation.EasyQuestions;

public class ReSetIthBit {
 public static void main(String[] args) {
  int n = 100100;
  int i = 3;
  System.out.println(resetIthBit(n, i));
 }

 public static int resetIthBit(int n, int i) {
  return (n & (~(1 << i)));
 }
}
