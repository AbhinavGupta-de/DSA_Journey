package questions.tree.easy;

import questions.tree.TreeNode;

public class SymmetricTree {

 public boolean isSymmetric(TreeNode root) {

  if (root == null)
   return false;

  return checker(root.left, root.right);

 }

 public boolean checker(TreeNode root1, TreeNode root2) {

  if (root1 == null || root2 == null) {
   if (root1 == null && root2 == null)
    return true;

   return false;
  }

  if (root1.val != root2.val)
   return false;

  if (!checker(root1.left, root2.right))
   return false;

  if (!checker(root1.right, root2.left))
   return false;

  return true;

 }

}