package tree.medium;

import questions.tree.TreeNode;

public class InsertRow {
 public TreeNode addOneRow(TreeNode root, int val, int depth) {
  if (root == null)
   return null;

  return addRow(root, val, depth);
 }

 private TreeNode addRow(TreeNode root, int val, int depth) {
  if (root == null)
   return root;

  if (depth == 1) {
   TreeNode newNode = new TreeNode(val);
   newNode.left = root;
   return newNode;
  }

  if (depth <= 2) {
   TreeNode nextLeft = root.left;
   TreeNode nextRight = root.right;
   TreeNode newLeft = new TreeNode(val);
   TreeNode newRight = new TreeNode(val);
   root.left = newLeft;
   root.right = newRight;
   newLeft.left = nextLeft;
   newRight.right = nextRight;
  } else {
   addRow(root.left, val, depth - 1);
   addRow(root.right, val, depth - 1);
  }

  return root;
 }
}
