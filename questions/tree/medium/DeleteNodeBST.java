package questions.tree.medium;

import questions.tree.TreeNode;

public class DeleteNodeBST {
 public TreeNode deleteNode(TreeNode root, int key) {

  if (root == null)
   return null;

  if ((Integer) root.val > key) {
   root.left = deleteNode(root.left, key);
  }

  else if ((Integer) root.val < key) {
   root.right = deleteNode(root.right, key);
  }

  else {

   if (isLeaf(root))
    return null;

   if (root.left == null)
    return root.right;

   if (root.right == null)
    return root.left;

   else {

    int max = getMax(root.left);
    root.val = max;
    root.left = deleteNode(root.left, max);

   }

  }

  return root;

 }

 public boolean isLeaf(TreeNode root) {
  if (root.left == null && root.right == null)
   return true;

  return false;
 }

 public int getMax(TreeNode root) {
  while (root.right != null) {
   root = root.right;
  }

  return (Integer) root.val;
 }

}
