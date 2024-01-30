package questions.tree;

public class TreeNode {
 public Object val;

 public TreeNode left;
 public TreeNode right;

 public TreeNode() {
  val = null;
  left = null;
  right = null;
 }

 public TreeNode(Object val) {
  this.val = val;
 }

 public TreeNode(TreeNode left, TreeNode right) {
  this.left = left;
  this.right = right;
 }

 public TreeNode(Object val, TreeNode left, TreeNode right) {
  this.val = val;
  this.left = left;
  this.right = right;
 }

}
