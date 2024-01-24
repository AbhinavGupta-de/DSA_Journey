package questions.tree.medium;

/**
 * PopulatingNextRightPointer
 */
public class PopulatingNextRightPointer {

  private class Node {
    Node left;
    Node right;
    Node next;
  }

  public Node connect(Node root) {

    if (root == null || root.left == null)
      return root;

    root.left.next = root.right;

    if (root.next != null)
      root.right.next = root.next.left;

    connect(root.left);
    connect(root.right);

    return root;

  }

}