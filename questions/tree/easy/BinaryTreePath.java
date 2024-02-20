package questions.tree.easy;

import java.util.ArrayList;
import java.util.List;

import questions.tree.TreeNode;

/*
 * 
 * What I failed in thinking was how do I create path at a particular node and then add it to the arraylist otherwise it is a simple problem.
 * 
 */

public class BinaryTreePath {

 public List<String> binaryTreePaths(TreeNode root) {
  List<String> answer = new ArrayList<>();
  sol(root, "", answer);
  return answer;
 }

 public void sol(TreeNode root, String path, List<String> answer) {
  if (root.left == null && root.right == null)
   answer.add(path + root.val);

  if (root.left != null)
   sol(root.left, path + root.val + "->", answer);
  if (root.right != null)
   sol(root.right, path + root.val + "->", answer);
 }

}
