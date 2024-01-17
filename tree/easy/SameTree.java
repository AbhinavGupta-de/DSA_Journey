package tree.easy;

import tree.TreeNode;

public class SameTree {

 // * Fail Fast approach
 public boolean isSameTree(TreeNode p, TreeNode q) {
  return checker(p, q);
 }

 public boolean checker(TreeNode rootA, TreeNode rootB) {

  if (rootA == null || rootB == null) {
   if (rootA == null && rootB == null)
    return true;
   return false;
  }

  if (rootA.val != rootB.val)
   return false;

  if (!checker(rootA.left, rootB.left))
   return false;
  if (!checker(rootA.right, rootB.right))
   return false;

  return true;

 }
}
