package questions.Arrays.MediumQuestions;

public class SetColors {

 // Frequency Array
 public void setColors(int[] nums) {
  int[] freq = new int[3];
  for (int i = 0; i < nums.length; i++) {
   freq[nums[i]]++;
  }
  int index = 0;
  for (int i = 0; i < freq.length; i++) {
   while (freq[i] > 0) {
    nums[index++] = i;
    freq[i]--;
   }
  }
 }
}
