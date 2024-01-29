package questions.tree.medium;

import questions.tree.TreeNode;

import java.util.*;

/**
 * SearlizeBinaryTree
 */
public class SearlizeBinaryTree {

 public ArrayList<Integer> solve(TreeNode A) {

  ArrayList<Integer> result = new ArrayList<>();

  Queue<TreeNode> queue = new LinkedList<TreeNode>();

  queue.add(A);

  int depth = depth(A);
  int index = 0;

  while (!queue.isEmpty() && index <= depth) {

   int size = queue.size();

   for (int i = 0; i < size; i++) {

    TreeNode curNode = queue.poll();

    if (curNode.left != null)
     queue.add(curNode.left);
    else {
     if ((Integer) curNode.val != -1) {
      queue.add(new TreeNode(-1));
     }
    }
    if (curNode.right != null)
     queue.add(curNode.right);
    else {
     if ((Integer) curNode.val != -1) {
      queue.add(new TreeNode(-1));
     }
    }

    result.add((Integer) curNode.val);

   }

  }
  return result;
 }

 private int depth(TreeNode root) {
  return (root == null) ? 0 : Math.max(depth(root.left), depth(root.right)) + 1;
 }
}