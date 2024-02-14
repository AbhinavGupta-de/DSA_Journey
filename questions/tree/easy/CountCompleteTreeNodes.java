package questions.tree.easy;

import questions.tree.TreeNode;

public class CountCompleteTreeNodes {

 public int countNodes(TreeNode root) {

  if (root == null)
   return 0;

  int leftHeight = countLeftHeight(root);

  int rightHeight = countRightHeight(root);

  return (leftHeight == rightHeight) ? (2 << leftHeight) - 1 : 1 + countNodes(root.left) + countNodes(root.right);

 }

 public int countLeftHeight(TreeNode root) {
  int size = 0;

  TreeNode current = root.left;
  while (current != null) {
   size++;
   current = current.left;
  }
  return size;
 }

 public int countRightHeight(TreeNode root) {
  int size = 0;

  TreeNode current = root.right;

  while (current != null) {
   size++;
   current = current.right;
  }

  return size;
 }

}
