package questions.tree.easy;

import questions.tree.TreeNode;

public class BSTNodesInRange {
 public int numNodes(TreeNode A, int B, int C) {
  if (A == null)
   return 0;

  if ((Integer) A.val >= B && (Integer) A.val <= C) {
   return 1 + numNodes(A.left, B, C) + numNodes(A.right, B, C);
  }

  return numNodes(A.left, B, C) + numNodes(A.right, B, C);
 }
}
