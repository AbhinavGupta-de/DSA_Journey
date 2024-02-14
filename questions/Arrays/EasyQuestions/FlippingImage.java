package questions.Arrays.EasyQuestions;

public class FlippingImage {
 public int[][] flipAndInvertImage(int[][] image) {
  int[][] flippedImage = new int[image.length][image[0].length];
  for (int i = 0; i < image.length; i++) {
   for (int j = 0; j < image[i].length; j++) {
    flippedImage[i][j] = image[i][image[i].length - 1 - j];
    if (flippedImage[i][j] == 0) {
     flippedImage[i][j] = 1;
    } else {
     flippedImage[i][j] = 0;
    }
   }
  }
  return flippedImage;
 }
}
