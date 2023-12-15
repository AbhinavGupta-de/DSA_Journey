package Questions.LinkedLists.Medium;

public class RemoveKthFromBack {

 private class ListNode {
  ListNode next;

  ListNode() {

  }
 }

 public ListNode removeNthFromEnd(ListNode head, int n) {
  // int size = size(head);
  // int index = size - n;

  // if (n >= size) {
  // return removeFirst(head);
  // }

  // remove(head, index);

  // return head;

  ListNode start = new ListNode();
  start.next = head;
  ListNode slow = start;
  ListNode fast = start;

  for (int i = 1; i <= n; i++)
   fast = fast.next;

  while (fast.next != null) {
   fast = fast.next;
   slow = slow.next;
  }

  slow.next = slow.next.next;

  return head;

 }

 public void remove(ListNode head, int index) {
  ListNode current = head;
  ListNode prev = null;
  int count = 0;

  while (count < index) {
   prev = current;
   current = current.next;
   count++;
  }
  prev.next = current.next;
 }

 public ListNode removeFirst(ListNode head) {
  return head.next;
 }

 public int size(ListNode head) {
  ListNode current = head;
  int size = 0;

  while (current != null) {
   size++;
   current = current.next;
  }
  return size;
 }

}
