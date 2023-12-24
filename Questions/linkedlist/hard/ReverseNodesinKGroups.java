package questions.linkedlist.hard;

public class ReverseNodesinKGroups {
 public ListNode reverseKGroups(ListNode head, int k) {
  ListNode current = head;
  ListNode next = null;
  ListNode prev = null;

  if (!Check(head, k)) {
   return head;
  }

  int count = 0;

  while (count < k && current != null) {
   next = current.next;
   current.next = prev;
   prev = current;
   current = next;
   count++;
  }

  if (next != null) {
   head.next = reverseKGroups(next, k);
  }

  return prev;
 }

 boolean Check(ListNode head, int k) {
  ListNode current = head;
  int count = 0;
  while (current != null && count < k) {
   current = current.next;
   count++;
  }
  return count == k;
 }
}
