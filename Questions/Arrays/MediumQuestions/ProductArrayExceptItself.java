package Questions.Arrays.MediumQuestions;

public class ProductArrayExceptItself {
 public int[] productExceptSelf(int[] nums) {

  int[] preffixProduct = new int[nums.length];
  int[] suffixProduct = new int[nums.length];

  preffixProduct[0] = nums[0];
  suffixProduct[nums.length - 1] = nums[nums.length - 1];

  for (int i = 1; i < nums.length; i++) {
   preffixProduct[i] = preffixProduct[i - 1] * nums[i];
  }

  for (int i = nums.length - 2; i >= 0; i--) {
   suffixProduct[i] = suffixProduct[i + 1] * nums[i];
  }

  int[] result = new int[nums.length];

  result[0] = suffixProduct[1];

  for (int i = 1; i < nums.length - 1; i++) {
   result[i] = preffixProduct[i - 1] * suffixProduct[i + 1];
  }

  result[nums.length - 1] = preffixProduct[nums.length - 2];

  return result;

 }
}
