package questions.tree.hard;

import questions.tree.TreeNode;

public class HeightBalancedTree {

 private class Data {
  int height;
  boolean isBalanced;

  Data(int height, boolean isBalanced) {
   this.height = height;
   this.isBalanced = isBalanced;
  }
 }

 public boolean isBalanced(TreeNode root) {
  Data data = check(root);
  return data.isBalanced;
 }

 public Data check(TreeNode root) {
  if (root == null)
   return new Data(0, true);

  Data l = check(root.left);
  Data r = check(root.right);

  int height = Math.max(l.height, r.height) + 1;

  if (l.isBalanced && r.isBalanced && Math.abs(l.height - r.height) < 2) {
   return new Data(height, true);
  }

  return new Data(height, false);
 }

 // second method

 public int checker(TreeNode root) {
  if (root == null)
   return 0;

  int l = checker(root.left);
  int r = checker(root.right);

  int height = Math.max(l, r) + 1;

  if (l == -1 || r == -1 || Math.abs(l - r) >= 2) {
   return -1;
  }

  return height;

 }

}
