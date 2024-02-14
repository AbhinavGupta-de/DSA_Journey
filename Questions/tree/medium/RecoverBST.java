package questions.tree.medium;

import questions.tree.TreeNode;

public class RecoverBST {
 TreeNode prev = null;
 TreeNode ans = null;
 TreeNode ans2 = null;

 public void recoverTree(TreeNode root) {

  inOrder(root);

  Integer temp = (Integer) ans.val;
  ans.val = ans2.val;
  ans2.val = temp;

 }

 public void inOrder(TreeNode root) {
  if (root == null)
   return;

  inOrder(root.left);

  if (prev != null) {
   if ((Integer) prev.val > (Integer) root.val) {
    if (ans == null) {
     ans = prev;
     ans2 = root;
    } else {
     ans2 = root;
    }
   }
  }

  prev = root;
  inOrder(root.right);

 }

}
