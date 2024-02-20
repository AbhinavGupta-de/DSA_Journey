package questions.tree.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import questions.tree.TreeNode;

/*
 * AllNodesKDistanceBinaryTree
 * 
 * In these types of questions where I possibly need to iterate upwards again, like get that parent
 * I need to think like a way, that is create a Hashmap that conatins the parents of every node so that I could iterate in the map upwards direction.
 */
public class AllNodesKDistanceBinaryTree {
 public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

  // Create Parent Map
  HashMap<TreeNode, TreeNode> parentHashMap = new HashMap<>();
  createParentMap(root, parentHashMap);

  List<Integer> result = new ArrayList<>();
  HashSet<TreeNode> visited = new HashSet<>();
  findDistanceNodes(root, target, k, parentHashMap, visited, result);

  return result;
 }

 private void createParentMap(TreeNode root, HashMap<TreeNode, TreeNode> parentHashMap) {

  if (root == null)
   return;

  // if (root.left != null) {
  // parentHashMap.put(root.left, root);
  // createParentMap(root.left, parentHashMap);
  // }

  // if (root.right != null) {
  // parentHashMap.put(root.right, root);
  // createParentMap(root.right, parentHashMap);
  // }

  // Using queue
  Queue<TreeNode> q = new LinkedList<>();
  q.add(root);

  while (!q.isEmpty()) {
   int n = q.size();

   for (int i = 0; i < n; i++) {

    TreeNode current = q.poll();
    if (current.left != null) {
     parentHashMap.put(current.left, current);
     q.add(current.left);
    }

    if (current.right != null) {
     parentHashMap.put(current.right, current);
     q.add(current.right);
    }

   }

  }

 }

 private void findDistanceNodes(TreeNode root, TreeNode target, int k, HashMap<TreeNode, TreeNode> parentHashMap,
   HashSet<TreeNode> visited,
   List<Integer> result) {
  if (root == null)
   return;

  Queue<TreeNode> q = new LinkedList<>();
  q.add(target);
  int count = 0;

  visited.add(target);

  while (!q.isEmpty()) {

   if (count >= k)
    break;

   int n = q.size();

   for (int i = 0; i < n; i++) {
    TreeNode current = q.poll();
    visited.add(current);
    if (current.left != null && !visited.contains(current.left)) {
     q.add(current.left);
    }

    if (current.right != null && !visited.contains(current.right)) {
     q.add(current.right);
    }

    if (parentHashMap.containsKey(current) && !visited.contains(parentHashMap.get(current))) {
     q.add(parentHashMap.get(current));
    }
   }

   count++;
  }

  for (TreeNode temp : q) {
   result.add((Integer) temp.val);
  }

 }

}