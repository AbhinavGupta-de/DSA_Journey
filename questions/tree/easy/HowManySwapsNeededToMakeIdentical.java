package questions.tree.easy;

import questions.tree.TreeNode;

public class HowManySwapsNeededToMakeIdentical {

 public int numSwaps(TreeNode rootA, TreeNode rootB) {

  if (rootA == null && rootB == null)
   return 0;
  if (rootA == null || rootB == null)
   return -1;

  if (rootA.val != rootB.val)
   return -1;

  int num1 = numSwaps(rootA.left, rootB.left);
  int num2 = numSwaps(rootA.right, rootB.right);

  if (num1 != -1 && num2 != -1) {
   return num1 + num2;
  }

  int num3 = numSwaps(rootA.left, rootB.right);
  int num4 = numSwaps(rootA.right, rootB.left);

  if (num3 == -1 || num4 == -1)
   return -1;

  return 1 + num3 + num4;

 }

}
