package questions.tree.medium;

public class PopulatingNextRightPointer2 {

 private class Node {
  // public int val;
  public Node left;
  public Node right;
  public Node next;

 };

 public Node connect(Node root) {
  if (root == null)
   return root;

  if (root.left != null && root.right != null)
   root.left.next = root.right;

  if (root.left != null && root.right == null && root.next != null)
   root.left.next = getNext(root.next);

  if (root.right != null && root.next != null)
   root.right.next = getNext(root.next);

  connect(root.left);
  connect(root.right);

  return root;
 }

 private Node getNext(Node root) {
  if (root == null)
   return root;
  if (root.left != null)
   return root.left;
  if (root.right != null)
   return root.right;

  return getNext(root.next);
 }
}
