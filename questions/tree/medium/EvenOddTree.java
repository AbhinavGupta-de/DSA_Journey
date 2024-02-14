package questions.tree.medium;

import questions.tree.TreeNode;

import java.util.*;

/**
 * EvenOddTree
 */
public class EvenOddTree {
 public boolean isEvenOddTree(TreeNode root) {
  Queue<TreeNode> queue = new LinkedList<TreeNode>();
  queue.add(root);

  if ((Integer) root.val % 2 == 0)
   return false;

  TreeNode prev = null;

  boolean isEven = false;

  while (!queue.isEmpty()) {

   int size = queue.size();

   isEven = !isEven;

   for (int i = 0; i < size; i++) {
    TreeNode current = queue.poll();

    if (current.left != null) {
     queue.add(current.left);
    }

    if (current.right != null) {
     queue.add(current.right);
    }

    if (isEven) {

     if ((Integer) current.val % 2 == 0) {
      return false;
     }

     if (i > 0) {
      if ((Integer) prev.val >= (Integer) current.val)
       return false;
     }

    } else {
     if ((Integer) current.val % 2 != 0) {
      return false;
     }

     if (i > 0) {
      if ((Integer) prev.val <= (Integer) current.val)
       return false;
     }
    }

    prev = current;
   }

  }
  return true;
 }
}