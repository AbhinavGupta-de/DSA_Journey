package tree.easy;

public class RangeSumOfBST {
 public int rangeSumBST(TreeNode root, int low, int high) {
  if(root == null ) return 0;
  return (root.val >= low && root.val < high) : root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
 }
}
