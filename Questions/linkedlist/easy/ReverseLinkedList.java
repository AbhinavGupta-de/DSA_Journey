package questions.linkedlist.easy;

class ListNode {
 int val;
 ListNode next;

 ListNode() {
 }

 ListNode(int val) {
  this.val = val;
 }

 ListNode(int val, ListNode next) {
  this.val = val;
  this.next = next;
 }
}

public class ReverseLinkedList {

 public ListNode reverseLinkedList(ListNode head) {

  ListNode prev = null;
  ListNode current = head;
  ListNode next = null;

  while (current != null) {
   next = current.next;
   current.next = prev;
   prev = current;
   current = next;
  }

  return prev;

 }

 // using recursion
 public ListNode reverse(ListNode head) {
  if (head == null || head.next == null)
   return head;

  ListNode p = reverse(head.next);
  head.next.next = head;
  head.next = null;
  return p;
 }

}
