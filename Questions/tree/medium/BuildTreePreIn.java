package questions.tree.medium;

import questions.tree.TreeNode;

import java.util.*;

// * leetcode 105
public class BuildTreePreIn {
 public TreeNode buildTree(int[] preorder, int[] inorder) {

  HashMap<Integer, Integer> map = new HashMap<>();

  for (int i = 0; i < inorder.length; i++) {

   map.put(inorder[i], i);

  }

  TreeNode root = build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);

  return root;

 }

 public TreeNode build(int[] pO, int pOstart, int pOend, int[] iO, int iOstart, int iOend,
   HashMap<Integer, Integer> map) {

  if (pOstart > pOend || iOstart > iOend) {
   return null;
  }

  TreeNode root = new TreeNode(pO[pOstart]);
  int inRoot = map.get(root.val);

  int numsLeft = inRoot - iOstart;

  root.left = build(pO, pOstart + 1, pOstart + numsLeft, iO, iOstart, inRoot - 1, map);
  root.right = build(pO, pOstart + numsLeft + 1, pOend, iO, inRoot + 1, iOend, map);

  return root;

 }
}
