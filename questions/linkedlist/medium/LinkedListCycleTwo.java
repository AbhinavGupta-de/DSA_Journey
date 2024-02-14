package questions.linkedlist.medium;

import questions.linkedlist.ListNode;

public class LinkedListCycleTwo {
 public ListNode detectCycle(ListNode head) {

  ListNode slow = head;
  ListNode fast = head;
  boolean cycle = false;

  while (fast != null && fast.next != null) {

   slow = slow.next;
   fast = fast.next.next;

   if (slow == fast) {
    cycle = true;
    break;
   }
  }

  slow = head;
  while (cycle) {
   if (slow == fast)
    return slow;

   slow = slow.next;
   fast = fast.next;
  }
  return null;
 }
}
