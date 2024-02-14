package questions.tree.medium;

public class RearrangeArrayElementsBySign {

 public int[] rearrangeArray(int[] nums) {

  // int i = 0;
  // int j = i + 1;
  // while (i < nums.length) {

  // if (i % 2 == 0) {
  // if (nums[i] < 0) {

  // while (j < nums.length) {
  // if (nums[j] >= 0) {
  // int temp = nums[j];
  // nums[j] = nums[i];
  // nums[i] = temp;
  // break;
  // }
  // j++;
  // }
  // }
  // } else {
  // if (nums[i] > 0) {
  // while (j < nums.length) {
  // if (nums[j] < 0) {
  // int temp = nums[j];
  // nums[j] = nums[i];
  // nums[i] = temp;
  // break;
  // }
  // j++;
  // }
  // }
  // }
  // i++;
  // }

  int positive = 0;
  int negative = 0;

  int[] ans = new int[nums.length];

  for (int i = 0; i < nums.length; i++) {

   if (i % 2 == 0) {

    while (positive < nums.length) {
     if (nums[positive] > 0) {
      ans[i] = nums[positive];
      positive++;
      break;
     }
     positive++;
    }

   } else {

    while (negative < nums.length) {
     if (nums[negative] < 0) {
      ans[i] = nums[negative];
      negative++;
      break;
     }
     negative++;
    }

   }

  }

  return ans;

 }

}
