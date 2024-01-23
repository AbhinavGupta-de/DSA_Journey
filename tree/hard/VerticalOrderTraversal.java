package tree.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import tree.TreeNode;

public class VerticalOrderTraversal {

 public List<List<Integer>> verticalTraversal(TreeNode root) {
  TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();
  verticalTraversalHelper(root, 0, 0, map);

  List<List<Integer>> result = new ArrayList<>();

  for (Map.Entry<Integer, TreeMap<Integer, List<Integer>>> entry : map.entrySet()) {
   List<Integer> vertLevel = new ArrayList<>();
   TreeMap<Integer, List<Integer>> getMap = entry.getValue();

   for (List<Integer> list : getMap.values()) {
    vertLevel.addAll(list);
   }

   result.add(vertLevel);
  }

  return result;
 }

 private void verticalTraversalHelper(TreeNode root, int level, int distance,
   TreeMap<Integer, TreeMap<Integer, List<Integer>>> map) {

  if (root == null)
   return;

  if (map.containsKey(distance)) {
   TreeMap<Integer, List<Integer>> getMap = map.get(distance);

   if (getMap.containsKey(level)) {
    List<Integer> list = getMap.get(level);
    list.add((Integer) root.val);
    Collections.sort(list);
    getMap.put(level, list);
   } else {
    List<Integer> list = new ArrayList<>();
    list.add((Integer) root.val);
    getMap.put(level, list);
   }
  } else {
   List<Integer> list = new ArrayList<>();
   list.add((Integer) root.val);

   TreeMap<Integer, List<Integer>> getMap = new TreeMap<>();
   getMap.put(level, list);

   map.put(distance, getMap);
  }

  verticalTraversalHelper(root.left, level + 1, distance - 1, map);
  verticalTraversalHelper(root.right, level + 1, distance + 1, map);
 }
}
