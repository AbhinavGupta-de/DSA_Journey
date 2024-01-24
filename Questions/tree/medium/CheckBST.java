package questions.tree.medium;

import questions.tree.TreeNode;

public class CheckBST {

 public boolean isValidBST(TreeNode root) {
  return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
 }

 public boolean isValid(TreeNode root, long min, long max) {
  if (root == null)
   return true;

  if ((Long) root.val >= min || (Long) root.val >= max)
   return false;

  return isValid(root.left, min, (Long) root.val) && isValid(root.right, (Long) root.val, max);

 }

}
