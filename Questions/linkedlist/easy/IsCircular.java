package questions.linkedlist.easy;

import questions.linkedlist.ListNode;

/**
 * IsCircular
 */
public class IsCircular {

 public boolean isCircular(ListNode head) {
  if (head == null)
   return false;

  ListNode slow = head;
  ListNode fast = head.next;

  while (slow.next != null && fast.next != null && fast.next.next != null) {
   if (slow == fast) {
    return true;
   }

   slow = slow.next;
   fast = fast.next.next;
  }
  return false;
 }

 public static void main(String[] args) {

 }
}