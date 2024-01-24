package questions.tree.medium;

import questions.tree.TreeNode;

public class PsuedoPalindrome {

 public int pseudoPalindromicPaths(TreeNode root) {

  if (root == null)
   return 0;

  return count(root, 0);
 }

 public int count(TreeNode root, int num) {

  if (root == null)
   return 0;

  num = num ^ (1 << (Integer) root.val);

  if (root.left == null && root.right == null) {
   // counting bits
   // int count = 0;
   // while (num > 0) {
   // if ((num & 1) == 1)
   // count++;

   // num = num >> 1;
   // }

   // if (count < 2)
   // return 1;

   // return 0;

   if (num == 0 || ((num & (num - 1)) == 0))
    return 1;

   return 0;
  }

  return count(root.left, num) + count(root.right, num);

 }
}
