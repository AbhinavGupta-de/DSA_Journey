package questions.tree.easy;

import questions.tree.TreeNode;

public class TreeDepth {
 public int maxDepth(TreeNode root) {
  if (root == null)
   return 0;

  return depth(root);
 }

 public int depth(TreeNode root) {
  if (root == null)
   return 0;

  int left = depth(root.left);
  int right = depth(root.right);

  int max = Math.max(left, right) + 1;

  return max;
 }
}
