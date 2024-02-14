package questions.linkedlist.medium;

/**
 * ReorderList
 */
public class ReorderList {

 private class ListNode {
  ListNode next;
 }

 public void reorderList(ListNode head) {
  if (head == null || head.next == null) {
   return;
  }

  // Step 1: Find the middle of the list
  ListNode middle = findMiddle(head);

  // Step 2: Reverse the second half of the list
  ListNode reversed = reverse(middle.next);
  middle.next = null;

  // Step 3: Merge the two halves
  merge(head, reversed);
 }

 private ListNode findMiddle(ListNode head) {
  ListNode slow = head;
  ListNode fast = head;

  while (fast != null && fast.next != null) {
   slow = slow.next;
   fast = fast.next.next;
  }

  return slow;
 }

 private ListNode reverse(ListNode head) {
  ListNode prev = null;
  ListNode current = head;

  while (current != null) {
   ListNode next = current.next;
   current.next = prev;
   prev = current;
   current = next;
  }

  return prev;
 }

 private void merge(ListNode l1, ListNode l2) {
  while (l1 != null && l2 != null) {
   ListNode next1 = l1.next;
   ListNode next2 = l2.next;

   l1.next = l2;
   l2.next = next1;

   l1 = next1;
   l2 = next2;
  }
 }

}