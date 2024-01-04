package questions.linkedlist.medium;

import questions.linkedlist.ListNode;

public class ReverseListTwo {
 public ListNode reverseBetween(ListNode head, int left, int right) {

  left--;

  int k = right - left;

  if (k == 1)
   return head;

  if (left == 0)
   return reverseKGroups(head, right - left);

  ListNode current = head;
  for (int i = 1; i < left; i++) {
   current = current.next;
  }

  current.next = reverseKGroups(current.next, k);

  return head;
 }

 public ListNode reverseKGroups(ListNode head, int k) {

  if (!check(head, k))
   return head;

  ListNode current = head;
  ListNode prev = null;
  ListNode next = null;

  int count = 0;

  while (current != null && count < k) {
   next = current.next;
   current.next = prev;
   prev = current;
   current = next;
   count++;
  }

  head.next = next;

  return prev;
 }

 public boolean check(ListNode head, int k) {
  ListNode current = head;
  int count = 0;

  while (current != null) {
   count++;

   if (count == k)
    return true;

   current = current.next;
  }

  return false;
 }

}
