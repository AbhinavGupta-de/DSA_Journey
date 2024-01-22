package tree.medium;

import tree.TreeNode;

public class InsertInBinaryTree {

 public TreeNode insertIntoBST(TreeNode root, int val) {

  if (root == null) {
   return new TreeNode(val);
  }

  if ((Integer) root.val > val) {
   root.left = insertIntoBST(root.left, val);
  } else {
   root.right = insertIntoBST(root.right, val);
  }

  return root;
 }
}
