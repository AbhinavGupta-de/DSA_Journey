package questions.linkedlist.medium;

public class CopyListWithRandomPointers {
 private class Node {
  int val;
  Node next;
  Node random;

  public Node(int val, Node next) {
   this.val = val;
   this.next = next;
   this.random = null;
  }
 }

 public Node copyRandomList(Node head) {

  if (head == null || head.next == null)
   return head;

  // * Inersert the new nodes between the current list nodes
  Node current = head;
  while (current != null) {
   Node newNode = new Node(current.val, current.next);
   current.next = newNode;
   current = newNode.next;
  }

  current = head;
  while (current != null) {
   if (current.random != null) {
    current.next.random = current.random.next;
   }

   current = current.next != null ? current.next.next : null;
  }

  Node oldList = head;
  Node newList = head.next;

  Node currentOld = oldList;
  Node currentNew = newList;

  while (currentOld != null) {
   currentOld.next = currentOld.next.next;
   currentNew.next = currentNew.next != null ? currentNew.next.next : null;
   currentOld = currentOld.next;
   currentNew = currentNew.next;
  }

  return newList;
 }

}
