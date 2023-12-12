package Questions.LinkedLists.Medium;

public class RemoveDuplicatesTwo {

 private class ListNode {
  int val;
  ListNode next;

 }

 public ListNode deleteDuplicates(ListNode head) {
  if (head == null || head.next == null)
   return head;

  ListNode current = head;
  ListNode prev = null;

  while (current != null && current.next != null) {
   if (current.val == current.next.val) {
    while (current.next != null && current.val == current.next.val) {
     current = current.next;
    }
    if (prev == null) {
     head = current.next;
    } else {
     prev.next = current.next;
    }
   } else {
    prev = current;
   }
   current = current.next;
  }

  return head;
 }

}
