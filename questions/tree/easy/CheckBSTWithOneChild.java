package questions.tree.easy;

import java.util.ArrayList;
import questions.tree.TreeNode;

/**
 * CheckBSTWithOneChild
 */

public class CheckBSTWithOneChild {

 public String checkOneChildBST(ArrayList<Integer> list) {

  TreeNode root = new TreeNode(list.get(0));

  TreeNode curr = root;

  for (int i = 1; i < list.size(); i++) {

   if (list.get(i) > (Integer) curr.val) {
    curr.right = new TreeNode(list.get(i));
   } else {
    curr.left = new TreeNode(list.get(i));
   }

   curr = (curr.left == null) ? curr.left : curr.right;

  }

 }

}
