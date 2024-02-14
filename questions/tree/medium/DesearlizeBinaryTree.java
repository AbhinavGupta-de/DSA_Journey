package questions.tree.medium;

import questions.tree.TreeNode;
import java.util.*;

public class DesearlizeBinaryTree {
 public TreeNode deSearlize(ArrayList<Integer> list) {

  if (list.get(0) == -1 || list.size() == 0)
   return null;

  TreeNode root = new TreeNode(list.get(0));
  Queue<TreeNode> queue = new LinkedList<TreeNode>();
  queue.add(root);

  int index = 1;

  while (index < list.size() && !queue.isEmpty()) {

   int n = queue.size();

   for (int i = 0; i < n; i++) {

    TreeNode temp = queue.poll();

    if (list.get(index) > -1) {
     temp.left = new TreeNode(list.get(index));
     queue.add(temp.left);
    }

    index++;

    if (list.get(index) > -1) {
     temp.right = new TreeNode(list.get(index));
     queue.add(temp.right);
    }

    index++;
   }
  }
  return root;
 }
}
