package questions.BitManipulation.EasyQuestions;

public class GetIthBit {
 public static void main(String[] args) {
  int n = 100100;
  int i = 3;
  System.out.println(getIthBit(n, i));
 }

 public static int getIthBit(int n, int i) {
  return ((n & (1 << i)) != 0 ? 1 : 0);
 }
}
