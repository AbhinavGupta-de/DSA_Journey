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

 private class Data {

  long min;
  long max;
  TreeNode node;
  boolean isValid;

  Data(TreeNode node, long min, long max, boolean isValid) {
   this.node = node;
   this.min = min;
   this.max = max;
   this.isValid = isValid;
  }

 }

 public Data isValid(TreeNode root) {
  if (root == null)
   return new Data(null, Long.MIN_VALUE, Long.MIN_VALUE, false);

  Data l = isValid(root.left);
  Data r = isValid(root.right);

  if ((l.isValid == false || r.isValid == false) || ((Long) root.val >= r.min && (Long) root.val <= l.max)) {
   return new Data(root, -1, -1, false);
  }

  return new Data(root, l.max, l.min, true);

 }

}
