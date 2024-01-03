package questions.linkedlist.easy;

public class IntersectionTwoLinkedList {
 public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
  // * 1st appraoch is to iterate over the list and put it in map
  // * After putting in map iterate over the other list and find the one that is
  // * present in other one too otherwise return.

  int sizeA = getSize(headA);
  int sizeB = getSize(headB);

  if (sizeA > sizeB) {
   int diff = sizeA - sizeB;
   ListNode current = headA;
   while (diff > 0) {
    current = current.next;
    diff--;
   }

   return checker(current, headB);
  } else {
   int diff = sizeB - sizeA;
   ListNode current = headB;

   while (diff > 0) {
    current = current.next;
    diff--;
   }

   return checker(headA, current);
  }
 }

 public int getSize(ListNode head) {

  int size = 0;

  ListNode current = head;

  while (current != null) {
   current = current.next;
   size++;
  }

  return size;

 }

 public ListNode checker(ListNode head1, ListNode head2) {
  ListNode currentA = head1;
  ListNode currentB = head2;
  while (currentA != null) {
   if (currentA == currentB)
    return currentA;
   currentA = currentA.next;
   currentB = currentB.next;
  }

  return null;
 }

}
