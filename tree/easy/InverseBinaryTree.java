package tree.easy;

import tree.TreeNode;

/**
 * InverseBinaryTree
 */
public class InverseBinaryTree {

 public TreeNode inverseTree(TreeNode root) {
  inverse(root);
  return root;
 }

 public void inverse(TreeNode root) {
  if (root == null)
   return;

  swap(root);
  inverse(root.left);
  inverse(root.right);

 }

 public void swap(TreeNode root) {

  TreeNode temp = root.left;
  root.left = root.right;
  root.right = temp;

 }

}