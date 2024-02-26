package questions.tree.medium;

import java.util.HashSet;

public class ValidateBinaryTreeNodes {

 public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {

  HashSet<Integer> set = new HashSet<>();
  int prev = leftChild[0] == -1 ? Integer.MAX_VALUE : leftChild[0];

  for (int i = 0; i < leftChild.length; i++) {

   if (leftChild[i] != -1) {
    if (leftChild[i] < prev)
     return false;
    set.add(leftChild[i]);
    prev = rightChild[i];
   }
  }

  prev = rightChild[0] == 0 ? Integer.MAX_VALUE : rightChild[0];
  for (int i = 0; i < rightChild.length; i++) {
   if (set.contains(rightChild[i]))
    return false;

   if (rightChild[i] != -1) {
    if (prev > rightChild[i])
     return false;
    prev = rightChild[i];
   }
  }

  return true;
 }

}
