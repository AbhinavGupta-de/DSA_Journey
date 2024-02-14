package questions.linkedlist.medium;

import questions.linkedlist.ListNode;

public class SwapNodesInPairs {

 public ListNode swapPairs(ListNode head) {
  if (head == null || head.next == null)
   return head;

  ListNode newNode = swapPairs(head.next.next);
  ListNode modifiedHead = head.next;
  head.next.next = head;
  head.next = newNode;

  return modifiedHead;
 }

}
