package questions.linkedlist.medium;

import questions.linkedlist.ListNode;

public class RotateList {
 public ListNode rotateRight(ListNode head, int k) {

  int size = getSize(head);

  if (size == 0 || k == 0 || size == 1)
   return head;

  int remain = k % size;

  if (remain == 0)
   return head;

  ListNode slow = head;
  ListNode fast = head;

  for (int i = 0; i < remain; i++)
   fast = fast.next;

  while (fast.next != null) {
   slow = slow.next;
   fast = fast.next;
  }

  ListNode newHead = slow.next;
  slow.next = null;
  fast.next = head;

  return newHead;
 }

 public int getSize(ListNode head) {
  ListNode current = head;
  int count = 0;
  while (current != null) {
   count++;
   current = current.next;
  }

  return count;
 }
}
