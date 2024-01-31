package questions.linkedlist.medium;

import questions.linkedlist.ListNode;

public class RemoveNodesFromLinkedList {

 // 5 2 13 3 8
 // 5 1 2 13 8 7 6 9

 public ListNode removeNodes(ListNode head) {
  if (head == null)
   return head;

  ListNode next = removeNodes(head.next);
  if (next == null || next.val < head.val) {
   head.next = next;
   return head;
  }

  return next;
 }

}
