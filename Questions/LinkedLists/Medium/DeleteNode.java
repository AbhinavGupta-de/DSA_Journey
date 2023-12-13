package Questions.LinkedLists.Medium;

public class DeleteNode {

 private class ListNode {
  Object val;
  ListNode next;

  public ListNode(Object value) {
   this.val = value;
   next = null;
  }
 }

 public void deleteNode(ListNode node) {
  while (node.next != null && node.next.next != null) {
   node.val = node.next.val;
   node = node.next;
  }

  if (node.next != null && node.next.next == null) {
   node.val = node.next.val;
   node.next = null;
  }
 }
}
