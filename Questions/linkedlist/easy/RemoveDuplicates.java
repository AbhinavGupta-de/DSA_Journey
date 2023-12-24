package questions.linkedlist.easy;

public class RemoveDuplicates {
 // Remove duplicates from a sorted linked list

 private class ListNode {
  int val;
  ListNode next;

 }

 public ListNode deleteDuplicates(ListNode head) {
  if (head == null || head.next == null)
   return head;

  ListNode current = head;

  while (current != null && current.next != null) {
   if (current.val == current.next.val) {
    current.next = current.next.next;
   } else {
    current = current.next;
   }
  }

  return head;
 }
}
