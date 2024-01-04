package questions.linkedlist.easy;

import questions.linkedlist.ListNode;

public class LinkedListCycleII {

 public ListNode detectCycle(ListNode head) {
  if (head == null)
   return null;

  ListNode slow = head;
  ListNode fast = head;
  boolean x = false;

  while (slow.next != null && fast.next != null && fast.next.next != null) {
   if (slow == fast && x) {
    slow = head;
    while (true) {
     if (slow == fast)
      return slow;
     slow = slow.next;
     fast = fast.next;
    }
   }

   slow = slow.next;
   fast = fast.next.next;
   x = true;
  }
  return null;
 }
}
