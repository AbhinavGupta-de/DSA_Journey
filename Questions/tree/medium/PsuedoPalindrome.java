package questions.tree.medium;

import questions.tree.TreeNode;

public class PsuedoPalindrome {

 public int psuedoPalindromePaths(TreeNode root) {

  if (root == null)
   return 0;

  return count(root, 0, 0);
 }

 public int count(TreeNode root, int num, int result) {

  if (root == null) {
   int count = 0;
   while (num > 0) {
    if ((num & 1) == 1)
     count++;

    num = num << 1;
   }

   if (count % 2 == 0)
    return result + 1;

   return result;
  }

  num = num ^ (1 << (Integer) root.val);

  count(root.left, num, result);
  count(root.right, num, result);

  return result;

 }

}
