package questions.linkedlist.medium;

import questions.linkedlist.ListNode;

public class OddEvenLinkedList {

 public ListNode oddEvenList(ListNode head) {

  if (head == null || head.next == null)
   return head;

  ListNode head2 = head.next;
  ListNode oddhead = head;
  ListNode evenHead = head.next;

  while (oddhead.next != null && oddhead.next.next != null) {

   oddhead.next = oddhead.next.next;
   evenHead.next = evenHead.next.next;
   oddhead = oddhead.next;
   evenHead = evenHead.next;

  }

  oddhead.next = head2;

  return head;
 }

}
