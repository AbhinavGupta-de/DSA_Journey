package questions.BitManipulation.EasyQuestions;

public class ChangeIthBit {
 public static void main(String[] args) {
  int n = 38;
  int i = 2;
  System.out.println(changeIthBit(n, i));
 }

 public static int changeIthBit(int n, int i) {
  return (n ^ (1 << i));
 }
}
