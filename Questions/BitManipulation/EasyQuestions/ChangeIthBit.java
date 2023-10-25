package Questions.BitManipulation.EasyQuestions;

public class ChangeIthBit {
 public static void main(String[] args) {
  int n = 100100;
  int i = 3;
  System.out.println(changeIthBit(n, i));
 }

 public static int changeIthBit(int n, int i) {
  return (n | (1 << i));
 }
}
