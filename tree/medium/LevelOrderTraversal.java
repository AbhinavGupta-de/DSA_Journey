package tree.medium;

import tree.TreeNode;
import java.util.*;

public class LevelOrderTraversal {
 public List<List<Integer>> levelOrder(TreeNode root) {

  List<List<Integer>> result = new ArrayList<>();
  levelOrderTraversal(root, 0, result);
  return result;
 }

 public void levelOrderTraversal(TreeNode root, int level, List<List<Integer>> result) {

  if (root == null)
   return;

  if (result.size() == level) {
   List<Integer> list = new ArrayList<>();
   list.add((Integer) root.val);
   result.add(list);
  } else {
   result.get(level).add((Integer) root.val);
  }

  levelOrderTraversal(root.left, level + 1, result);
  levelOrderTraversal(root.right, level + 1, result);

 }

 public List<List<Integer>> levelOrderQueue(TreeNode root) {

  Queue<TreeNode> queue = new LinkedList<>();
  List<List<Integer>> result = new ArrayList<>();
  queue.add(root);

  while (!queue.isEmpty()) {

   List<Integer> list = new ArrayList<>();

   int size = queue.size();

   for (int i = 0; i < size; i++) {

    TreeNode current = queue.peek();
    queue.poll();

    if (root.left != null)
     queue.add(current.left);
    if (root.right != null)
     queue.add(current.right);

    list.add((Integer) current.val);

   }

   result.add(list);
  }

  return result;
 }

}
