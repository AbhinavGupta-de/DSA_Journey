package questions.tree.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import questions.tree.TreeNode;

public class ZigZagLevelOrderTraversal {
 public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
  List<List<Integer>> list = new ArrayList<>();
  zigzagLevelOrder(root, 0, list);
  for (int i = 0; i < list.size(); i++) {
   if (i % 2 != 0) {
    Collections.reverse(list.get(i));
   }
  }
  return list;
 }

 public void zigzagLevelOrder(TreeNode root, int level, List<List<Integer>> result) {
  if (root == null)
   return;

  if (result.size() == level) {
   List<Integer> list = new ArrayList<>();
   list.add((Integer) root.val);
   result.add(list);
  } else {
   result.get(level).add((Integer) root.val);
  }

  zigzagLevelOrder(root.left, level + 1, result);
  zigzagLevelOrder(root.right, level + 1, result);

 }
}
