package tree.easy;

import tree.TreeNode;

public class SearchInBinarySearchTree {

 public TreeNode searchBST(TreeNode root, int val) {

  if (root == null)
   return null;

  if ((Integer) root.val == val)
   return root;

  if (val > (Integer) root.val) {
   return searchBST(root.right, val);
  } else {
   return searchBST(root.left, val);
  }

 }

}
