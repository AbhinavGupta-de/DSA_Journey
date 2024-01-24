package questions.tree.medium;

import questions.tree.TreeNode;

public class CheckBST {

 // one solution
 public boolean isValidBST(TreeNode root) {
  return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
 }

 public boolean isValid(TreeNode root, long min, long max) {
  if (root == null)
   return true;

  if ((Long) root.val <= min || (Long) root.val >= max)
   return false;

  return isValid(root.left, min, (Long) root.val) && isValid(root.right, (Long) root.val, max);

 }

 // solution two
 private class Data {
  long min;
  long max;
  boolean isValid;

  Data(long min, long max, boolean isValid) {
   this.min = min;
   this.max = max;
   this.isValid = isValid;
  }
 }

 public Data isValid(TreeNode root) {
  if (root == null)
   return new Data(Long.MIN_VALUE, Long.MAX_VALUE, true);

  Data l = isValid(root.left);
  Data r = isValid(root.right);

  if (!l.isValid || !r.isValid || (long) root.val <= l.max || (long) root.val >= r.min) {
   return new Data(Long.MIN_VALUE, Long.MAX_VALUE, false);
  }

  return new Data(Math.max((Long) root.val, l.max), Math.min((Long) root.val, r.min), true);
 }

}
