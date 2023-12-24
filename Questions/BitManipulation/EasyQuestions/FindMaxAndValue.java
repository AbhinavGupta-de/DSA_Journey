package questions.bitmanipulation.easyquestions;

// import java.util.Arrays;

public class FindMaxAndValue {

 public int findMaxAndValue(int[] arr) {
  int ans = 0;
  for (int i = 31; i >= 0; i--) {
   int count = 0;
   for (int j : arr) {
    if ((j & (1 << i)) > 0) {
     count++;
    }
   }

   if (count >= 2) {
    ans |= (1 << i);
    for (int j : arr) {
     if ((j & (1 << i)) > 0) {
      j = 0;
     }
    }
   }
  }

  return ans;
 }

 public static void main(String[] args) {
  int[] nums = { 4, 8, 12, 16 };
  FindMaxAndValue obj = new FindMaxAndValue();
  System.out.println(obj.findMaxAndValue(nums));

  nums = new int[] { 27, 18, 20 };
  System.out.println(obj.findMaxAndValue(nums));
 }
}
